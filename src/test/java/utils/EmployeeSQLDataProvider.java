package utils;

import data.EmployeeSQLData;
import data.JobVacancySQLData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSQLDataProvider extends SQLDataProvider{
    public static List<EmployeeSQLData> employeePool = new ArrayList<>();

    public static void getEmployeePool() {

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

    public static List<JobVacancySQLData> getVacanciesByEmployeeName(String name, String surname){
        EmployeeSQLData employee = employeePool.stream()
                .filter(o -> o.getEmp_firstname().equals(name) && o.getEmp_lastname().equals(surname))
                .findFirst().get();
        return employee.getVacancies();
    }
}