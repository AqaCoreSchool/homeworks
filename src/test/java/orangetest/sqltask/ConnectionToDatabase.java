package orangetest.sqltask;

import java.sql.*;

public class ConnectionToDatabase {
    public static final String NAME = "tu05";
    public static final String PASSWORD = "5Qazwsx!";
    public static final String URL = "jdbc:mysql://test.biz.ua:3306/orangehrm_mysql";

    public Statement ConnectionToDatabase() throws SQLException {
        Connection con = DriverManager.getConnection(URL, NAME, PASSWORD);
        return con.createStatement();
    }
}
