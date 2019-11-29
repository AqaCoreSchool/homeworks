package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationTest {

    private String OS = System.getProperty("os.name").toLowerCase();
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    private String inNote = "Punched in ...";
    private String outNote = "Punched out ...";

    @BeforeTest
    public void setup() {
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir, "src", "main", "resources");
        if (OS.contains("win")) {
            System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver");
        }
        driver = new ChromeDriver();
        driver.get("http://test.biz.ua");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }

    @Test(priority = 1)
    public void login() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        username.sendKeys("TestUser08");
        password.sendKeys("Vfylhfujhf!1");
        btnLogin.click();
        sleep(3);
        WebElement welcomeText = driver.findElement(By.id("welcome"));

        Assert.assertEquals("Welcome Pavlo", welcomeText.getText());
    }

    @Test(priority = 2)
    public void fillInUserProfileForm() {
        sleep(2);
        WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
        myInfo.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave"))).click();
        List<WebElement> inputElements = driver.findElements(By.xpath("//form[@id='frmEmpPersonalDetails']/fieldset//*"));

        inputElements.stream()
                .filter(webElement -> webElement.getTagName().equals("input"))
                .filter(webElement -> webElement.getAttribute("type").equals("text"))
                .forEach(WebElement::clear);
        inputElements.stream()
                .filter(webElement -> webElement.getTagName().equals("select"))
                .map(Select::new)
                .forEach(select -> select.selectByVisibleText("-- Select --"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpFirstName")))
                .sendKeys("Pavlo");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpLastName")))
                .sendKeys("Hrytsyshyn");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtOtherID")))
                .sendKeys("08");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmployeeId")))
                .sendKeys("20");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtLicenNo")))
                .sendKeys("104128");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtLicExpDate")))
                .sendKeys(getCurrentDate().plusYears(20).toString());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_DOB")))
                .sendKeys("1998-02-06");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_optGender_1")))
                .click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_cmbNation")))
                .sendKeys("Ukr", Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_cmbMarital")))
                .sendKeys("Sin", Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();

        Assert.assertFalse(driver.findElement(By.id("personal_txtEmpFirstName")).isEnabled());
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), "Pavlo");

    }

    @Test(priority = 3)
    public void checkUserInEmployeeList() {
        sleep(2);
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        actions.moveToElement(pimOption).perform();
        WebElement employeeListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        employeeListOption.click();
        WebElement resultTable = driver.findElement(By.id("resultTable"));
        List<WebElement> webElements = resultTable.findElements(By.xpath("//tbody//td"));
        boolean isUserExists = webElements.stream()
                .anyMatch(webElement -> webElement.getText().equals("Hrytsyshyn"));
        Assert.assertTrue(isUserExists);
    }

    @Test(priority = 4)
    public void goToPunchIn() {
        sleep(2);
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

    @Test(priority = 5)
    public void performPunchInOutOperations() {
        sleep(2);
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

    @Test(priority = 6)
    public void checkMyRecords() {
        goToAttendanceView();
        WebElement attendanceDate = driver.findElement(By.id("attendance_date"));
        attendanceDate.clear();
        attendanceDate.sendKeys(getCurrentDate().toString(), Keys.ENTER);
        List<WebElement> recordsFormRows = driver.findElements(By.xpath(
                "//form[@id='employeeRecordsForm']/table/tbody/tr[@class='odd' or @class='even']"));
        WebElement myLastRecordRow = recordsFormRows.get(recordsFormRows.size() - 1);
        List<WebElement> myLastRecordDetails = myLastRecordRow.findElements(By.xpath("./td"));

        Assert.assertEquals(myLastRecordDetails.get(1).getText(), getCurrentDateTime());
        Assert.assertEquals(inNote, myLastRecordDetails.get(2).getText());
        Assert.assertEquals(myLastRecordDetails.get(3).getText(), getCurrentDateTime());
        Assert.assertEquals(outNote, myLastRecordDetails.get(4).getText());
    }

    @Test(priority = 7)
    public void checkWeekAgoRecords() {
        goToAttendanceView();
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

    public static String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String  simpleDateFormat = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        return String.format("%s %s:00 GMT 2", dtf.format(localDate), simpleDateFormat);
    }

    public LocalDate getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        return LocalDate.parse(dtf.format(localDate));
    }

    public void goToAttendanceView() {
        WebElement attendanceOption2 = driver.findElement(By.id("menu_attendance_Attendance"));
        actions.moveToElement(attendanceOption2).perform();
        WebElement myRecordsOption = driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecordsOption.click();
    }
}
