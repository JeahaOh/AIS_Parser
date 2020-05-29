package ais.parser.vo;

public class Msg {
  int msg_id;
  int mmsi;
  char chnnl;
  long rcrd_time;
  String geom;
  float geom_lo;
  float geom_la;
  float geom_al;
  int cog;
  int sog;
  int hdg;
  int rot;
  
  TableName tableName;
  
  
  public Msg() { }
  public Msg(int msg_id, int mmsi, char chnnl, long rcrd_time, String geom, float geom_lo,
      float geom_la, float geom_al, int cog, int sog, int hdg, int rot) {
    super();
    this.msg_id = msg_id;
    this.mmsi = mmsi;
    this.chnnl = chnnl;
    this.rcrd_time = rcrd_time;
    this.geom = geom;
    this.geom_lo = geom_lo;
    this.geom_la = geom_la;
    this.geom_al = geom_al;
    this.cog = cog;
    this.sog = sog;
    this.hdg = hdg;
    this.rot = rot;
  }
  
  public void setTableName( TableName tableName) {
    this.tableName = tableName;
  }
  
  public int getMsg_id() {
    return msg_id;
  }
  public void setMsg_id(int msg_id) {
    this.msg_id = msg_id;
  }
  public int getMmsi() {
    return mmsi;
  }
  public void setMmsi(int mmsi) {
    this.mmsi = mmsi;
  }
  public char getChnnl() {
    return chnnl;
  }
  public void setChnnl(char chnnl) {
    this.chnnl = chnnl;
  }
  public long getRcrd_time() {
    return rcrd_time;
  }
  public void setRcrd_time(long rcrd_time) {
    this.rcrd_time = rcrd_time;
  }
  public String getGeom() {
    return geom;
  }
  public void setGeom(String geom) {
    this.geom = geom;
  }
  public float getGeom_lo() {
    return geom_lo;
  }
  public void setGeom_lo(float geom_lo) {
    this.geom_lo = geom_lo;
  }
  public float getGeom_la() {
    return geom_la;
  }
  public void setGeom_la(float geom_la) {
    this.geom_la = geom_la;
  }
  public float getGeom_al() {
    return geom_al;
  }
  public void setGeom_al(float geom_al) {
    this.geom_al = geom_al;
  }
  public int getCog() {
    return cog;
  }
  public void setCog(int cog) {
    this.cog = cog;
  }
  public int getSog() {
    return sog;
  }
  public void setSog(int sog) {
    this.sog = sog;
  }
  public int getHdg() {
    return hdg;
  }
  public void setHdg(int hdg) {
    this.hdg = hdg;
  }
  public int getRot() {
    return rot;
  }
  public void setRot(int rot) {
    this.rot = rot;
  }
  @Override
  public String toString() {
    return "Msg [msg_id=" + msg_id + ", mmsi=" + mmsi + ", chnnl=" + chnnl + ", rcrd_time="
        + rcrd_time + ", geom=" + geom + ", geom_lo=" + geom_lo + ", geom_la=" + geom_la
        + ", geom_al=" + geom_al + ", cog=" + cog + ", sog=" + sog + ", hdg=" + hdg + ", rot=" + rot
        + ", tableName=" + tableName + "]";
  }

  
}
