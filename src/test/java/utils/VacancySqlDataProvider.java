package utils;

import data.EmployeeSQLData;
import data.JobVacancySQLData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancySqlDataProvider extends SqlDataProvider {
    public static List<JobVacancySQLData> vacancyPool = new ArrayList<>();

    public static void makeVacancyPool() {
        String url = "jdbc:mysql://test.biz.ua:3306/orangehrm_mysql";

        String vcQuery = "SELECT ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM ohrm_job_vacancy;";

        try (Connection con = DriverManager.getConnection(URL, DBNAME, DBPASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(vcQuery)) {
            while (rs.next()) {
                JobVacancySQLData vacancy = new JobVacancySQLData();
                vacancy.setHiring_manager_id(rs.getString("hiring_manager_id"));
                vacancy.setName(rs.getString("name"));
                vacancyPool.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<JobVacancySQLData> getVacanciesByEmployeeName(String name, String surname){
        EmployeeSQLData employee = EmployeeSqlDataProvider.employeePool.stream()
                .filter(o -> o.getEmp_firstname().equals(name) && o.getEmp_lastname().equals(surname))
                .findFirst().get();
        return employee.getVacancies();
    }

}
