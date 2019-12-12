package sql.dataprovider;

import sql.data.Employee;
import sql.data.JobVacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSQLDataProvider extends SQLDataProvider{


    public List<Employee> getEmployeeList() {

        String innerQuery = "SELECT DISTINCT hs_hr_employee.emp_number, " +
                "hs_hr_employee.emp_firstname, " +
                "hs_hr_employee.emp_lastname, ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM hs_hr_employee INNER JOIN ohrm_job_vacancy " +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id";

        List<Employee> employeeList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, NAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(innerQuery)) {
            while (rs.next()) {

                Employee employee = new Employee();
                JobVacancy jobVacancy = new JobVacancy();

                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setEmpFirstName(rs.getObject("emp_firstname").toString());
                employee.setEmpLastName(rs.getObject("emp_lastname").toString());
                jobVacancy.setHiringManagerId(rs.getObject("hiring_manager_id").toString());
                jobVacancy.setName(rs.getObject("name").toString());
                employee.setVacancies(getVacancyListByHiringManagerId(rs.getObject("hiring_manager_id").toString()));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<JobVacancy> getVacancyListByHiringManagerId(String managerId) {
        String queryMain = "SELECT  ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name" +
                " FROM ohrm_job_vacancy" +
                " WHERE ohrm_job_vacancy.hiring_manager_id=" + managerId;

        List<JobVacancy> vacancyList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, NAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(queryMain)) {
            while (rs.next()) {
                JobVacancy vacancy = new JobVacancy();
                vacancy.setHiringManagerId(rs.getObject("hiring_manager_id").toString());
                vacancy.setName(rs.getObject("name").toString());
                vacancyList.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }


    public List<Employee> getEmployeesByJobVacancyName(List<Employee> employeeList, String jobVacancyName) {
        return employeeList.stream()
                .filter(e -> e.getVacancies()
                        .stream()
                        .anyMatch(jobVacancy -> jobVacancy.getName().equalsIgnoreCase(jobVacancyName)))
                .collect(Collectors.toList());
    }
}

