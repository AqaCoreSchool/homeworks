package example;

import example.data.UserProfile;

import java.sql.*;

public class Example2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://test.biz.ua:3306/orangehrm_mysql";
        String query1 = "SELECT id, first_name, last_name, email, contact_number FROM ohrm_job_candidate";
        String query2 = "SELECT DISTINCT first_name, last_name, email, contact_number FROM ohrm_job_candidate " +
                "WHERE email LIKE '%@gmail%' ORDER BY first_name ASC";

        try(Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query1)) {
            while(rs.next()) {
                for(int i = 1; i <= 4; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
