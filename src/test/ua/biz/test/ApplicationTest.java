package ua.biz.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.biz.test.config.EmployeeSQLDataProvider;
import ua.biz.test.config.VacancySQLDataProvider;
import ua.biz.test.page.LoginPage;
import ua.biz.test.pojo.Employee;
import ua.biz.test.pojo.JobVacancy;
import ua.biz.test.util.LocalDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationTest {
    private static final String URL = "http://test.biz.ua";
    private String jobVacancyName = "Test";
    private String name = "Bobbie";
    private String lastName = "Abernathy";
    private EmployeeSQLDataProvider employeeSQLDataProvider =
            new EmployeeSQLDataProvider()
                    .fetchEmployeeList();

    private VacancySQLDataProvider vacancySQLDataProvider =
            new VacancySQLDataProvider()
                    .fetchVacancyList(employeeSQLDataProvider);

    private List<Employee> employees =
            employeeSQLDataProvider
                    .getEmployeesByJobVacancyName(jobVacancyName);
    
    private List<JobVacancy> vacancies =
            vacancySQLDataProvider
                    .getVacanciesByEmployeeName(name, lastName, employeeSQLDataProvider);

    @BeforeMethod
    public void setUp() {
        WebDriver driver = LocalDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void checkVacancy() {
        boolean isVacancy =
                new LoginPage()
                        .loginIntoSystem()
                        .selectRecruitment()
                        .switchToVacancy()
                        .switchToVacancy()
                        .isVacancyInList(name, lastName, vacancies);

        Assert.assertTrue(isVacancy, "Vacancy is not found!");
    }

    @Test
    public void checkEmployee() {
        boolean isEmployee =
                new LoginPage()
                        .loginIntoSystem()
                        .selectPim()
                        .isEmployeeInList(employees);

        Assert.assertTrue(isEmployee, "Employee is not found!");
    }

    @AfterMethod
    public void tearDown() {
        LocalDriver.closeDriver();
    }

}
