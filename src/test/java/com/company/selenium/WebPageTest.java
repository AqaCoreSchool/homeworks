package com.company.selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class WebPageTest {
    WebDriver driver;
    LocalDate date = LocalDate.now();
    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formatedDate = date.format(format);
    LocalDate dateBack =
            date.minus(1, ChronoUnit.WEEKS);
    String weekBack = dateBack.format(format);

    @BeforeMethod
    public void setup() {
        String userDir = System.getProperty("user.home");
        System.setProperty("webdriver.chrome.driver", userDir + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://test.biz.ua");
    }

    @Test
    public void testWebPage() {
        WebElement userName = driver.findElement(By.cssSelector("#txtUsername"));
        userName.sendKeys("TestUser01");
        WebElement password = driver.findElement(By.cssSelector("#txtPassword"));
        password.sendKeys("Vfylhfujhf!1", Keys.ENTER);

        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        attendance.click();
        WebElement punch = driver.findElement(By.id("menu_attendance_punchIn"));
        punch.click();
        WebElement noteIn = driver.findElement(By.cssSelector("#note"));
        noteIn.click();
        noteIn.sendKeys("START");
        WebElement buttonIn = driver.findElement(By.cssSelector("#btnPunch"));
        buttonIn.click();

        WebElement noteOut = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteOut.click();
        noteOut.sendKeys("FINISH");
        WebElement buttonOut = driver.findElement(By.cssSelector("#btnPunch"));
        buttonOut.click();
        checkRecords();
        checkWeekBackRecords();
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

    public void checkRecords() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        attendance.click();
        WebElement myRecords = driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement inputDate = driver.findElement(By.cssSelector("#attendance_date"));
        inputDate.click();
        inputDate.sendKeys(formatedDate, Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> webElementList = driver.findElements(By.tagName("td"));
        Optional<String> note = webElementList.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains("START") || s.contains("FINISH"))
                .findAny();

        Assert.assertEquals("START", note.get());

    }

    public void checkWeekBackRecords() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        attendance.click();
        WebElement myRecords = driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement chooseDate = driver.findElement(By.cssSelector("#attendance_date"));
        chooseDate.click();
        chooseDate.sendKeys(weekBack, Keys.ENTER);
        List<WebElement> webElementList = driver.findElements(By.tagName("td"));
        String note = String.valueOf(webElementList.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains("No attendance records to display"))
                .findAny());
        Assert.assertEquals("Optional.empty", note);
    }
}