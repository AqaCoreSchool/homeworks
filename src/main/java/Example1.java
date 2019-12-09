import data.UserProfile;

import java.sql.*;

public class Example1 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://test.biz.ua:3306/orangehrm_mysql";

        try(Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ohrm_job_candidate")) {
                while(rs.next()) {
                    System.out.println(rs.getString(1) + "\t" +
                            rs.getString(2) + "\t " +
                            rs.getString(3) + "\t" +
                            rs.getString(4) + "\t\t" +
                            rs.getString(5));
                }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

