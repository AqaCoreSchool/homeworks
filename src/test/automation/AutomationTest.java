package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AutomationTest {

    private WebDriver driver;
    private static final String URL = "http://test.biz.ua";
    private static final String USER_NAME = "TestUser01";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private static Random random;
    private String message;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        random = new Random();
        message = "Andrii" + random.nextInt();
    }

    @Test
    public void login() {
        driver.get(URL);

        // login
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(USER_NAME);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("#btnLogin")).submit();

        Assert.assertEquals("Welcome User01", driver.findElement(By.xpath("//a[@id='welcome']")).getText());

        // navigation
        driver.findElement(By.xpath("//b[contains(text(),'Time')]")).click();
        driver.findElement(By.cssSelector("#menu_attendance_Attendance")).click();
        driver.findElement(By.cssSelector("#menu_attendance_punchIn")).click();

        // punch in write and click
        driver.findElement(By.cssSelector("#note")).sendKeys(message);

        // writing dataTime
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
        WebElement punchInDate = driver.findElement(By.xpath("//*[text()[contains(.,'" + labelDate + "')]]"));
        WebElement punchInNote = punchInDate.findElement(By.xpath("following-sibling::*"));

        Assert.assertEquals(labelDate + ":00 GMT 2", punchInDate.getText());
        Assert.assertEquals(message, punchInNote.getText(), "There is another value with the same date!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
