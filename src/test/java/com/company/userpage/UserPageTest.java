package com.company.userpage;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class UserPageTest
{
    WebDriver driver;
    LocalDate date = LocalDate.now();
    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formatDate = date.format(format);
    LocalDate plusYears =
            date.plus(2, ChronoUnit.YEARS);
    String expireDate = plusYears.format(format);

    @Test
    public void testUserPage() {
        String userDir = System.getProperty("user.home");
        System.setProperty("webdriver.chrome.driver", userDir + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.biz.ua");
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("TestUser07");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Vfylhfujhf!1", Keys.ENTER);
        WebElement info = driver.findElement(By.xpath("//b[contains(text(),'My Info')]"));
        info.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement edit = driver.findElement(By.xpath("//input[@id='btnSave']"));
        edit.click();
        WebElement fullName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        fullName.clear();
        fullName.sendKeys("Olya",Keys.ENTER);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        lastName.clear();
        lastName.sendKeys("Bilynska", Keys.ENTER);
        WebElement employeeId = driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']"));
        employeeId.clear();
        employeeId.sendKeys("1", Keys.ENTER);
        WebElement driverNumber = driver.findElement(By.xpath("//input[@id='personal_txtLicenNo']"));
        driverNumber.clear();
        driverNumber.sendKeys("78956");
        WebElement otherId = driver.findElement(By.xpath("//input[@id='personal_txtOtherID']"));
        otherId.clear();
        otherId.sendKeys("07");
        WebElement licenseExpireDate = driver.findElement(By.xpath("//input[@id='personal_txtLicExpDate']"));
        licenseExpireDate.clear();
        licenseExpireDate.sendKeys(expireDate);
        WebElement radioButton = driver.findElement(By.id("personal_optGender_2"));
        radioButton.click();

        Select nationality = new Select(driver.findElement(By.xpath("//select[@id='personal_cmbNation']")));
        nationality.selectByVisibleText("Ukrainian");
        Select maritalStatus = new Select(driver.findElement(By.xpath("//select[@id='personal_cmbMarital']")));
        maritalStatus.selectByVisibleText("Single");
        WebElement birthDate = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
        birthDate.clear();
        birthDate.sendKeys("2000-08-11",Keys.ENTER);
        WebElement saveButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
        saveButton.click();

        checkTime();
        checkEmployeeRecords();
    }

    public void checkTime(){
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']"));
        attendance.click();
        WebElement punch = driver.findElement(By.xpath("//a[@id='menu_attendance_punchIn']"));
        punch.click();
        WebElement noteIn = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteIn.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        noteIn.sendKeys("START");
        WebElement buttonIn = driver.findElement(By.cssSelector("#btnPunch"));
        buttonIn.click();

        WebElement noteOut = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteOut.click();
        noteOut.sendKeys("FINISH");
        WebElement buttonOut = driver.findElement(By.cssSelector("#btnPunch"));
        buttonOut.click();
        WebElement currentDate = driver.findElement(By.id("currentDate"));
        Assert.assertEquals(formatDate, currentDate.getText());
    }

    public void checkEmployeeRecords() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']"));
        attendance.click();
        WebElement employeeRecords = driver.findElement(By.xpath("//a[@id='menu_attendance_viewAttendanceRecord']"));
        employeeRecords.click();
        WebElement chooseDate = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        chooseDate.click();
        chooseDate.clear();
        chooseDate.sendKeys(formatDate, Keys.ENTER);
        WebElement viewButton = driver.findElement(By.xpath("//input[@id='btView']"));
        viewButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@id='search-results']//div[@class='inner']"));
        Optional<String> note = webElementList.stream()
                .map(WebElement::getText)
                .filter(el -> el.contains("START") && el.contains("FINISH"))
                .findAny();
        Assert.assertTrue("Olya Bilynska", note.isPresent());
    }

    @AfterTest
    public void shutDownDriver() {
        driver.close();
    }
}
