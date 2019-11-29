package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class UserInfoTest {

    private static final String URL = "http://test.biz.ua/";
    private static final String USER_NAME = "TestUser02";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private static final String NAME = "Andrii";
    private static final String LAST_NAME = "Shtyiuk";

    private WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void login() {
        driver.get(URL);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(USER_NAME);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).submit();

        assertThat(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed());
    }

    @Test(dependsOnMethods = {"login"})
    public void testUser(){
        editUserInfo();
        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        List<WebElement> employeeList = driver.findElements(By.tagName("tr"));
        String user = employeeList.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(NAME))
                .filter(s -> s.contains(LAST_NAME))
                .findAny()
                .orElse("User is not find");

        assertThat(user).contains(NAME, LAST_NAME);
    }

    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        driver.close();
    }

    public void editUserInfo(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        driver.manage().timeouts();
        WebElement editOrSave = driver.findElement(By.xpath("//input[@id='btnSave']"));
        editOrSave.click();
        WebElement name = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        name.clear();
        name.sendKeys(NAME);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        lastName.clear();
        lastName.sendKeys(LAST_NAME);
        WebElement myId = driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']"));
        myId.clear();
        myId.sendKeys("02");
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='personal_optGender_1']"));
        radioButton.click();
        Select marital = new Select(driver.findElement(By.xpath("//select[@id='personal_cmbMarital']")));
        marital.selectByVisibleText("Married");
        Select nationality = new Select(driver.findElement(By.xpath("//select[@id='personal_cmbNation']")));
        nationality.selectByVisibleText("Ukrainian");
        WebElement birthDate = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
        birthDate.clear();
        birthDate.sendKeys(LocalDate.of(1987, 11, 23).toString());
        editOrSave.click();
    }
}
