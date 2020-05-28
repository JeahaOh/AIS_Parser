package ais.parser.JDBC;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionTest {

   private static Logger logger = LoggerFactory.getLogger(ConnectionTest.class);

  private static String getConnectionTest() {
    SqlSession session = SqlMapClient.getSqlSession();
    String NOW = session.selectOne("SQL.getServerTime");
     logger.info("NOW : " + NOW);
    session.close();
    return NOW;
  }

  public static void main(String[] args) {
     System.out.println(logger);
     logger.trace("logger on");
    System.out.println(getConnectionTest());
  }
}
