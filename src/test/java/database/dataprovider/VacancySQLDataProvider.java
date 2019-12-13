package database.dataprovider;

import database.DataBaseManager;
import database.interfaces.EmployeeDAO;
import selenium.common.Utils;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VacancySQLDataProvider extends DataBaseManager implements EmployeeDAO {
    private List<Vacancy> vacancyList = new ArrayList<>();
    private EmployeeSQLDataProvider employee = new EmployeeSQLDataProvider();
    private String dbVacancyManager = Utils.getProperty("dbVacancyManager");
    private String dbVacancyName = Utils.getProperty("dbVacancyName");

    public void getData() {
        String query = String.format("SELECT %s, %s FROM ohrm_job_vacancy",
                dbVacancyManager, dbVacancyName);

        try(Connection connection = getConnection()) {
            performQuery(connection, query, rs -> {
                Vacancy vacancy = new Vacancy();
                vacancy.setHiringManager(rs.getString(dbVacancyManager));
                vacancy.setVacancyName(rs.getString(dbVacancyName));
                vacancyList.add(vacancy);
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEmployeeId(String jobVacancyName) {
        return vacancyList.stream()
                .filter(item -> item.getVacancyName().equals(jobVacancyName))
                .map(Vacancy::getHiringManager).findAny().orElse("Not Found");
    }

    @Override
    public List<Candidate> getEmployeesByJobVacancyName(String jobVacancyName) {
        getData();
        return employee.getCandidateList().stream()
                .filter(item -> item.getId().equals(getEmployeeId(jobVacancyName)))
                .collect(Collectors.toList());
    }
}
