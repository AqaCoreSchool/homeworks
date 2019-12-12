package example;


import example.data.UserProfile;

import java.sql.*;

public class Example1 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://test.biz.ua:3306/orangehrm_mysql";

        try(Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url)) {
            while(rs.next()) {
                for(int i = 1; i <=6; i++) {
                    System.out.println(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}