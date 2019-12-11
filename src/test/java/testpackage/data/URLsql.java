package testpackage.data;

public class URLsql {

    private static String typeOfConnector ="jdbc";
    private static String dataBaseType = "mysql";
    private static String website = "/test.biz.ua";
    private static String host = "3306";
    private static String nameOfDataBase = "orangehrm_mysql";


    public String getURL(){
        return String.format("%s:%s:/%s:%s/%s", typeOfConnector, dataBaseType, website, host, nameOfDataBase);
    }
}
