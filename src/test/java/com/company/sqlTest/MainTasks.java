package com.company.sqlTest;
import com.company.sqlTest.data.Employee;
import com.company.sqlTest.data.URLClass;
import com.company.sqlTest.data.UserProfile;
import com.company.sqlTest.data.Vacancy;
import com.company.sqlTest.dataProvider.EmployeeSQLDataProvider;
import com.company.sqlTest.dataProvider.VacancySqlDataProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainTasks {

    public static void main(String[] args) {
        Employee employee = new Employee();
        Vacancy vacancy = new Vacancy();

        System.out.println("Mapping: ");

        URLClass urlClass = new URLClass();
        String url = urlClass.getURL();

        String joinQuery = "SELECT hs_hr_employee.emp_number, emp_firstname, emp_lastname, " +
                "ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM hs_hr_employee " +
                "INNER JOIN ohrm_job_vacancy " +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id";

        List<Vacancy> vacancyList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(joinQuery)) {
            while (rs.next()) {

                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setFirstName(rs.getObject("emp_firstname").toString());
                employee.setLastName(rs.getObject("emp_lastname").toString());
                vacancy.setHrId(rs.getString("hiring_manager_id"));
                vacancy.setName(rs.getString("name"));
                employee.setVacancy(vacancy);
                vacancy.setEmployee(employee);
                vacancyList.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        vacancyList.forEach(System.out::println);

        System.out.println("\nGet ALL Employee :");
        EmployeeSQLDataProvider employeeSQLDataProvider = new EmployeeSQLDataProvider();
        employeeSQLDataProvider.mapEmployee();
        System.out.println("GetEmployeeByVacancy:");
        employeeSQLDataProvider.getEmployeesByJobVacancyName("AQA Man");

        System.out.println("\nGet ALL Vacancy:");
        VacancySqlDataProvider vacancySqlDataProvider = new VacancySqlDataProvider();
        vacancySqlDataProvider.mapVacancy();
        System.out.println("GetVacancyByEmployeeName:");
        vacancySqlDataProvider.getVacanciesByEmployeeName("AQA Man", "Bilynska");

    }
}
