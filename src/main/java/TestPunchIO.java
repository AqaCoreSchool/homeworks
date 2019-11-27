import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestPunchIO {

    private  WebDriver driver;
    private String name = "TestUser01";
    private String password = "Vfylhfujhf!1";
    private String input = "Test start";
    private String output = "Test finish";
    private Actions action ;
//    private WebElement userNameInput = driver.findElement(By.cssSelector("#txtUsername"));
//    private WebElement userPasswordInput = driver.findElement(By.cssSelector("#txtPassword"));
//    private WebElement singInButton = driver.findElement(By.cssSelector("#btnLogin"));

    @BeforeMethod
    public void setup() {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.biz.ua/");
    }

    @Test
    public void test(){
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#btnLogin")).click();


        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']")));
        action.perform();
        action.moveToElement(driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']")));
        action.perform();
        driver.findElement(By.linkText("Punch In/Out")).click();

        String date = driver.findElement(By.xpath("//span[@id='currentDate']")).getText();
        String time = driver.findElement(By.xpath("//span[@id='currentTime']")).getText();
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys(input);
        driver.findElement(By.xpath("//input[@id='btnPunch']")).click();

        String date2 = driver.findElement(By.xpath("//span[@id='currentDate']")).getText();
        String time2 = driver.findElement(By.xpath("//span[@id='currentTime']")).getText();
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys(output);
        driver.findElement(By.xpath("//input[@id='btnPunch']")).click();

        action.moveToElement(driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']")));
        action.perform();
        action.moveToElement(driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']")));
        action.perform();

        driver.findElement(By.linkText("My Records")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("27")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> tableRows = driver.findElements(By.xpath(
                "//form[@id='employeeRecordsForm']/table/tbody/tr[@class='odd' or @class='even']"));
       boolean workInDate = tableRows.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(date)&e.contains(date2)
                        &e.contains(time)&e.contains(time2)
                        &e.contains(input)&e.contains(output));
        if(workInDate=true){
            System.out.println("Test finished!!!");
        }else {
            throw new IllegalStateException("This day you haven't working hours");
        }
    }

    @Test
    public void testWithStar(){
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#btnLogin")).click();

        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']")));
        action.perform();
        action.moveToElement(driver.findElement(By.xpath("//a[@id='menu_attendance_Attendance']")));
        action.perform();

        driver.findElement(By.linkText("My Records")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("20")).click();
        try {
            WebElement message =driver.findElement(By.xpath("//td[@id='noRecordsColumn']"));
            message.isDisplayed();
        }catch (NoSuchElementException e){
            throw new IllegalStateException("This day you have working hours");
        }


        driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Dec')]")).click();
        driver.findElement(By.linkText("4")).click();
        WebElement message2 =driver.findElement(By.xpath("//td[@id='noRecordsColumn']"));
        try {
            message2.isDisplayed();
        }catch (NoSuchElementException e){
            throw new IllegalStateException("This day you have working hours");
        }
    }

    @AfterMethod
    public void  close(){
        driver.close();
    }
}
