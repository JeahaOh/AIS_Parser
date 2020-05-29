package ais.parser.vo;

public class TableName {
  int bsid;
  int date;
  String tableNme;
  String createName;

  public String getTableName() {
    return "msg_" + this.bsid + "_" + this.date;
  }
  public String getCreateName() {
    return "ais.msg_" + this.bsid + "_" + this.date;
  }
  
  public int getBsid() {
    return bsid;
  }
  public void setBsid(int bsid) {
    this.bsid = bsid;
  }
  public int getDate() {
    return date;
  }
  public void setDate(int date) {
    this.date = date;
  }
  
  @Override
  public String toString() {
    return "TableName [bsid=" + bsid + ", date=" + date + "]";
  }
  public TableName() { }
  public TableName(int bsid, int date) {
    super();
    this.bsid = bsid;
    this.date = date;
  }
  
  
}
