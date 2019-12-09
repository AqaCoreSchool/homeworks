import data.CandidateAttachment;
import data.JobCandidate;
import data.UserProfile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapping to POJO
 */
public class Example4 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://test.biz.ua:3306/orangehrm_mysql";

        String innerQuery1 = "SELECT ohrm_job_candidate.id, first_name, last_name, email, contact_number, " +
                "ohrm_job_candidate_attachment.file_name, ohrm_job_candidate_attachment.file_type " +
                "FROM ohrm_job_candidate " +
                "LEFT JOIN ohrm_job_candidate_attachment " +
                "ON ohrm_job_candidate.id=ohrm_job_candidate_attachment.candidate_id";

        List<JobCandidate> candidateList = new ArrayList<>();

        try(Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(innerQuery1)) {
            while(rs.next()) {
                JobCandidate candidate = new JobCandidate();
                CandidateAttachment attachment = new CandidateAttachment();

                candidate.setId(rs.getObject("id").toString());
                candidate.setFirstName(rs.getObject("first_name").toString());
                candidate.setLastName(rs.getObject("last_name").toString());
                candidate.setEmail(rs.getObject("email").toString());
                candidate.setContactNumber(rs.getObject("contact_number").toString());
                attachment.setFileName(rs.getObject("file_name"));
                attachment.setFileType(rs.getObject("file_type"));
                candidate.setAttachment(attachment);

                candidateList.add(candidate);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        candidateList.forEach(System.out::println);

        /*candidateList.stream()
                .filter(candidate -> !candidate.getAttachment().getFileName().isEmpty())
                .forEach(System.out::println);*/
    }
}
