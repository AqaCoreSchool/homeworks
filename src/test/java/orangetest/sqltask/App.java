package orangetest.sqltask;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SqlDataProvider sqlDataProvider = new SqlDataProvider();
        sqlDataProvider.printEmployeeList(sqlDataProvider.employeeSqlDataProvider());

        List<JobVacancy> vacancyListByEmployee = sqlDataProvider.getVacanciesByEmployeeName(
                sqlDataProvider.vacancySqlDataProvider(),
                "Mariana", "Mykytovych");

        System.out.println("\n      " + SqlDataProvider.printVacancyListToString(vacancyListByEmployee));
        String vacancyNameForSearch = "Administrator";
        System.out.println("\nEmployee by vacancy name " + vacancyNameForSearch);
        List<Employee> employeesByVacancyName = sqlDataProvider.getEmployeesByVacancyName(vacancyNameForSearch);
        sqlDataProvider.printEmployeeList(employeesByVacancyName);
    }
}
