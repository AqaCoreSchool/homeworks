package com.company.sqlTest.dataProvider;

import com.company.sqlTest.data.Employee;
import com.company.sqlTest.data.URLClass;
import com.company.sqlTest.data.UserProfile;
import com.company.sqlTest.data.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancySqlDataProvider {
    Employee employee = new Employee();
    Vacancy vacancy = new Vacancy();

    URLClass urlClass = new URLClass();
    String url = urlClass.getURL();

    public void mapVacancy() {

        String vacancyQuery = "SELECT hiring_manager_id, name " +
                "FROM ohrm_job_vacancy ORDER BY name DESC";

        try (Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(vacancyQuery)) {
            while(rs.next()) {
                for(int i = 1; i <= 2; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vacancy> getVacanciesByEmployeeName(String name, String lastName) {

        String getVacancyByEmployeeQuery = String.format("SELECT hs_hr_employee.emp_number, emp_firstname, emp_lastname, " +
                "ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM hs_hr_employee " +
                "INNER JOIN ohrm_job_vacancy " +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id " +
                "WHERE ohrm_job_vacancy.name = '%s' AND hs_hr_employee.emp_lastname = '%s' ", name, lastName);

        List<Vacancy> vacancyList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, UserProfile.NAME, UserProfile.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(getVacancyByEmployeeQuery)) {
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
        return vacancyList;
    }
}
