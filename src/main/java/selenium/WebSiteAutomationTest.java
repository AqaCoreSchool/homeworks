package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import static java.lang.Thread.sleep;


public class WebSiteAutomationTest {

    private static final String URL = "http://test.biz.ua/";
    private static final String USERNAME = "TestUser02";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private static final String NOTE_IN = "I am punching in";
    private static final String NOTE_OUT = "I am punching out";

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
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(USERNAME);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).submit();

        assertThat(URL).contains("http://");
    }

    public void wait(int millisec){
        try {
            sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"login"})
    public void testAutomation() {
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        action.moveToElement(time).perform();
        WebElement attendance = driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']"));
        action.moveToElement(attendance).perform();
        WebElement punchInOut = driver.findElement(By.xpath("//a[@id='menu_attendance_punchIn']"));
        action.moveToElement(punchInOut).perform();
        punchInOut.click();
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys(NOTE_IN);;
        String timeIn = driver.findElement(By.xpath("//span[@id='currentTime']")).getText();
        driver.findElement(By.xpath("//input[@id='btnPunch']")).click();
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys(NOTE_OUT);;
        String timeOut = driver.findElement(By.xpath("//span[@id='currentTime']")).getText();
        driver.findElement(By.xpath("//input[@id='btnPunch']")).click();
        chooseDateOfRecords();
        WebElement date = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        date.clear();
        date.sendKeys(LocalDate.now().toString(), Keys.ENTER);
        wait(2000);
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        String rowPunch = getStringForVerification(rows, NOTE_IN,NOTE_OUT,timeIn,timeOut);

        assertThat(rowPunch).contains(NOTE_IN,NOTE_OUT,timeIn,timeOut);
        assertThat(checkRecordsOfAnotherWeek(LocalDate.now().minusWeeks(1)).isDisplayed());
        assertThat(checkRecordsOfAnotherWeek(LocalDate.now().plusWeeks(1)).isDisplayed());
    }

    public WebElement checkRecordsOfAnotherWeek(LocalDate dates) {
        chooseDateOfRecords();
        WebElement date = driver.findElement(By.xpath("//input[@id='attendance_date']"));
        date.clear();
        date.sendKeys(dates.toString(), Keys.ENTER);
        wait(2000);
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        return driver.findElement(By.xpath("//td[@id='noRecordsColumn']"));
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

    private String getStringForVerification(List<WebElement> elements, String noteIn,
                                            String noteOut, String timeIn, String timeOut) {
        return elements.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(noteIn) && s.contains(noteOut) &&
                        s.contains(timeIn) && s.contains(timeOut))
                .findAny()
                .orElse("No such records");
    }
    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        driver.close();
    }
}
