package database.dataprovider;

import database.DataBaseManager;
import database.enums.EmployeeColumnName;
import database.enums.VacancyColumnName;
import database.interfaces.VacancyDAO;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSQLDataProvider extends DataBaseManager implements VacancyDAO {
    private List<Candidate> candidateList = new ArrayList<>();

    public void performQueries() {
        String candidateQuery = String.format("SELECT %s, %s, %s FROM hs_hr_employee",
                EmployeeColumnName.ID.toString(), EmployeeColumnName.FIRST_NAME.toString(),
                EmployeeColumnName.LAST_NAME.toString());

        select(candidateQuery, rs -> {
            Candidate candidate = new Candidate();
            candidate.setId(rs.getString( EmployeeColumnName.ID.toString()));
            candidate.setCandidateFirstName(rs.getString(EmployeeColumnName.FIRST_NAME.toString()));
            candidate.setCandidateLastName(rs.getString(EmployeeColumnName.LAST_NAME.toString()));
            candidateList.add(candidate);
        });

        String vacancyQuery = String.format("SELECT %s, %s FROM ohrm_job_vacancy",
                VacancyColumnName.MANAGER_ID.toString(), VacancyColumnName.NAME.toString());

        select(vacancyQuery, rs -> {
            Vacancy vacancy = new Vacancy();
            vacancy.setHiringManager(rs.getString(VacancyColumnName.MANAGER_ID.toString()));
            vacancy.setVacancyName(rs.getString(VacancyColumnName.NAME.toString()));
            for (Candidate candidate : candidateList) {
                if (candidate.getId().equals(rs.getString(VacancyColumnName.MANAGER_ID.toString()))) {
                    candidate.setVacancies(vacancy);
                }
            }
        });
    }

    public List<Candidate> getCandidateList() {
        performQueries();
        return candidateList;
    }

    public List<Vacancy> getVacanciesByEmployeeName(String name, String lastName) {
         return getCandidateList().stream()
                .filter(item -> item.getCandidateFirstName().equals(name))
                .filter(item -> item.getCandidateLastName().equals(lastName))
                .findFirst().get().getVacancies();
    }
}
