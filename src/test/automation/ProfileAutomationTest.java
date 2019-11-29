package automation;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class ProfileAutomationTest {

    private WebDriver driver;
    private static final String URL = "http://test.biz.ua";
    private static final String USER_NAME = "TestUser01";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private WebDriverWait wait;
    private static Faker faker = new Faker();

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 15);
    }

    @BeforeMethod
    public void login() {
        driver.get(URL);

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(USER_NAME);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("#btnLogin")).submit();
    }

    @Test(dataProvider = "getData")
    public void setPersonalDetail(String firstName, String lastName, String birthday) {
        driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnSave']")));
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

        WebElement inputFirstName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);

        WebElement inputLastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        inputLastName.clear();
        inputLastName.sendKeys(lastName);

        driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();

        driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();

        driver.findElement(By.xpath("//option[contains(text(),'Ukrainian')]")).click();

        WebElement inputDate = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
        inputDate.clear();
        inputDate.sendKeys(birthday);

        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    }

    @Test(priority = 1)
    public void checkProfileInList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'PIM')]")));
        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("13")));
            WebElement profileID = driver.findElement(By.linkText("13"));

            System.out.printf("Profile '%s' exists ", profileID.getText());
        } catch (NoSuchElementException e) {
            System.out.println("Profile not exists ");
        }

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{faker.name().firstName(), faker.name().lastName(),
                String.format("%d-%d-%d",
                        faker.number().numberBetween(1970, 2010),
                        faker.number().numberBetween(10, 12),
                        faker.number().numberBetween(10, 27))}};
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
