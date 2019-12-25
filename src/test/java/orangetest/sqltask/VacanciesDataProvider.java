package orangetest.sqltask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VacanciesDataProvider {
    public List<JobVacancy> getVacancyListByEmployeeNum(String employeeNumber) {
        String queryMain = "SELECT  ohrm_job_vacancy.id, ohrm_job_vacancy.name," +
                " ohrm_job_title.job_title FROM ohrm_job_vacancy" +
                " LEFT JOIN ohrm_job_title " +
                "ON ohrm_job_vacancy.job_title_code = ohrm_job_title.id" +
                " WHERE ohrm_job_vacancy.hiring_manager_id=" + employeeNumber;

        List<JobVacancy> jobVacancyList = new ArrayList<>();
        ConnectionToDatabase connection = new ConnectionToDatabase();
        try (ResultSet rs = connection.ConnectionToDatabase().executeQuery(queryMain)) {
            while (rs.next()) {
                JobVacancy jobVacancy = new JobVacancy();
                jobVacancy.setId(rs.getObject("id").toString());
                jobVacancy.setJobTitle(rs.getObject("job_title").toString());
                jobVacancy.setVacancyName(rs.getObject("name").toString());
                jobVacancyList.add(jobVacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobVacancyList;
    }

    public List<JobVacancy> getVacancies() {
        String vacancyListQuery = "SELECT " +
                "ohrm_job_vacancy.id, ohrm_job_vacancy.name, " +
                "hs_hr_employee.emp_firstname, hs_hr_employee.emp_lastname, " +
                "hs_hr_employee.emp_number, ohrm_job_title.job_title " +
                "FROM ohrm_job_vacancy" +
                " LEFT JOIN hs_hr_employee " +
                "ON ohrm_job_vacancy.hiring_manager_id=hs_hr_employee.emp_number" +
                " LEFT JOIN ohrm_job_title " +
                "ON ohrm_job_vacancy.job_title_code = ohrm_job_title.id";

        List<JobVacancy> vacancyList = new ArrayList<>();
        ConnectionToDatabase connection = new ConnectionToDatabase();
        try (ResultSet rs = connection.ConnectionToDatabase().executeQuery(vacancyListQuery)) {
            while (rs.next()) {
                JobVacancy vacancy = new JobVacancy();
                vacancy.setId(rs.getObject("id").toString());
                vacancy.setJobTitle(rs.getObject("job_title").toString());
                vacancy.setVacancyName(rs.getObject("name").toString());
                vacancy.setHiringManager(rs.getObject("emp_firstname") + " " + rs.getObject("emp_lastname"));
                vacancyList.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    public List<JobVacancy> getVacanciesByEmployeeName(List<JobVacancy> vacancies, String firstName, String lastName) {
        return vacancies.stream().filter(o -> o.getHiringManager()
                .contains(firstName + " " + lastName))
                .collect(Collectors.toList());
    }

    public List<JobVacancy> getVacanciesByVacancyName(List<JobVacancy> vacancies, String name) {
        return vacancies.stream().filter(o -> o.getVacancyName()
                .contains(name))
                .collect(Collectors.toList());
    }

    public static String printVacancyListToString(List<JobVacancy> vacancies) {
        return vacancies.stream().map(JobVacancy::toShortString).collect(Collectors.joining("\n      "));
    }
}
