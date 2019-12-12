package sql;

import sql.data.Employee;
import sql.data.JobVacancy;
import sql.dataprovider.EmployeeSQLDataProvider;
import sql.dataprovider.VacancySQLDataProvider;

import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        EmployeeSQLDataProvider employeeSQLDataProvider = new EmployeeSQLDataProvider();
        List<Employee> employeeList = employeeSQLDataProvider.getEmployeeList();

        List<Employee> employeeByVacancy = employeeSQLDataProvider
                                            .getEmployeesByJobVacancyName(employeeList, "AQA Jun");
        System.out.println(employeeByVacancy);

        VacancySQLDataProvider vacancySQLDataProvider = new VacancySQLDataProvider();

        List<JobVacancy> vacancyByEmployee = vacancySQLDataProvider
                                            .getVacanciesByEmployeeName(employeeList, "andrii", "shtyiuk");

        System.out.println(vacancyByEmployee);
    }
}
