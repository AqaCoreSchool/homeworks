package ua.biz.test.SQLDataProv;

import ua.biz.test.enums.ColumnName;
import ua.biz.test.enums.TableName;
import ua.biz.test.entity.Employee;
import ua.biz.test.utils.credentials.DBCredHelper;
import java.sql.*;

public class EmployeeSQLDataProvider {


    public static void setEmployeeId(Employee employee) {

        String query = String.format("SELECT %s, %s, %s FROM %s WHERE %s ='%s' AND %s ='%s'",
                ColumnName.NUMBER.getName(), ColumnName.FIRST_NAME.getName(),
                ColumnName.LAST_NAME.getName(), TableName.EMPLOYEE_TABLE.getName(),
                ColumnName.FIRST_NAME.getName(), employee.getFirstName(),
                ColumnName.LAST_NAME.getName(), employee.getLastName());

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

}
