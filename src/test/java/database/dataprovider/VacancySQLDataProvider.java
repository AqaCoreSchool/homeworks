package database.dataprovider;

import database.DataBaseManager;
import database.interfaces.VacancyDao;
import selenium.common.Utils;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VacancySQLDataProvider extends DataBaseManager implements VacancyDao {
    private List<Vacancy> vacancyList = new ArrayList<>();
    private String dbVacancyManager = Utils.getProperty("dbVacancyManager");
    private String dbVacancyName = Utils.getProperty("dbVacancyName");

    @Override
    public List<Vacancy> getVacanciesByEmployeeName(String name, String lastName) {
        String query = String.format("SELECT hs_hr_employee.emp_number, emp_firstname, emp_lastname," +
                " ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name FROM hs_hr_employee" +
                " INNER JOIN ohrm_job_vacancy ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id " +
                "WHERE hs_hr_employee.emp_firstname = '%s' AND hs_hr_employee.emp_lastname = '%s'", name, lastName);

        try(Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {
                Vacancy vacancy = new Vacancy();
                Candidate candidate = new Candidate();
                vacancy.setVacancyName(rs.getObject(dbVacancyName).toString());
                candidate.setCandidateFirstName(rs.getObject("emp_firstname").toString());
                candidate.setCandidateLastName(rs.getObject("emp_lastname").toString());
                candidate.setId(rs.getObject("emp_number").toString());
                vacancyList.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    public List<Vacancy> getVacancyList() {
        return vacancyList;
    }
}
