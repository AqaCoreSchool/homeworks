package database.dataprovider;

import database.DataBaseManager;
import database.enums.VacancyColumnName;
import database.interfaces.EmployeeDAO;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VacancySQLDataProvider extends DataBaseManager implements EmployeeDAO {
    private List<Vacancy> vacancyList = new ArrayList<>();
    private EmployeeSQLDataProvider employee = new EmployeeSQLDataProvider();

    public void performQuery() {
        String query = String.format("SELECT %s, %s FROM ohrm_job_vacancy",
                VacancyColumnName.MANAGER_ID.toString(), VacancyColumnName.NAME.toString());

        select(query, rs -> {
            Vacancy vacancy = new Vacancy();
            vacancy.setHiringManager(rs.getString(VacancyColumnName.MANAGER_ID.toString()));
            vacancy.setVacancyName(rs.getString(VacancyColumnName.NAME.toString()));
            vacancyList.add(vacancy);
        });
    }

    @Override
    public List<Candidate> getEmployeesByJobVacancyName(String jobVacancyName) {
        performQuery();
        String id = vacancyList.stream()
                .filter(item -> item.getVacancyName().equals(jobVacancyName))
                .map(Vacancy::getHiringManager).findAny().orElse("Not Found");
        return employee.getCandidateList().stream()
                .filter(item -> item.getId().equals(id))
                .collect(Collectors.toList());
    }
}
