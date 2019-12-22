package utils;

import data.EmployeeSQLData;
import data.JobVacancySQLData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSqlDataProvider extends SqlDataProvider {
    public static List<EmployeeSQLData> employeePool = new ArrayList<>();

    public static void makeEmployeePool() {

        String empQuery = "SELECT hs_hr_employee.emp_number, hs_hr_employee.emp_firstname, hs_hr_employee.emp_lastname " +
                "FROM hs_hr_employee;";
        String vcQuery = "SELECT ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM ohrm_job_vacancy;";

        try (Connection con = DriverManager.getConnection(URL, DBNAME, DBPASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(empQuery)) {
            while (rs.next()) {
                EmployeeSQLData employee = new EmployeeSQLData();
                employee.setEmp_number(rs.getObject("emp_number").toString());
                employee.setEmp_firstname(rs.getObject("emp_firstname").toString());
                employee.setEmp_lastname(rs.getObject("emp_lastname").toString());
                employeePool.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(URL, DBNAME, DBPASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(vcQuery)) {
            while (rs.next()) {
                JobVacancySQLData vacancy = new JobVacancySQLData();
                vacancy.setHiring_manager_id(rs.getString("hiring_manager_id"));
                vacancy.setName(rs.getString("name"));
                for (EmployeeSQLData emp : employeePool) {
                    if (emp.getEmp_number().equals(rs.getString("hiring_manager_id"))) {
                        emp.addVacancy(vacancy);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static EmployeeSQLData getEmployeesByJobVacancyName (String jobVacancyName){
        List<EmployeeSQLData> employeesByVacancy = new ArrayList<>();
        String managerID = VacancySqlDataProvider.vacancyPool.stream()
                .filter(o -> o.getName().equals(jobVacancyName))
                .findFirst().map(JobVacancySQLData::getHiring_manager_id).get();
        return employeePool.stream().filter(o ->o.getEmp_number().equals(managerID)).findFirst().get();
    }
}