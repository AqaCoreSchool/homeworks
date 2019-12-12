package example;

import example.data.UserProfile;

import java.sql.*;

/**
 * JOIN Example
 */
public class Example3 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://test.biz.ua:3306/orangehrm_mysql";

        String innerQuery1 = "SELECT ohrm_job_candidate.id, " +
                "ohrm_job_candidate.first_name, " +
                "ohrm_job_candidate.last_name, ' % ', ohrm_job_candidate_attachment.file_name, ohrm_job_candidate_attachment.file_type " +
                "FROM ohrm_job_candidate INNER JOIN ohrm_job_candidate_attachment ON ohrm_job_candidate.id=ohrm_job_candidate_attachment.candidate_id";

        String leftQuery2 = "SELECT ohrm_job_candidate.id, " +
                "ohrm_job_candidate.first_name, " +
                "ohrm_job_candidate.last_name, ' % ', ohrm_job_candidate_attachment.file_name, ohrm_job_candidate_attachment.file_type " +
                "FROM ohrm_job_candidate LEFT JOIN ohrm_job_candidate_attachment ON ohrm_job_candidate.id=ohrm_job_candidate_attachment.candidate_id";

        String rightQuery3 = "SELECT ohrm_job_candidate.id, " +
                "ohrm_job_candidate.first_name, " +
                "ohrm_job_candidate.last_name, ' % ', ohrm_job_candidate_attachment.file_name, ohrm_job_candidate_attachment.file_type " +
                "FROM ohrm_job_candidate RIGHT JOIN ohrm_job_candidate_attachment ON ohrm_job_candidate_attachment.candidate_id=ohrm_job_candidate.id";

        String outerQuery4 = leftQuery2 + " UNION " + rightQuery3;

        try(Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(leftQuery2)) {
            while(rs.next()) {
                for(int i = 1; i <=6; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}