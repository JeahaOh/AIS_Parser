package ais.parser.JDBC;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ais.parser.dao.MsgDAO;
import ais.parser.vo.Msg;
import ais.parser.vo.TableName;

public class ConnectionTest {

  private static Logger logger = LoggerFactory.getLogger(ConnectionTest.class);

  public static String getConnectionTest() {
    MsgDAO dao = new MsgDAO();
    Boolean isExist = false;
    Map<String, Object> testResult = new HashMap<>();
    //SqlSession session = SqlMapClient.getSqlSession();
    
    String NOW = dao.getServerTime();
    logger.info("NOW : " + NOW);
    testResult.put("SERVER TIME", NOW);
    
    isExist = dao.isExistTable(new TableName(4401234, 20200528));
    testResult.put("TABLE EXIST TEST TRUE", isExist);
    
    isExist = dao.isExistTable(new TableName(4401234, 20200530));
    testResult.put("TABLE EXIST TEST FALSE", isExist);
    
    int result = dao.createTable(new TableName(4401234, 20200530));
    testResult.put("CREATE TABLE", result);
    
    
//    result = session.insert("SQL.insertMsg", null);
    
    
    
    dao.endProccess();
    return testResult.toString();
  }

  public static void main(String[] args) {
    System.out.println(logger);
    logger.trace("logger on");
     
    System.out.println(getConnectionTest());
  }
}
