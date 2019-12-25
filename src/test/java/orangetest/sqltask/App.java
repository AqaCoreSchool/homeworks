package orangetest.sqltask;

import java.util.List;

public class App {
    private static String vacancyName = "Administrator";
    private static String employeeFirstName = "Mariana";
    private static String employeeLastName = "Mykytovych";

    public static void main(String[] args) {
        VacanciesDataProvider vacanciesDataProvider = new VacanciesDataProvider();
        EmployeesDataProvider employeesDataProvider = new EmployeesDataProvider();
        List<Employee> employees = employeesDataProvider.getEmployees();
        List<JobVacancy> vacancies = vacanciesDataProvider.getVacancies();
        System.out.println("List of employees");
        employeesDataProvider.printEmployeeList(employees);
        List<JobVacancy> vacancyListByEmployee = vacanciesDataProvider
                .getVacanciesByEmployeeName(vacancies, employeeFirstName, employeeLastName);
        System.out.println(String.join(" "
                , "List of vacancies created by:", employeeFirstName, employeeLastName));
        System.out.println("      " + vacanciesDataProvider.printVacancyListToString(vacancyListByEmployee));
        System.out.println("\nEmployee by vacancy name " + vacancyName);
        List<Employee> employeesByVacancyName = employeesDataProvider.getEmployeesByVacancyName(vacancyName);
        employeesDataProvider.printEmployeeList(employeesByVacancyName);
    }
}
