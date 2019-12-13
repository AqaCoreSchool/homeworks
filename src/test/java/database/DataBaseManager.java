package database;

import database.interfaces.ResultSetHandler;
import selenium.common.Utils;

import java.sql.*;

public class DataBaseManager {
    private String url = Utils.getProperty("dbUrl");
    private String user = Utils.getProperty("DBUserName");
    private String password = Utils.getProperty("DBUserPassword");

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void performQuery(Connection connection, String sql, ResultSetHandler handler) {
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ps.setFetchSize(10);
            while (rs.next()) {
                handler.handle(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
