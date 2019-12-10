package com.company.sqlTest.dataProvider;

import com.company.sqlTest.data.Employee;
import com.company.sqlTest.data.URLClass;
import com.company.sqlTest.data.UserProfile;
import com.company.sqlTest.data.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSQLDataProvider {
    Employee employee = new Employee();
    Vacancy vacancy = new Vacancy();
    URLClass urlClass = new URLClass();
    String url = urlClass.getURL();

    public void mapEmployee() {

        String employeeQuery = "SELECT emp_number, emp_firstname, emp_lastname " +
                "FROM hs_hr_employee ORDER BY emp_firstname ASC";

        try (Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(employeeQuery)) {
            while(rs.next()) {
                for(int i = 1; i <= 3; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Employee> getEmployeesByJobVacancyName(String jobVacancyName) {

        String getEmployeeByVacancyQuery = String.format("SELECT hs_hr_employee.emp_number, emp_firstname, emp_lastname, " +
                "ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM hs_hr_employee " +
                "INNER JOIN ohrm_job_vacancy " +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id " +
                "WHERE ohrm_job_vacancy.name = '%s' ", jobVacancyName);

        List<Employee> employeeList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(getEmployeeByVacancyQuery)) {
            while (rs.next()) {

                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setFirstName(rs.getObject("emp_firstname").toString());
                employee.setLastName(rs.getObject("emp_lastname").toString());
                vacancy.setHrId(rs.getString("hiring_manager_id"));
                vacancy.setName(rs.getString("name"));
                employee.setVacancy(vacancy);
                vacancy.setEmployee(employee);
                employeeList.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        employeeList.forEach(System.out::println);
        return employeeList;
    }

}
