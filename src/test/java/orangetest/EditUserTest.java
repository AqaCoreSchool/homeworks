package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static orangetest.LoginTest.*;
import static orangetest.LoginTest.driver;

public class EditUserTest {

    @BeforeTest
    public void setup() {
        LoginTest test = new LoginTest();
        test.setup();
        test.loginTest();
    }

    @Test
    public void editUserTest() {
        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
        driver.findElement(By.linkText("Mariana")).click();
        WebElement saveEditButton = driver.findElement(By.cssSelector("#btnSave"));
        saveEditButton.click();
        driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
        WebElement calendar = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
        calendar.click();
        calendar.clear();
        calendar.sendKeys(BIRTHDAY, Keys.ENTER);
        WebElement nationality = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        nationality.click();
        nationality.findElement(By.xpath("//option[contains(text(),'Ukrainian')]")).click();
        WebElement marital = driver.findElement(By.xpath("//select[@id='personal_cmbMarital']"));
        marital.click();
        marital.findElement(By.xpath("//option[contains(text(),'Other')]")).click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        firstName.clear();
        firstName.sendKeys(FIRST_NAME);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        lastName.clear();
        lastName.sendKeys(LAST_NAME);
        saveEditButton.click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).isEnabled());

    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
