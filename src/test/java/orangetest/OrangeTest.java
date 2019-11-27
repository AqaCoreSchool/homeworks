package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class OrangeTest {
    public static final String PATH = Paths.get("src", "main", "resources", "chromedriver.exe").toString();
    public static final String NOTE_IN = "I am a good worker :-)";
    public static final String NOTE_OUT = "I am already finished my work :-)";
    public static String dateForChecking = "";
    public static String dateDay;
    public String dateOutString;
    public String timeOutString;
    public String timeInString;
    public String dateInString;
    private WebDriver driver;

    @BeforeTest
    public void testPrecondition() {
        System.setProperty("webdriver.chrome.driver", PATH);
        driver = new ChromeDriver();
        driver.get("http://test.biz.ua");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        login.sendKeys("TestUser01");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Vfylhfujhf!1");
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        submitButton.click();
    }

    @Test(priority = 1)
    public void testPunchIn() {
        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.linkText("Punch In/Out")).click();
        WebElement note = driver.findElement(By.xpath("//textarea[@id='note']"));
        note.sendKeys(NOTE_IN);
        WebElement timeIn = driver.findElement(By.xpath("//span[@id='currentTime']"));
        timeInString = timeIn.getText();
        System.out.println(timeInString);
        WebElement dateIn = driver.findElement(By.xpath("//span[@id='currentDate']"));
        dateInString = dateIn.getText();
        dateDay = dateInString.substring(8, 10);
        System.out.println(dateInString);
        driver.findElement(By.xpath("//input[@id='btnPunch']")).click(); /////////////
    }

    @Test(priority = 2)
    public void testPunchOut() {
        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.linkText("Punch In/Out")).click();
        WebElement note1 = driver.findElement(By.xpath("//textarea[@id='note']"));
        note1.sendKeys(NOTE_OUT);
        WebElement timeOut = driver.findElement(By.xpath("//span[@id='currentTime']"));
        timeOutString = timeOut.getText();
        System.out.println(timeOutString);
        WebElement dateOut = driver.findElement(By.xpath("//span[@id='currentDate']"));
        dateOutString = dateOut.getText();
        System.out.println(dateOutString);
        driver.findElement(By.xpath("//input[@id='btnPunch']")).click();
    }

    @Test(priority = 3)
    public void testCheckRecord() {
        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.xpath("//a[@id='menu_attendance_viewMyAttendanceRecord']")).click();
        driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
        dateForChecking = dateDay;
        driver.findElement(By.linkText(dateDay)).click();
        WebElement baseTable = driver.findElement(By.xpath("//table[@class='table']"));
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        String stringSearch = tableRows.stream().map(WebElement::getText)
                .filter(o -> o.contains(dateInString))
                .filter(o -> o.contains(timeInString))
                .filter(o -> o.contains(NOTE_IN))
                .filter(o -> o.contains(dateOutString))
                .filter(o -> o.contains(timeOutString))
                .filter(o -> o.contains(NOTE_OUT))
                .collect(Collectors.joining("\n"));
        System.out.println(stringSearch);
        Assert.assertFalse(stringSearch.equals(""));
    }

    @Test(priority = 4)
    public void checkPreviousWeek() {
        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.xpath("//a[@id='menu_attendance_viewMyAttendanceRecord']")).click();
        driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
        LocalDate previousDate = LocalDate.now().minusDays(7);
        int day = previousDate.getDayOfMonth();
        driver.findElement(By.linkText(String.valueOf(day))).click();
        Assert.assertTrue((driver.findElements(By.xpath("//td[@id='noRecordsColumn']")).size() == 1), "No attendance records to display");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
