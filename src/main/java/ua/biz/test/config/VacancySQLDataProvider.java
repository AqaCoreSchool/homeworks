package ua.biz.test.config;

import ua.biz.test.data.DBCredential;
import ua.biz.test.data.TableAccess;
import ua.biz.test.pojo.Employee;
import ua.biz.test.pojo.JobVacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancySQLDataProvider {

    public VacancySQLDataProvider fetchVacancyList(EmployeeSQLDataProvider employeeSQLDataProvider) {
        try (Connection con = DriverManager.getConnection(TableAccess.URL, DBCredential.NAME, DBCredential.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + TableAccess.TABLE2)) {

            while (rs.next()) {
                JobVacancy vacancy = new JobVacancy();

                String managerId = rs.getString(3);
                String vacancyName = rs.getString(4);

                employeeSQLDataProvider.getEmployees()
                        .forEach(employee -> {
                            if (employee.getNumber().equals(managerId)) {
                                vacancy.setHiringManagerId(managerId);
                                vacancy.setName(vacancyName);
                                employee.setVacancies(vacancy);
                            }
                        });

                System.out.println(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    public List<JobVacancy> getVacanciesByEmployeeName(String name, String lastName, EmployeeSQLDataProvider employeeSQLDataProvider) {
        List<JobVacancy> vacancies = new ArrayList<>();

        for (Employee employee : employeeSQLDataProvider.getEmployees()) {
            if (employee.getFirstName().equals(name) && employee.getLastName().equals(lastName)) {
                vacancies = employee.getVacancies();
            }
        }
        return vacancies;
    }
}
