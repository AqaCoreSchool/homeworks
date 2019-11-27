package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationTest {

    private String OS = System.getProperty("os.name").toLowerCase();
    private WebDriver driver;
    private Actions actions;
    private JavascriptExecutor js;
    private String inNote = "Punched in ...";
    private String outNote = "Punched out ...";

    @BeforeTest
    public void setup() {
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir, "src", "main", "resources");
        if (OS.contains("win")) {
            System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver.exe");
        }
        System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver");
        driver = new ChromeDriver();
        driver.get("http://test.biz.ua");
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @Test(priority = 1)
    public void login() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        username.sendKeys("TestUser01");
        password.sendKeys("Vfylhfujhf!1");
        btnLogin.click();
        sleep(3);
        WebElement welcomeText = driver.findElement(By.id("welcome"));

        Assert.assertEquals("Welcome User01", welcomeText.getText());
    }

    @Test(priority = 2)
    public void goToPunchIn() {
        sleep(3);
        WebElement timeOption = driver.findElement(By.id("menu_time_viewTimeModule"));
        actions.moveToElement(timeOption).perform();
        WebElement attendanceOption = driver.findElement(By.id("menu_attendance_Attendance"));
        actions.moveToElement(attendanceOption).perform();
        WebElement punchInOption = driver.findElement(By.id("menu_attendance_punchIn"));
        punchInOption.click();
        sleep(3);
        WebElement currentDateText = driver.findElement(By.id("currentDate"));
        String expectationDate = getCurrentDate().toString();

        Assert.assertEquals(expectationDate, currentDateText.getText());
    }

    @Test(priority = 3)
    public void performPunchInOutOperations() {
        WebElement noteTextArea = driver.findElement(By.id("note"));
        noteTextArea.sendKeys(inNote);
        WebElement punchButton = driver.findElement(By.xpath("//input[@id='btnPunch' and @value='In']"));
        punchButton.click();
        WebElement noteLabel = driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]", inNote)));
        Assert.assertEquals(inNote, noteLabel.getText());
        sleep(3);
        noteTextArea = driver.findElement(By.id("note"));
        noteTextArea.sendKeys(outNote);
        punchButton = driver.findElement(By.xpath("//input[@id='btnPunch' and @value='Out']"));
        punchButton.click();
    }

    @Test(priority = 4)
    public void checkMyRecords() {
        WebElement attendanceOption = driver.findElement(By.id("menu_attendance_Attendance"));
        actions.moveToElement(attendanceOption).perform();
        WebElement myRecordsOption = driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecordsOption.click();
        sleep(3);
        WebElement attendanceDate = driver.findElement(By.id("attendance_date"));
        attendanceDate.clear();
        attendanceDate.sendKeys(getCurrentDate().toString(), Keys.ENTER);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        List<WebElement> recordsFormRows = driver.findElements(By.xpath(
                "//form[@id='employeeRecordsForm']/table/tbody/tr[@class='odd' or @class='even']"));
        WebElement myLastRecordRow = recordsFormRows.get(recordsFormRows.size() - 1);
        List<WebElement> myLastRecordDetails = myLastRecordRow.findElements(By.xpath("./td"));

        Assert.assertTrue(myLastRecordDetails.get(1).getText().contains(getCurrentDateTime()));
        Assert.assertEquals(inNote, myLastRecordDetails.get(2).getText());
        Assert.assertTrue(myLastRecordDetails.get(3).getText().contains(getCurrentDateTime()));
        Assert.assertEquals(outNote, myLastRecordDetails.get(4).getText());
    }

    @Test(priority = 5)
    public void checkWeekAgoRecords() {
        WebElement attendanceOption2 = driver.findElement(By.id("menu_attendance_Attendance"));
        actions.moveToElement(attendanceOption2).perform();
        WebElement myRecordsOption = driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecordsOption.click();
        sleep(3);
        WebElement attendanceDate = driver.findElement(By.id("attendance_date"));
        attendanceDate.clear();
        attendanceDate.sendKeys(getCurrentDate().minusWeeks(1).toString(), Keys.ENTER);
        sleep(5);
        WebElement noRecordsText = driver.findElement(By.id("noRecordsColumn"));

        Assert.assertEquals(noRecordsText.getText(), "No attendance records to display");
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

    public void sleep(long l) {
        driver.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);
    }

    public String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String hour = String.valueOf(LocalDateTime.now().getHour());
        String minute = String.valueOf(LocalDateTime.now().getMinute());
        return String.format("%s %s:%s", dtf.format(localDate), hour, minute);
    }

    public LocalDate getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        return LocalDate.parse(dtf.format(localDate));
    }
}
