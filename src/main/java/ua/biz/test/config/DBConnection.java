package ua.biz.test.config;

import ua.biz.test.data.TableAccess;
import ua.biz.test.data.DBCredential;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private Connection connection;

    public void getDBConnection() {
        try {
            connection = DriverManager.getConnection(TableAccess.URL, DBCredential.NAME, DBCredential.PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connection was not created!");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
