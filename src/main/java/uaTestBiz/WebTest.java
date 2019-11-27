package uaTestBiz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WebTest {
    ChromeDriver driver = new ChromeDriver(  );
    LocalDate date = LocalDate.now();
    DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formatedDate = date.format(format);

    @BeforeMethod
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver.get( "http://test.biz.ua/symfony/web/index.php/auth/login" );
        String title = driver.getTitle();
        Assert.assertTrue( title.equals( "OrangeHRM" ) );
        WebElement userName = driver.findElement(By.cssSelector("#txtUsername"));
        userName.sendKeys("TestUser09");
        WebElement password = driver.findElement(By.cssSelector("#txtPassword"));
        password.sendKeys("Vfylhfujhf!1", Keys.ENTER);
    }

    @Test
    public void inputTime(){
        WebElement time = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        time.click();
        WebElement attendance = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        attendance.click();
        WebElement punch = driver.findElement(By.id("menu_attendance_punchIn"));
        punch.click();
        WebElement noteIn = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteIn.click();
        noteIn.sendKeys("start work");
        String currentDateIn = driver.findElement(By.cssSelector("span#currentDate")).getText();
        WebElement btnIn = driver.findElement(By.cssSelector("#btnPunch"));

        Assert.assertNotSame( formatedDate, currentDateIn );
        btnIn.click();
    }
    @Test
    public void setTimeOut() {
        WebElement noteOut = driver.findElement(By.xpath("//textarea[@id='note']"));
        noteOut.click();
        noteOut.sendKeys("finish work");
        String currentDateOut = driver.findElement(By.cssSelector("span#currentDate")).getText();
        WebElement btnOut = driver.findElement(By.cssSelector("#btnPunch"));
        Assert.assertNotSame( currentDateOut, formatedDate );
            btnOut.click();
    }
    @AfterMethod
    public void close(){
    driver.quit();
    }
}
