import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.CredentialsHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FirstTest {

    private static final String LOGIN_FIELD_LOCATOR = "//*[@id=\"txtUsername\"]";
    private static final String PASSWORD_FIELD_LOCATOR = "//*[@id=\"txtPassword\"]";
    private static final String LOGIN_BUTTON_LOCATOR = "//*[@id=\"btnLogin\"]";
    private static final String URL = "http://test.biz.ua/symfony/web/index.php/auth/login";
    private static final String TIME_BUTTON = "//*[@id=\"menu_time_viewTimeModule\"]";
    private static final String ATTENDANCE_BUTTON = "//a[@id=\"menu_attendance_Attendance\"]"; //a[@id='menu_attendance_Attendance']
    private static final String ATTENDANCE_RECORD_BUTTON = "//a[@id=\"menu_attendance_viewMyAttendanceRecord\"]";//a[@id="menu_attendance_viewMyAttendanceRecord"]
    private static final String PUNCH_BUTTON = "//a[@id='menu_attendance_punchIn']";
    private static final String PUNCH_NOTE_FIELD = "//textarea[@id='note']";
    private static final String PUNCH_TIME = "//*[@id=\"currentTime\"]";
    private static final String PUNCH_IN_BUTTON = "//*[@id=\"btnPunch\"]";
    private static final String DATE_INPUT = "//input[@id='attendance_date']";
    private static final String USER_TABLE = "//table[@class='table']//tbody";



    private static String punchInTime;
    private static String punchOutTime;
    private static String punchInMessage="Punch IN 9095";
    private static String punchOutMessage="Punch OUT 9095";
    private static WebDriver driver;

    @BeforeTest
    public static void prepareBrouser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe"); //Separator
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        login();
    }

    @Test
    public static void checkPunchInDateTest() {
        SoftAssert softAssert = new SoftAssert();
        punchIn();
        List<WebElement> recordData = getRecordData(LocalDate.now());
        List<WebElement> employeeRecord = new ArrayList<>();
        for (WebElement employeeData : recordData) {
            employeeRecord = employeeData.findElements(By.tagName("td"));
            if (employeeRecord.size() > 5 && employeeRecord.get(2).getText().equals(punchInMessage)) {
                softAssert.assertTrue(employeeRecord.get(1).getText().contains(punchInTime));
            }
            softAssert.assertAll();
        }
    }

    @Test
    public static void checkPunchOutDateTest() {
        SoftAssert softAssert = new SoftAssert();
        punchOut();
        List<WebElement> recordData = getRecordData(LocalDate.now());
        List<WebElement> employeeRecord = new ArrayList<>();
        for (WebElement employeeData : recordData) {
            employeeRecord = employeeData.findElements(By.tagName("td"));
            if (employeeRecord.size() > 5 && employeeRecord.get(4).getText().equals(punchOutMessage)) {
                softAssert.assertTrue(employeeRecord.get(3).getText().contains(punchOutTime));
            }
            softAssert.assertAll();
        }
    }

    @Test
    public static void checkTomorrowRecordsLisrTest() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> recordData = getRecordData(LocalDate.now().plusDays(1));
        System.out.println(recordData.size());
        softAssert.assertTrue(recordData.size()<=1);
        softAssert.assertAll();
    }

    @Test
    public static void checkYesterdayRecordsLisrTest() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> recordData = getRecordData(LocalDate.now().minusDays(1));
        softAssert.assertTrue(recordData.size()>1);
        softAssert.assertAll();
    }

    private static void login() {
        CredentialsHelper helper = CredentialsHelper.getInstance();
        driver.findElement(By.xpath(LOGIN_FIELD_LOCATOR)).sendKeys(helper.getLogin());
        driver.findElement(By.xpath(PASSWORD_FIELD_LOCATOR)).sendKeys(helper.getPassword());
        driver.findElement(By.xpath(LOGIN_BUTTON_LOCATOR)).click();
    }

    private static void punchIn() {

        driver.findElement(By.xpath(TIME_BUTTON)).click();
        driver.findElement(By.xpath(ATTENDANCE_BUTTON)).click();
        driver.findElement(By.xpath(PUNCH_BUTTON)).click();
        driver.findElement(By.xpath(PUNCH_NOTE_FIELD)).sendKeys(punchInMessage);
        punchInTime = driver.findElement(By.xpath(PUNCH_TIME)).getText();

        System.out.println(punchInTime + "  punchIn");


        driver.findElement(By.xpath(PUNCH_IN_BUTTON)).click();
    }

    private static void punchOut() {

        driver.findElement(By.xpath(TIME_BUTTON)).click();
        driver.findElement(By.xpath(ATTENDANCE_BUTTON)).click();
        driver.findElement(By.xpath(PUNCH_BUTTON)).click();
        driver.findElement(By.xpath(PUNCH_NOTE_FIELD)).sendKeys(punchOutMessage);
        punchOutTime = driver.findElement(By.xpath(PUNCH_TIME)).getText();
        System.out.println(punchOutTime + "  punchOut");
        driver.findElement(By.xpath(PUNCH_IN_BUTTON)).click();
    }

    private static List<WebElement> getRecordData(LocalDate date) {

        driver.findElement(By.xpath(TIME_BUTTON)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(ATTENDANCE_BUTTON)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(ATTENDANCE_RECORD_BUTTON)).click();

        WebElement dateInputField = driver.findElement(By.xpath(DATE_INPUT));
        dateInputField.click();
        dateInputField.sendKeys(date.toString());
        driver.findElement(By.xpath("//ol[@class='normal']//li")).click();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement emploeeRecords = driver.findElement(By.xpath(USER_TABLE));
        return emploeeRecords.findElements(By.tagName("tr"));
    }

    @AfterTest
    public static void closeBrouser() {
        driver.close();
    }


}
