import io.github.bonigarcia.wdm.WebDriverManager;
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
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String START_MESSAGE = "Start work TEST!";
    private final String END_MESSAGE = "Stop work TEST!";
    private final String TODAY_DATE = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private final String WEEK_BEFORE = LocalDateTime.now().minusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private final String WEEK_AFTER = LocalDateTime.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private final String URL = "http://test.biz.ua";


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void createPunchAndCheckRecordDataTest(){
        login(driver, USERNAME, PASSWORD);
        String punchInDateTime = createPunchInOutAndGetCreationDate(driver, START_MESSAGE);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String punchOutDateTime = createPunchInOutAndGetCreationDate(driver, END_MESSAGE);
        List<WebElement> latestRecordBody = getLastRecord(driver, TODAY_DATE);
        String recordStartDateTime = latestRecordBody.get(1).getText();
        String recordPunchInNote = latestRecordBody.get(2).getText();
        String recordEndDateTime = latestRecordBody.get(3).getText();
        String recordPunchOutNote = latestRecordBody.get(4).getText();
        Assert.assertEquals(recordStartDateTime, punchInDateTime,
                "record Punch In datetime is different then actual Punch In datetime!");
        Assert.assertEquals(recordPunchInNote, START_MESSAGE,
                "record Punch In note is different then actual Punch In note!");
        Assert.assertEquals(recordEndDateTime, punchOutDateTime,
                "record Punch Out datetime is different then actual Punch Out datetime!");
        Assert.assertEquals(recordPunchOutNote, END_MESSAGE,
                "record Punch Out datetime is different then actual Punch Out datetime!");
    }

    @Test(priority = 2)
    public void checkRecordsTableIsEmpty(){
        login(driver, USERNAME, PASSWORD);
        WebElement noRecordsWeekAfter = getLastRecordEmpty(driver, WEEK_AFTER);
        Assert.assertTrue(noRecordsWeekAfter.isDisplayed());
        WebElement noRecordsWeekBefore = getLastRecordEmpty(driver, WEEK_BEFORE);
        Assert.assertTrue(noRecordsWeekBefore.isDisplayed());
    }

    public static void login(WebDriver driver, String username, String password){
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    public static String createPunchInOutAndGetCreationDate(WebDriver driver, String message){
        WebElement timeSection = driver.findElement(By.id("menu_time_viewTimeModule"));
        timeSection.click();
        WebElement attendanceMenu =  driver.findElement(By.id("menu_attendance_Attendance"));
        attendanceMenu.click();
        WebElement punchInOut =  driver.findElement(By.id("menu_attendance_punchIn"));
        punchInOut.click();
        WebElement punchDate = driver.findElement(By.id("currentDate"));
        WebElement punchTime = driver.findElement(By.id("currentTime"));
        String punchDateTime = String.format("%s %s:00 GMT 2", punchDate.getText(), punchTime.getText());
        WebElement inTextArea = driver.findElement(By.xpath("//textarea[@id='note']"));
        inTextArea.sendKeys(message);
        WebElement buttonConfirmPunch = driver.findElement(By.id("btnPunch"));
        buttonConfirmPunch.click();
        return punchDateTime;
    }

    public static List<WebElement> getLastRecord(WebDriver driver, String date){
        WebElement attendanceMenu =  driver.findElement(By.id("menu_attendance_Attendance"));
        attendanceMenu.click();
        WebElement myRecords =  driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement dateField =  driver.findElement(By.id("attendance_date"));
        dateField.clear();
        dateField.sendKeys(date + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> tableRows = driver.findElements(By.xpath(
                "//form[@id='employeeRecordsForm']//tr[@class='odd' or @class='even']"));
        WebElement latestRecord = tableRows.get(tableRows.size()-1);
        return latestRecord.findElements(By.xpath("./td"));
    }

    public static WebElement getLastRecordEmpty(WebDriver driver, String date){
        WebElement timeSection = driver.findElement(By.id("menu_time_viewTimeModule"));
        timeSection.click();
        WebElement attendanceMenu =  driver.findElement(By.id("menu_attendance_Attendance"));
        attendanceMenu.click();
        WebElement myRecords =  driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement dateField =  driver.findElement(By.id("attendance_date"));
        dateField.clear();
        dateField.sendKeys(date + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> noRecordRow = driver.findElements(By.xpath(
                "//form[@id='employeeRecordsForm']//tr/td[@id='noRecordsColumn']"));
        return noRecordRow.get(0);
    }

}
