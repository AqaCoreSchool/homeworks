package database.dataprovider;

import database.DataBaseManager;
import database.interfaces.VacancyDAO;
import selenium.common.Utils;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSQLDataProvider extends DataBaseManager implements VacancyDAO {
    private List<Candidate> candidateList = new ArrayList<>();
    private Candidate candidate;
    private String dbEmpId = Utils.getProperty("dbEmpId");
    private String dbEmpFirstName = Utils.getProperty("dbEmpFirstName");
    private String dbEmpLastName = Utils.getProperty("dbEmpLastName");
    private String dbVacancyManager = Utils.getProperty("dbVacancyManager");
    private String dbVacancyName = Utils.getProperty("dbVacancyName");

    public void getData() {
        String candidateQuery = String.format("SELECT %s, %s, %s FROM hs_hr_employee",
                dbEmpId, dbEmpFirstName,dbEmpLastName);

        try (Connection connection = getConnection()) {
            performQuery(connection, candidateQuery, rs -> {
                Candidate candidate = new Candidate();
                candidate.setId(rs.getString(dbEmpId));
                candidate.setCandidateFirstName(rs.getString(dbEmpFirstName));
                candidate.setCandidateLastName(rs.getString(dbEmpLastName));
                candidateList.add(candidate);
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String vacancyQuery = String.format("SELECT %s, %s FROM ohrm_job_vacancy",
                dbVacancyManager, dbVacancyName);

        try (Connection connection = getConnection()) {
            performQuery(connection, vacancyQuery, rs -> {
                Vacancy vacancy = new Vacancy();
                vacancy.setHiringManager(rs.getString(dbVacancyManager));
                vacancy.setVacancyName(rs.getString(dbVacancyName));
                for (Candidate candidate : candidateList) {
                    if (candidate.getId().equals(rs.getString(dbVacancyManager))) {
                        candidate.setVacancies(vacancy);
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCandidate(String name, String lastName) {
        candidate = getCandidateList().stream()
                .filter(item -> item.getCandidateFirstName().equals(name))
                .filter(item -> item.getCandidateLastName().equals(lastName))
                .findFirst().get();
    }

    public List<Candidate> getCandidateList() {
        getData();
        return candidateList;
    }

    public List<Vacancy> getVacanciesByEmployeeName(String name, String lastName) {
        selectCandidate(name, lastName);
        return candidate.getVacancies();
    }

}
