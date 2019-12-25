package orangetest.sqltask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesDataProvider {
    VacanciesDataProvider vacanciesDataProvider = new VacanciesDataProvider();

    public Employee getEmployeeCred(String employeeNumber) {
        String employeeNumQuery = "SELECT DISTINCT emp_number, emp_firstname, emp_lastname FROM hs_hr_employee" +
                " WHERE emp_number=" + employeeNumber;
        List<JobVacancy> jobVacancyList = new ArrayList<>();
        ConnectionToDatabase connection = new ConnectionToDatabase();
        try (ResultSet rs = connection.ConnectionToDatabase().executeQuery(employeeNumQuery)) {
            Employee employee = new Employee();
            if (rs.getFetchSize() == 1) {
                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setEmpFirstName(rs.getObject("emp_firstname").toString());
                employee.setEmpLastName(rs.getObject("emp_lastname").toString());
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getEmployees() {
        String queryUniqueEmployee = "SELECT DISTINCT hs_hr_employee.emp_number, emp_firstname, emp_lastname" +
                " FROM hs_hr_employee";
        List<Employee> employeeList = new ArrayList<>();
        ConnectionToDatabase connection = new ConnectionToDatabase();
        try (ResultSet rs = connection.ConnectionToDatabase().executeQuery(queryUniqueEmployee)) {
            while (rs.next()) {
                Employee employee = new Employee();
                List<JobVacancy> vacancies = vacanciesDataProvider.getVacancyListByEmployeeNum(rs.getObject("emp_number").toString());
                employee.setEmpNumber(rs.getObject("emp_number").toString());
                employee.setEmpFirstName(rs.getObject("emp_firstname").toString());
                employee.setEmpLastName(rs.getObject("emp_lastname").toString());
                employee.setVacancyList(vacancies);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Employee> getEmployeesByVacancyName(String jobVacancyName) {
        List<Employee> employees = getEmployees();

        List<Employee> employeesByVacancy = employees.stream().filter(o -> !o.getVacancyList().isEmpty())
                .filter(o -> o.getVacancyList().stream().anyMatch(jobVacancy -> jobVacancy.getVacancyName().contains(jobVacancyName)))
                .collect(Collectors.toList());
        return employeesByVacancy;
    }

    public String getEmployeeNameByVacancyName(String jobVacancyName) {
        List<JobVacancy> vacancies = vacanciesDataProvider.getVacancies();
        JobVacancy vacancy = vacancies.stream().filter(o -> o.getVacancyName().contains(jobVacancyName)).findFirst().get();
        return vacancy.getHiringManager();
    }

    public void printEmployeeList(List<Employee> employeeList) {
        System.out.println(employeeList.stream().map(Employee::toString).collect(Collectors.joining("\n")));
    }
}
