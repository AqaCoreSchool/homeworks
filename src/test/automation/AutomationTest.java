package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class AutomationTest {

    private WebDriver driver;
    private static final String URL = "http://test.biz.ua";
    private static final String USER_NAME = "TestUser01";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private String message;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        Random random = new Random();
        message = "Andrii" + random.nextInt();

        wait = new WebDriverWait(driver, 10);
    }

    @BeforeMethod
    public void login() {
        // login
        driver.get(URL);

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(USER_NAME);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("#btnLogin")).submit();

        Assert.assertEquals("Welcome User01", driver.findElement(By.xpath("//a[@id='welcome']")).getText());
    }

    @BeforeMethod
    public void navigate() {
        // navigation
        driver.findElement(By.xpath("//b[contains(text(),'Time')]")).click();
        driver.findElement(By.cssSelector("#menu_attendance_Attendance")).click();
    }

    @Test
    public void writeAndCheckRecord() {
        // starting punch
        driver.findElement(By.cssSelector("#menu_attendance_punchIn")).click();

        // punch in write and click
        driver.findElement(By.cssSelector("#note")).sendKeys(message);

        // writing dateTime
        LocalDateTime dateTime = LocalDateTime.now();

        driver.findElement(By.cssSelector("#btnPunch")).click();

        // punch out write and click
        driver.findElement(By.cssSelector("#note")).sendKeys(message);
        driver.findElement(By.cssSelector("#btnPunch")).click();

        // navigation to my records
        driver.findElement(By.cssSelector("#menu_attendance_Attendance")).click();
        driver.findElement(By.cssSelector("#menu_attendance_viewMyAttendanceRecord")).click();

        // entering the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String labelDate = dateTime.format(formatter);

        WebElement calendarIcon = driver.findElement(By.cssSelector("#attendance_date"));
        calendarIcon.clear();
        calendarIcon.sendKeys(LocalDate.now().toString());
        calendarIcon.submit();

        // checking my records
        List<WebElement> punchInDate = driver.findElements(By.xpath("//*[text()[contains(.,'" + labelDate + "')]]"));

        for (WebElement element : punchInDate) {
            if (element.findElement(By.xpath("following-sibling::*")).getText().equals(message)) {
                System.out.printf("Punch '%s' from '%s' exists. ", message, labelDate);

                Assert.assertEquals(labelDate + ":00 GMT 2", element.getText());
                Assert.assertEquals(message, element.findElement(By.xpath("following-sibling::*")).getText(), "Created record not found!");
            }
        }
    }

    @Test
    public void checkRecordFromLastNextWeek() {
        driver.findElement(By.cssSelector("#menu_attendance_viewMyAttendanceRecord")).click();

        WebElement dateField = driver.findElement(By.cssSelector("#attendance_date"));
        dateField.clear();

        LocalDate date = LocalDate.now();
        LocalDate dateBefore = date.minusWeeks(1);
        LocalDate dateAfter = date.plusWeeks(1);

        dateField.sendKeys(dateBefore.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        String day = dateBefore.format(formatter);

        driver.findElement(By.linkText(day)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#noRecordsColumn")));

        WebElement noRecord = driver.findElement(By.cssSelector("#noRecordsColumn"));
        System.out.printf("From %s: %s%n", dateBefore.toString(), noRecord.getText());

        Assert.assertEquals(noRecord.getText(), "No attendance records to display", "It is not empty!");

        dateField.clear();
        dateField.sendKeys(dateAfter.toString());
        System.out.printf("From %s: %s%n", dateAfter.toString(), noRecord.getText());

        Assert.assertEquals(noRecord.getText(), "No attendance records to display", "It is not empty!");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
