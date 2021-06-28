package testpackage.dataProvider;

import testpackage.data.URLsql;
import testpackage.data.UserForSQL;
import testpackage.entity.Candidate;
import testpackage.entity.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSQL {
    Candidate employee = new Candidate();
    Vacancy vacancy = new Vacancy();
    URLsql urlSql = new URLsql();
    String url = urlSql.getURL();

    public List<Candidate> getAllEmployeeList() {

        String employeeQuery = "SELECT emp_number, emp_firstname, emp_lastname " +
                "FROM hs_hr_employee ORDER BY emp_firstname ASC";
        List<Candidate> employeeList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, UserForSQL.NAME, UserForSQL.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(employeeQuery)) {
            while(rs.next()) {
                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setFirstName(rs.getObject("emp_firstname").toString());
                employee.setLastName(rs.getObject("emp_lastname").toString());
                vacancy.setHiringManagerID(rs.getString("hiring_manager_id"));
                vacancy.setName(rs.getString("name"));
                employee.setVacanc(vacancy);
                vacancy.setCandidate(employee);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Candidate> getEmployeeByJobVacancyNameList(String jobVacancyName) {

        String getEmployeeByVacancyQuery = String.format("SELECT hs_hr_employee.emp_number, emp_firstname, emp_lastname, " +
                "ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM hs_hr_employee " +
                "INNER JOIN ohrm_job_vacancy " +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id " +
                "WHERE ohrm_job_vacancy.name = '%s' ", jobVacancyName);

        List<Candidate> employeeList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, UserForSQL.NAME, UserForSQL.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(getEmployeeByVacancyQuery)) {
            while (rs.next()) {
                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setFirstName(rs.getObject("emp_firstname").toString());
                employee.setLastName(rs.getObject("emp_lastname").toString());
                vacancy.setHiringManagerID(rs.getString("hiring_manager_id"));
                vacancy.setName(rs.getString("name"));
                employee.setVacanc(vacancy);
                vacancy.setCandidate(employee);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
