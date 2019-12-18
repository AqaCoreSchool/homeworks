package ua.biz.test.config;

import ua.biz.test.data.DBCredential;
import ua.biz.test.data.TableAccess;
import ua.biz.test.pojo.Employee;
import ua.biz.test.pojo.JobVacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSQLDataProvider {
    private List<Employee> employees;

    public EmployeeSQLDataProvider() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public EmployeeSQLDataProvider fetchEmployeeList() {
        try (Connection con = DriverManager.getConnection(TableAccess.URL, DBCredential.NAME, DBCredential.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + TableAccess.TABLE1)) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setNumber(rs.getString(1));
                employee.setFirstName(rs.getString(4));
                employee.setLastName(rs.getString(3));

                employees.add(employee);
                System.out.println(employee);
            }
        } catch (SQLException e) {
            System.out.println("employee " + e.getMessage());
        }
        return this;
    }

    public List<Employee> getEmployeesByJobVacancyName(String jobVacancyName) {
        List<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            for (JobVacancy vacancy : employee.getVacancies()) {
                if (vacancy.getName().equals(jobVacancyName)) {
                    result.add(employee);
                }
            }
        }
        return result;
    }
}
