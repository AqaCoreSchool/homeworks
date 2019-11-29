import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class OrangeUserInfoTest {
    private WebDriver driver;

    @BeforeMethod
    @Parameters({"Url"})
    public void setUp(String Url){
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    @Parameters({"Username", "Password", "Name", "Surname", "DateOfBirth"})
    public void changeUserDataAndCheckUsersTest(String Username, String Password, String Name, String Surname, String DateOfBirth){
        login(driver, Username, Password);
        setUserData(driver, Name, Surname, DateOfBirth);
        WebElement userRecord = getUserFromList(driver, Username);
        List<WebElement> userRecordElements = userRecord.findElements(By.xpath("./td"));
        Assert.assertEquals(userRecordElements.get(3).getText(), String.format("%s %s", Name, Surname),
                "User name and surname in list is different!");
    }

    public static void login(WebDriver driver, String username, String password){
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();
    }

    public static void setUserData(WebDriver driver, String name, String surname, String dateOfBirth){
        WebDriverWait editWait = new WebDriverWait(driver, 10);
        editWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewMyDetails")));
        WebElement myInfoModule = driver.findElement(By.id("menu_pim_viewMyDetails"));
        myInfoModule.click();
        WebElement editBtn =  driver.findElement(By.id("btnSave"));
        editBtn.click();
        WebElement nameField =  driver.findElement(By.id("personal_txtEmpFirstName"));
        nameField.clear();
        nameField.sendKeys(name);
        WebElement surnameField =  driver.findElement(By.id("personal_txtEmpLastName"));
        surnameField.clear();
        surnameField.sendKeys(surname);
        WebElement genderMaleRadioBtn = driver.findElement(By.id("personal_optGender_1"));
        genderMaleRadioBtn.click();
        Select maritalStatusSelect = new Select(driver.findElement(By.id("personal_cmbMarital")));
        maritalStatusSelect.selectByIndex(1);
        Select nationalitySelect = new Select(driver.findElement(By.id("personal_cmbNation")));
        nationalitySelect.selectByValue("185");
        WebElement dateOfBirthField = driver.findElement(By.id("personal_DOB"));
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(dateOfBirth);
        editWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
        editBtn.click();
        WebDriverWait saveWait = new WebDriverWait(driver, 10);
        saveWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("message.success.fadable")));
    }

    public static WebElement getUserFromList(WebDriver driver, String username){
        WebElement adminModule = driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminModule.click();
        WebElement userManagementMenu =  driver.findElement(By.id("menu_admin_UserManagement"));
        userManagementMenu.click();
        List<WebElement> usersList = driver.findElements(By.xpath(
                "//table[@id='resultTable']//tr[@class='odd' or @class='even']"));
        return usersList.stream()
                .filter(o -> o.getText().contains(username))
                .findFirst()
                .orElse(null);
    }
}
