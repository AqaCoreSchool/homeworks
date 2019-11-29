package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangeTest {
    public static final String PATH = Paths.get("src", "main", "resources", "chromedriver.exe").toString();
    public static final String NOTE_IN = "I am a good worker :-)";
    public static final String NOTE_OUT = "I am already finished my work :-)";
    public static final CharSequence PASSWORD = "Vfylhfujhf!1";
    public static final CharSequence LOGIN = "TestUser05";
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
    }

    @Test(priority = 1)
    public void login(){
        WebElement login = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        login.sendKeys(LOGIN);
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys(PASSWORD);
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        submitButton.click();
        Assert.assertTrue((driver.findElements(By.xpath("//a[@id='welcome']")).size() > 0));
    }

    @Test(priority = 2)
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
        System.out.println(dateInString);
        driver.findElement(By.xpath("//input[@id='btnPunch']")).click(); /////////////
        Assert.assertTrue((driver.findElements(By.xpath("//h1[contains(text(),'Punch Out')]")).size() == 1));
    }

    @Test(priority = 3)
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
        Assert.assertTrue((driver.findElements(By.xpath("//h1[contains(text(),'Punch In')]")).size() == 1));
    }

    @Test(priority = 4)
    public void testCheckRecord() {
        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.xpath("//a[@id='menu_attendance_viewMyAttendanceRecord']")).click();
        WebElement fieldForDate = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        LocalDate date = LocalDate.now();
        fieldForDate.click();
        fieldForDate.sendKeys(date.toString());
        fieldForDate.sendKeys(Keys.ENTER);
        WebElement baseTable = driver.findElement(By.xpath("//table[@class='table']"));
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        boolean stringSearch = tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(timeInString)&&
                        o.contains(NOTE_IN)&&
                        o.contains(timeOutString)&&
                        o.contains(NOTE_OUT));
        Assert.assertTrue(stringSearch);
    }

    @Test(priority = 5)
    public void checkPreviousWeek() {
        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.xpath("//a[@id='menu_attendance_viewMyAttendanceRecord']")).click();
        WebElement fieldForDate = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        LocalDate previousDate = LocalDate.now().minusDays(7);
        System.out.println(previousDate.toString());
        fieldForDate.click();
        fieldForDate.clear();
        fieldForDate.sendKeys(previousDate.toString());
        fieldForDate.sendKeys(Keys.ENTER);
        //driver.findElement(By.linkText(String.valueOf(day))).click();
        Assert.assertTrue((driver.findElements(By.xpath("//td[@id='noRecordsColumn']")).size() == 1), "No attendance records to display");
    }
    @Test(priority = 6)
    public void checkNextWeek() {
        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.xpath("//a[@id='menu_attendance_viewMyAttendanceRecord']")).click();
        // driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
        WebElement fieldForDate = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        LocalDate previousDate = LocalDate.now().plusDays(7);
        System.out.println(previousDate.toString());
        fieldForDate.click();
        fieldForDate.clear();
        fieldForDate.sendKeys(previousDate.toString());
        fieldForDate.sendKeys(Keys.ENTER);
        Assert.assertTrue((driver.findElements(By.xpath("//td[@id='noRecordsColumn']")).size() == 1), "No attendance records to display");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}