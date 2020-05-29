package ais.parser.dao;

import org.apache.ibatis.session.SqlSession;
import ais.parser.JDBC.SqlMapClient;
import ais.parser.vo.Msg;
import ais.parser.vo.TableName;

public class MsgDAO {
  private static SqlSession session = SqlMapClient.getSqlSession();
  
  public String getServerTime() {
    return session.selectOne("SQL.getServerTime");
  }
  
  public Boolean isExistTable(TableName tableName) {
    return session.selectOne("SQL.isExistTable", tableName);
  }
  
  public int createTable(TableName tableName) {
    int result = session.update("SQL.createTable", tableName);
    //  session.commit(true) 하지 않으면 rollback됨.
    session.commit(true);
    return result;
  }
  
  
  public int insertMsg(TableName tableName, Msg message) {
    
    return 0;
  }

  
  public void endProccess() {
    session.close();
  }
}
