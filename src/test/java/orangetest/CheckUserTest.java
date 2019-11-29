package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static orangetest.LoginTest.FIRST_NAME;
import static orangetest.LoginTest.LAST_NAME;
import static orangetest.LoginTest.driver;

public class CheckUserTest {

    @BeforeTest
    public void setup() {
        LoginTest test = new LoginTest();
        test.setup();
        test.loginTest();
    }

    @Test
    public void checkUserTest() {
        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
        WebElement employeeName = driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
        employeeName.click();
        employeeName.clear();
        employeeName.sendKeys(FIRST_NAME + " " + LAST_NAME);
        employeeName.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        WebElement resultTable = driver.findElement(By.xpath("//table[@id='resultTable']//tbody"));
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        List results = tableRows.stream().map(WebElement::getText).
                filter(o -> o.contains(FIRST_NAME) &&
                        o.contains(LAST_NAME)).collect(Collectors.toList());
        System.out.println(results);
        Assert.assertEquals(results.size(), 1);
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
