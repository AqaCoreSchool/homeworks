import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @Parameters({"Username", "Password", "Name", "Surname"})
    public void changeUserDataAndCheckUsersTest(String Username, String Password, String Name, String Surname){
        login(driver, Username, Password);
        setUserNameSurname(driver, Name, Surname);
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
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    public static void setUserNameSurname(WebDriver driver, String Name, String Surname){
        WebDriverWait editWait = new WebDriverWait(driver, 10);
        editWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewMyDetails")));
        WebElement myInfoModule = driver.findElement(By.id("menu_pim_viewMyDetails"));
        myInfoModule.click();
        WebElement editBtn =  driver.findElement(By.id("btnSave"));
        editBtn.click();
        WebElement nameField =  driver.findElement(By.id("personal_txtEmpFirstName"));
        nameField.clear();
        nameField.sendKeys(Name);
        WebElement surnameField =  driver.findElement(By.id("personal_txtEmpLastName"));
        surnameField.clear();
        surnameField.sendKeys(Surname);
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
        return findUserInList(usersList, username);
    }

    public static WebElement findUserInList(List<WebElement> list, String Username){
        for (WebElement user: list) {
            if(user.findElement(By.xpath("./td/a")).getText().equals(Username)){
                return user;
            }
        }
        return null;
    }
}
