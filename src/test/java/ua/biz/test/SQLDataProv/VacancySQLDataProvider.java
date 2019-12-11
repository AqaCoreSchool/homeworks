package ua.biz.test.SQLDataProv;

import ua.biz.test.enums.TableName;
import ua.biz.test.enums.VacancyColumnsName;
import ua.biz.test.entity.Employee;
import ua.biz.test.entity.Vacancy;
import ua.biz.test.utils.credentials.DBCredHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancySQLDataProvider {

    public static List<Vacancy> getEmployeeVacanciesList(Employee employee) {
        List<Vacancy> vacanciesList = new ArrayList<>();
        EmployeeSQLDataProvider.setEmployeeId(employee);

        String query = String.format("SELECT %s, %s FROM %s WHERE %s=%s ",
                VacancyColumnsName.NAME.getName(), VacancyColumnsName.HIRING_MANAGER_ID.getName(),
                TableName.VACANCY_TABLE.getName(), VacancyColumnsName.HIRING_MANAGER_ID.getName(),
                employee.getId());

        try (Connection connection = DriverManager.
                getConnection(DBCredHelper.URL, DBCredHelper.NAME, DBCredHelper.PASSWORD);
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                vacanciesList.add(new Vacancy(rs.getString(1), employee));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacanciesList;
    }
}
