package sql.dataprovider;

import sql.data.Employee;
import sql.data.JobVacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancySQLDataProvider extends SQLDataProvider{

    public List<JobVacancy> getVacancyList(){

        String query = "SELECT hs_hr_employee.emp_number, " +
                "hs_hr_employee.emp_firstname, " +
                "hs_hr_employee.emp_lastname, ' % ', ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM hs_hr_employee INNER JOIN ohrm_job_vacancy " +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id";

        List<JobVacancy> vacancyList = new ArrayList<>();

        try(Connection con = DriverManager.getConnection(URL, NAME, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {
                JobVacancy jobVacancy = new JobVacancy();
                jobVacancy.setHiringManagerId(rs.getObject("hiring_manager_id").toString());
                jobVacancy.setName(rs.getObject("name").toString());
                vacancyList.add(jobVacancy);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    public List<JobVacancy> getVacanciesByEmployeeName(List<Employee> employeeList, String name, String lastName){
        return employeeList.stream()
                .filter(employee -> employee.getEmpFirstName().equalsIgnoreCase(name))
                .filter(employee -> employee.getEmpLastName().equalsIgnoreCase(lastName))
                .findAny().get()
                .getVacancies();
    }
}
