package company.common;

import company.Employee;
import java.util.List;

/**
 * Represents a class with useful tools which can be used
 * anywhere in project.
 *
 * @author  Pavlo Hrytsyshyn
 * @version 1.0
 * @since   2019-11-15
 */
public class Common {
    public static void printEmployees(List<Employee> employeeList) {
        String leftAlignFormat = "| %-25s | %-8d | %-5s       | %-10s |%n";

        System.out.format("+---------------------------+----------+-------------+------------+%n");
        System.out.format("| Employee name             | Salary   | Is hired?   | Position   |%n");
        System.out.format("+---------------------------+----------+-------------+------------+%n");
        for (Employee employee : employeeList) {
            System.out.format(leftAlignFormat, employee.getName(), employee.getSalary(), employee.isHired(),
                    employee.getClass().getSimpleName());
        }
        System.out.format("+---------------------------+----------+-------------+------------+%n");
    }
}
