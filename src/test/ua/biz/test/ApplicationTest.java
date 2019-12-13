package ua.biz.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ua.biz.test.config.Main;
import ua.biz.test.page.LoginPage;
import ua.biz.test.util.LocalDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationTest {
    private static final String URL = "http://test.biz.ua";
    private String jobVacancyName = "Test";
    public String name = "Bobbie";
    public String lastName = "Abernathy";

    Main main = new Main().setEmployeeList(jobVacancyName).setVacancyList(name, lastName);

    @BeforeSuite
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
                        .isVacancyInList(name, lastName, main.getVacancies());

        Assert.assertTrue(isVacancy, "Vacancy is not found!");
    }

    @AfterSuite
    public void tearDown() {
        LocalDriver.closeDriver();
    }

}
