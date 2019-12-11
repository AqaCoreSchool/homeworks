package database.dataprovider;

import database.DataBaseManager;
import database.interfaces.EmployeeDao;
import selenium.common.Utils;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSQLDataProvider extends DataBaseManager implements EmployeeDao {
    private List<Candidate> candidateList = new ArrayList<>();
    private String dbEmpId = Utils.getProperty("dbEmpId");
    private String dbEmpFirstName = Utils.getProperty("dbEmpFirstName");
    private String dbEmpLastName = Utils.getProperty("dbEmpLastName");

    @Override
    public List<Candidate> getEmployeesByJobVacancyName(String jobVacancyName) {
        String query = String.format("SELECT hs_hr_employee.emp_number, emp_firstname, emp_lastname,\n" +
                "ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name\n" +
                "FROM hs_hr_employee\n" +
                "JOIN ohrm_job_vacancy\n" +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id\n" +
                "WHERE ohrm_job_vacancy.name = '%s'", jobVacancyName);

        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Candidate candidate = new Candidate();
                candidate.setId(rs.getObject(dbEmpId).toString());
                candidate.setCandidateFirstName(rs.getObject(dbEmpFirstName).toString());
                candidate.setCandidateLastName(rs.getObject(dbEmpLastName).toString());
                candidateList.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidateList;
    }
}
