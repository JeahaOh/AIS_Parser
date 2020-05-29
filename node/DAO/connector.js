const { Client } = require('pg');
const db = require('./accessInfo');

const client = new Client(db);
client.connect();

let exData = {
  msg_id: 0,
  mmsi: 0,
  chnnl: 'A',
  rcrd_time: 20200529144621,
  geom: 'POINT (127.1000292 37.4038401)',
  geom_lo: 127.1000292,
  geom_la: 37.4038401,
  geom_al: 30,
  cog: 0,
  sog: 0,
  hdg: 0,
  rot: 0,
  bsid: 4401234,
  int_date: 20200529
}

const connectionTest = () => {
  const cont = "SELECT NOW() AS NOW";
  client.query(cont, (err, res) => {
    if (err) console.log('connectionTest ERR : ', err);
    else console.log('connection test RES : ', res.rows[0]);
  });
};

const insertMsg = msg => {
  const { msg_id, mmsi, chnnl, rcrd_time, geom, geom_lo, geom_la, geom_al, cog, sog, hdg, rot, bsid, int_date } = msg;

  const tableName = 'msg_' + bsid + '_' + int_date;

  const createTableName = 'ais.' + tableName;

  //  쿼리 준비
  const existQuery = `SELECT (CASE WHEN COUNT(*) = 1 THEN TRUE ELSE FALSE END) AS ISEXIST FROM PG_TABLES AS TABS WHERE TABS.SCHEMANAME = 'ais' AND  TABS.TABLENAME = \'${tableName}\'`;
  const createQuery = 'CREATE TABLE IF NOT EXISTS ' + createTableName + ' ( LIKE AIS.MSG_BSID_DATE INCLUDING ALL )';
  const insertQuery = `INSERT INTO ${createTableName} (msg_id, mmsi, chnnl, rcrd_time, geom, geom_lo, geom_la, geom_al, cog, sog, hdg, rot) VALUES
  ( ${msg_id}, ${mmsi}, '${chnnl}', TO_TIMESTAMP( '${rcrd_time}', 'YYYYMMDDHH24MISS' )::timestamp, st_geomfromtext('SRID=4326;${geom}'), ${geom_lo}, ${geom_la}, ${geom_al}, ${cog}, ${sog}, ${hdg}, ${rot});`;

  const existCheck = () => new Promise((resolve, reject) => {
    //  테이블 있는지 확인.
    client.query(existQuery, (err, res) => {
      console.log('\n:: is Exist Table ::')
      console.log(existQuery);
      if (err) console.log('\t\t!! isExistTable ERR : ', err);
      else {
        console.log(`res : ${res.rows[0].boolean}`);
        resolve(res.rows[0].boolean);
      }
    });
  });

  const createTable = () => new Promise((resolve, reject) => {
    client.query(createQuery, (err, res) => {
      console.log('\n:: Create Table ::')
      console.log(createQuery);
      if (err) {
        console.log('\t\t!! createTable ERR : ', err);
        return reject(false);
      } else {
        console.log(`res : `, res.command);
        return resolve(true);
      }
    });
  });

  const insert = () => new Promise((resolve, reject) => {
    client.query(insertQuery, (err, res) => {
      console.log('\n:: Insert Message ::')
      console.log(insertQuery);
      if (err) {
        console.log('\t\t!! Insert Message ERR : ', err);
        if (err.code == 23505) resolve(true);
        return reject(false);
      } else {
        console.log(`result : ${res.command}, ${res.rowCount}`);
        return resolve(true);
      }
    });
  });

  existCheck()
    .then(exist => {
      //  없다면 테이블 생성
      return (!exist) ? createTable() : true;
    }).then(result => {
      if (result) insert();
    });
};

insertMsg(exData);
