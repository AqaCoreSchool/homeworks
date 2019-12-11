package testpackage.dataProvider;

import testpackage.data.URLsql;
import testpackage.data.UserForSQL;
import testpackage.entity.Candidate;
import testpackage.entity.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancySQL {
    Candidate employee = new Candidate();
    Vacancy vacancy = new Vacancy();
    URLsql urlClass = new URLsql();
    String url = urlClass.getURL();

    public List<Vacancy> getAllVacancyList() {

        String vacancyQuery = "SELECT hiring_manager_id, name " +
                "FROM ohrm_job_vacancy ORDER BY name DESC";
        List<Vacancy> vacancyList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, UserForSQL.NAME, UserForSQL.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(vacancyQuery)) {
            while(rs.next()) {
                    employee.setEmpNumber(rs.getObject("emp_number").toString());
                    employee.setFirstName(rs.getObject("emp_firstname").toString());
                    employee.setLastName(rs.getObject("emp_lastname").toString());
                    vacancy.setHiringManagerID(rs.getString("hiring_manager_id"));
                    vacancy.setName(rs.getString("name"));
                    employee.setVacanc(vacancy);
                    vacancy.setCandidate(employee);
                    vacancyList.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    public List<Vacancy> getVacanciesByEmployeeNameList(String name, String lastName) {

        String getVacancyByEmployeeQuery = String.format("SELECT hs_hr_employee.emp_number, emp_firstname, emp_lastname, " +
                "ohrm_job_vacancy.hiring_manager_id, ohrm_job_vacancy.name " +
                "FROM hs_hr_employee " +
                "INNER JOIN ohrm_job_vacancy " +
                "ON hs_hr_employee.emp_number=ohrm_job_vacancy.hiring_manager_id " +
                "WHERE ohrm_job_vacancy.name = '%s' AND hs_hr_employee.emp_lastname = '%s' ", name, lastName);

        List<Vacancy> vacancyList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, UserForSQL.NAME, UserForSQL.PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(getVacancyByEmployeeQuery)) {
            while (rs.next()) {
                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setFirstName(rs.getObject("emp_firstname").toString());
                employee.setLastName(rs.getObject("emp_lastname").toString());
                vacancy.setHiringManagerID(rs.getString("hiring_manager_id"));
                vacancy.setName(rs.getString("name"));
                employee.setVacanc(vacancy);
                vacancy.setCandidate(employee);
                vacancyList.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }
}
