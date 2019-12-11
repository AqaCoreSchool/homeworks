package orangetest.sqltask;

import java.sql.*;

public class ConnectionToDatabase extends DataProvider {

    public Statement ConnectionToDatabase() throws SQLException {
        Connection con = DriverManager.getConnection(URL, NAME, PASSWORD);
        return con.createStatement();
    }
}
