package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class DataTest {

    private WebDriver driver;
    protected final Employee MY_TEST_EMPLOYEE = new Employee("Ivan", "Mosiychuk", 16);
    private final String URL = "http://test.biz.ua/symfony/web/index.php/auth/login";
    private final String LOGIN_FIELD_LOCATOR = "//*[@id=\"txtUsername\"]";
    private final String PASSWORD_FIELD_LOCATOR = "//*[@id=\"txtPassword\"]";
    private final String LOGIN_BUTTON_LOCATOR = "//*[@id=\"btnLogin\"]";
    private final String TIME_BUTTON = "//*[@id=\"menu_time_viewTimeModule\"]";
    private final String ATTENDANCE_BUTTON = "//a[@id=\"menu_attendance_Attendance\"]";
    private final String ATTENDANCE_RECORD_BUTTON = "//a[@id=\"menu_attendance_viewMyAttendanceRecord\"]";
    private final String PUNCH_BUTTON = "//a[@id='menu_attendance_punchIn']";
    private final String PUNCH_NOTE_FIELD = "//textarea[@id='note']";
    private final String PUNCH_TIME = "//*[@id=\"currentTime\"]";
    private final String PUNCH_IN_BUTTON = "//*[@id=\"btnPunch\"]";
    private final String DATE_INPUT = "//input[@id='attendance_date']";
    protected String punchInTime;
    protected String punchOutTime;
    protected String punchInMessage = "Punch IN 9097";
    protected String punchOutMessage = "Punch OUT 9097";

    @BeforeClass
    protected void initDriver() {
        Path driverPath = Paths.get("src", "main", "resources");
        System.setProperty("webdriver.chrome.driver", driverPath + File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        login();
    }

    @AfterClass
    protected void closeDriver() {
        driver.close();
    }

    private void login() {
        CredentialsHelper helper = CredentialsHelper.getInstance();
        driver.findElement(By.xpath(LOGIN_FIELD_LOCATOR)).sendKeys(helper.getLogin());
        driver.findElement(By.xpath(PASSWORD_FIELD_LOCATOR)).sendKeys(helper.getPassword());
        driver.findElement(By.xpath(LOGIN_BUTTON_LOCATOR)).click();
    }

    protected List<WebElement> getAllRecordData(LocalDate date) {
        driver.findElement(By.xpath(TIME_BUTTON)).click();
        driver.findElement(By.xpath(ATTENDANCE_BUTTON)).click();
        driver.findElement(By.xpath(ATTENDANCE_RECORD_BUTTON)).click();

        WebElement dateInputField = driver.findElement(By.xpath(DATE_INPUT));
        dateInputField.click();
        dateInputField.sendKeys(date.toString());
        dateInputField.sendKeys(Keys.ENTER);
        return driver.findElements(By.xpath("//form[@id='employeeRecordsForm']//tr[@class='odd' or @class='even']"));
    }

    protected String getRecordDataByPunchMessage(String punchMessage, int messageIndex, int timeIndex) {
        String punchDate = "";
        List<WebElement> recordData = getAllRecordData(LocalDate.now());
        List<WebElement> employeeRecord = new ArrayList<>();

        for (WebElement employeeData : recordData) {
            employeeRecord = employeeData.findElements(By.tagName("td"));
            if (employeeRecord.get(messageIndex).getText().equals(punchMessage)) {
                punchDate = employeeRecord.get(timeIndex).getText();
            }
        }
        return punchDate;
    }

    protected void punchInOut() {
        driver.findElement(By.xpath(TIME_BUTTON)).click();
        driver.findElement(By.xpath(ATTENDANCE_BUTTON)).click();
        driver.findElement(By.xpath(PUNCH_BUTTON)).click();
        driver.findElement(By.xpath(PUNCH_NOTE_FIELD)).sendKeys(punchInMessage);
        punchInTime = driver.findElement(By.xpath(PUNCH_TIME)).getText();
        driver.findElement(By.xpath(PUNCH_IN_BUTTON)).click();
        driver.findElement(By.xpath(PUNCH_NOTE_FIELD)).sendKeys(punchOutMessage);
        punchOutTime = driver.findElement(By.xpath(PUNCH_TIME)).getText();
        driver.findElement(By.xpath(PUNCH_IN_BUTTON)).click();
    }

    protected void editEmployeeData() {
        openMyInfoPage();
        WebElement firstName = driver.findElement((By.xpath("//input[@id='personal_txtEmpFirstName']")));
        WebElement lastName = driver.findElement((By.xpath("//input[@id='personal_txtEmpLastName']")));
        WebElement id = driver.findElement((By.xpath("//input[@id='personal_txtEmployeeId']")));
        WebElement editButton = driver.findElement((By.xpath("//input[@id='btnSave']")));
        editButton.click();
        firstName.clear();
        firstName.sendKeys(MY_TEST_EMPLOYEE.getFirstName());
        lastName.clear();
        lastName.sendKeys(MY_TEST_EMPLOYEE.getLastName());
        editButton.click();
    }

    private void openMyInfoPage() {
        WebElement myInfo = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
        myInfo.click();
    }

    protected String getUserLastName() {
        String userLastName = "";
        WebElement pimButton = driver.findElement((By.xpath("//a[@id='menu_pim_viewPimModule']")));
        pimButton.click();
        WebElement emloyeeListButton = driver.findElement((By.xpath("//a[@id='menu_pim_viewEmployeeList']")));
        emloyeeListButton.click();
        List<WebElement> emloyeeDataList = driver.findElements(By.xpath("//table[@id='resultTable']//tr[@class='odd' or @class='even']"));
        for (WebElement element : emloyeeDataList) {
            List<WebElement> emloyeeData = element.findElements(By.tagName("a"));
            if (emloyeeData.get(0).getText().equals(String.valueOf(MY_TEST_EMPLOYEE.getId()))) {
                userLastName = emloyeeData.get(2).getText();
            }
        }
        return userLastName;
    }
}
