package ua.biz.test.SQLDataProv;

import org.testng.annotations.Test;
import ua.biz.test.entity.Vacancy;
import ua.biz.test.enums.EmployeeColumnName;
import ua.biz.test.enums.TableName;
import ua.biz.test.entity.Employee;
import ua.biz.test.utils.credentials.DBCredHelper;

import java.sql.*;

public class EmployeeSQLDataProvider {

    public static void setEmployeeIdForEmployee(Employee employee) {

        String query = String.format("SELECT %s, %s, %s FROM %s WHERE %s ='%s' AND %s ='%s'",
                EmployeeColumnName.NUMBER.getName(), EmployeeColumnName.FIRST_NAME.getName(),
                EmployeeColumnName.LAST_NAME.getName(), TableName.EMPLOYEE_TABLE.getName(),
                EmployeeColumnName.FIRST_NAME.getName(), employee.getFirstName(),
                EmployeeColumnName.LAST_NAME.getName(), employee.getLastName());

        try (Connection connection = DriverManager
                .getConnection(DBCredHelper.URL, DBCredHelper.NAME, DBCredHelper.PASSWORD);
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                employee.setId(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Employee getEmployeeByVacancy(Vacancy vacancy) {
        String employeeId = VacancySQLDataProvider.getEmployeeIdByVacancy(vacancy);
        String query = String.format("SELECT %s, %s, %s FROM %s WHERE %s ='%s' ",
                EmployeeColumnName.NUMBER.getName(), EmployeeColumnName.FIRST_NAME.getName(),
                EmployeeColumnName.LAST_NAME.getName(), TableName.EMPLOYEE_TABLE.getName(),
                EmployeeColumnName.NUMBER.getName(), employeeId);

        try (Connection connection = DriverManager
                .getConnection(DBCredHelper.URL, DBCredHelper.NAME, DBCredHelper.PASSWORD);
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                vacancy.setHiringManager(new Employee(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancy.getHiringManager();
    }

}
