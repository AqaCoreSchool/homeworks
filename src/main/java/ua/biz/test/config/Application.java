package ua.biz.test.config;

import ua.biz.test.data.DBCredential;
import ua.biz.test.data.TableAccess;
import ua.biz.test.pojo.Employee;
import ua.biz.test.pojo.JobVacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Employee> employees;

    public Application() {
        employees = new ArrayList<>();
    }

    public void getEmployee() {
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
    }

    public void getVacancy() {
        try (Connection con = DriverManager.getConnection(TableAccess.URL, DBCredential.NAME, DBCredential.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + TableAccess.TABLE2)) {

            while (rs.next()) {
                JobVacancy vacancy = new JobVacancy();

                String managerId = rs.getString(3);
                String vacancyName = rs.getString(4);

                employees
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
    }

    public List<JobVacancy> getVacanciesByEmployeeName(String name, String lastName) {
        List<JobVacancy> vacancies = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getFirstName().equals(name) && employee.getLastName().equals(lastName)) {
                vacancies = employee.getVacancies();
            }
        }
        return vacancies;
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
