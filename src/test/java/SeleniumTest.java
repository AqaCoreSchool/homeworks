import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser01";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String START_MESSAGE = "Start work TEST!";
    private final String END_MESSAGE = "Stop work TEST!";
    private final String TODAY_DATE = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void createPunchAndCheckRecordDataTest(){
        driver.get("http://test.biz.ua");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys(USERNAME);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement timeSection = driver.findElement(By.id("menu_time_viewTimeModule"));
        timeSection.click();
        WebElement attendanceMenu =  driver.findElement(By.id("menu_attendance_Attendance"));
        attendanceMenu.click();
        WebElement punchInOut =  driver.findElement(By.id("menu_attendance_punchIn"));
        punchInOut.click();
        WebElement startDate = driver.findElement(By.id("currentDate"));
        WebElement startTime = driver.findElement(By.id("currentTime"));
        String punchInDateTime = String.format("%s %s:00 GMT 2", startDate.getText(), startTime.getText());
        WebElement inTextArea = driver.findElement(By.xpath("//textarea[@id='note']"));
        inTextArea.sendKeys(START_MESSAGE);
        WebElement buttonPunchIn = driver.findElement(By.id("btnPunch"));
        buttonPunchIn.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement endDate = driver.findElement(By.id("currentDate"));
        WebElement endTime = driver.findElement(By.id("currentTime"));
        String punchOutDateTime = String.format("%s %s:00 GMT 2", endDate.getText(), endTime.getText());
        WebElement outTextArea = driver.findElement(By.xpath("//textarea[@id='note']"));
        outTextArea.sendKeys(END_MESSAGE);
        WebElement buttonPunchOut = driver.findElement(By.id("btnPunch"));
        buttonPunchOut.click();
        attendanceMenu =  driver.findElement(By.id("menu_attendance_Attendance"));
        attendanceMenu.click();
        WebElement myRecords =  driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement dateField =  driver.findElement(By.id("attendance_date"));
        dateField.clear();
        dateField.sendKeys(TODAY_DATE + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> tableRows = driver.findElements(By.xpath(
                "//form[@id='employeeRecordsForm']/table/tbody/tr[@class='odd' or @class='even']"));
        WebElement latestRecord = tableRows.get(tableRows.size()-1);
        List<WebElement> latestRecordBody = latestRecord.findElements(By.xpath("./td"));
        String recordStartDateTime = latestRecordBody.get(1).getText();
        String recordPunchInNote = latestRecordBody.get(2).getText();
        String recordEndDateTime = latestRecordBody.get(3).getText();
        String recordPunchOutNote = latestRecordBody.get(4).getText();
        Assert.assertEquals(recordStartDateTime, punchInDateTime, "record Punch In datetime is different then actual Punch In datetime!");
        Assert.assertEquals(recordPunchInNote, START_MESSAGE, "record Punch In note is different then actual Punch In note!");
        Assert.assertEquals(recordEndDateTime, punchOutDateTime, "record Punch Out datetime is different then actual Punch Out datetime!");
        Assert.assertEquals(recordPunchOutNote, END_MESSAGE, "record Punch Out datetime is different then actual Punch Out datetime!");
    }

}
