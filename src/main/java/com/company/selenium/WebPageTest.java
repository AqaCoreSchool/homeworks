package com.company.selenium;

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


import static org.testng.Assert.assertTrue;

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
        WebElement userName = driver.findElement(By.cssSelector("#txtUsername"));
        userName.sendKeys("TestUser01");
        WebElement password = driver.findElement(By.cssSelector("#txtPassword"));
        password.sendKeys("Vfylhfujhf!1", Keys.ENTER);
    }

    @Test
    public void setTimeIn() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        attendance.click();
        WebElement punch = driver.findElement(By.id("menu_attendance_punchIn"));
        punch.click();
        WebElement noteIn = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteIn.click();
        noteIn.sendKeys("START");
        String currentDateIn = driver.findElement(By.cssSelector("span#currentDate")).getText();
        WebElement btnIn = driver.findElement(By.cssSelector("#btnPunch"));
        if (currentDateIn == formatedDate) {
            System.out.println("Not TODAY you already IN");
        } else if (currentDateIn != formatedDate) {
            btnIn.click();
            System.out.println("CLICK IN");
        }
    }


    @AfterMethod
    public void setTimeOut() {
        WebElement noteOut = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteOut.click();
        noteOut.sendKeys("FINISH");
        String currentDateOut = driver.findElement(By.cssSelector("span#currentDate")).getText();
        WebElement btnOut = driver.findElement(By.cssSelector("#btnPunch"));
        if (currentDateOut != formatedDate) {
            btnOut.click();
            System.out.println("CLICK OUT");
        } else if (currentDateOut == formatedDate) {
            System.out.println("Not TODAY your already OUT");
        }
    }
    @AfterClass
    public void checkRecords() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        attendance.click();
        WebElement myRecords = driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement inputDate = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        inputDate.click();
        inputDate.sendKeys(formatedDate, Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> webElementList = driver.findElements(By.xpath("//form[@id='employeeRecordsForm']"));
        List<WebElement> webElementListContain;
        for (WebElement webElement : webElementList) {
            webElementListContain = webElement.findElements(By.tagName("td"));
            for (WebElement element : webElementListContain) {
                if (element.getText().contains("START") && element.getText().contains("FINISH")) {
                    System.out.println(element.getText());
                    assertTrue(element.getText().contains(formatedDate));
                    System.out.println("SUCCESS!");
                }
            }
        }
    }
    @AfterGroups
    public void setWeekBack() {
        WebElement attendance2 = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        attendance2.click();
        WebElement myRecords = driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement chooseDate = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        chooseDate.click();
        chooseDate.sendKeys(weekBack, Keys.ENTER);
    }
}