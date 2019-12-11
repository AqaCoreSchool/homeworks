package database;

import selenium.common.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private String url = Utils.getProperty("dbUrl");
    private String user = Utils.getProperty("DBUserName");
    private String password = Utils.getProperty("DBUserPassword");

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
