package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.Thread.sleep;


public class WebSiteAutomationTest {

    private static final String URL = "http://test.biz.ua/";
    private static final String USERNAME = "TestUser01";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private static final String NOTE_IN = "I am punching in";
    private static final String NOTE_OUT = "I am punching out";
    private static final String NO_RECORDS = "No attendance records to display";

    private WebDriver driver;
    private Actions action;


    @BeforeTest
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void login() {
        driver.get(URL);
        WebElement username = driver.findElement(By.cssSelector("#txtUsername"));
        WebElement password = driver.findElement(By.cssSelector("#txtPassword"));
        username.sendKeys(USERNAME);
        password.sendKeys(PASSWORD);
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        submitButton.submit();
    }

    @Test(dependsOnMethods = {"login"}, groups = {"1"})
    public void punchInOut() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        action.moveToElement(time).perform();
        WebElement attendance = driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']"));
        action.moveToElement(attendance).perform();
        WebElement punchIn = driver.findElement(By.id("menu_attendance_punchIn"));
        action.moveToElement(punchIn).perform();
        punchIn.click();
        WebElement noteIn = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteIn.sendKeys(NOTE_IN);
        WebElement buttonIn = driver.findElement(By.id("btnPunch"));
        buttonIn.click();
        WebElement noteOut = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteOut.sendKeys(NOTE_OUT);
        WebElement buttonOut = driver.findElement(By.id("btnPunch"));
        buttonOut.click();
    }

    @Test(dependsOnMethods = {"login"}, groups = {"1", "2"}, priority = 1)
    public void checkActualRecords() {
        chooseDateOfRecords();
        WebElement date = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        date.clear();
        date.sendKeys(LocalDate.now().toString(), Keys.ENTER);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> cells = driver.findElements(By.tagName("td"));
        String cellPunchIn = getStringForVerification(cells, NOTE_IN);
        String cellPunchOut = getStringForVerification(cells, NOTE_OUT);

        Assert.assertEquals(cellPunchIn, NOTE_IN);
        Assert.assertEquals(cellPunchOut, NOTE_OUT);
    }

    @Test(dependsOnMethods = {"login"}, groups = {"1", "3"}, priority = 2)
    public void checkPreviousWeek() {
        chooseDateOfRecords();
        WebElement date = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        date.clear();
        date.sendKeys(LocalDate.now().minusWeeks(1).toString(), Keys.ENTER);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        String recordRow = getStringForVerification(rows, NO_RECORDS);

        Assert.assertEquals(recordRow, NO_RECORDS);
    }

    @Test(dependsOnMethods = {"login"}, groups = {"1", "3"}, priority = 2)
    public void checkNextWeek() {
        chooseDateOfRecords();
        WebElement date = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        date.clear();
        date.sendKeys(LocalDate.now().plusWeeks(1).toString(), Keys.ENTER);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        String recordRow = getStringForVerification(rows, NO_RECORDS);

        Assert.assertEquals(recordRow, NO_RECORDS);
    }

    @AfterTest
    public void shutDownDriver() {
        driver.close();
    }

    private void chooseDateOfRecords() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        action.moveToElement(time).perform();
        WebElement attendance = driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']"));
        action.moveToElement(attendance).perform();
        WebElement records = driver.findElement(By.xpath("//a[@id='menu_attendance_viewMyAttendanceRecord']"));
        action.moveToElement(records).perform();
        records.click();
    }

    private String getStringForVerification(List<WebElement> elements, String stringNote) {
        return elements.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(stringNote))
                .distinct()
                .collect(Collectors.joining());
    }
}
