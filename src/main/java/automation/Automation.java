package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Automation {

    private WebDriver driver;
    private static final String URL = "http://test.biz.ua";
    private static final String USER_NAME = "TestUser01";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private static Random random;
    private String message;
    private LocalDateTime dateTime;

    public Automation() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        random = new Random();
    }

    public void generateMessage() {
        message = "Andrii" + random.nextInt();
    }

    public void login() {
        driver.get(URL);

        WebElement userNameElement = driver.findElement(By.cssSelector("#txtUsername"));
        userNameElement.sendKeys(USER_NAME);
        WebElement passwordElement = driver.findElement(By.cssSelector("#txtPassword"));
        passwordElement.sendKeys(PASSWORD);

        WebElement submitButton = driver.findElement(By.cssSelector("#btnLogin"));
        submitButton.submit();

        System.out.println("Logged in successfully");
    }

    public void navigate() {
        WebElement itemFromNavigationBar = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        itemFromNavigationBar.click();

        WebElement itemFromNavigationMenu = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        itemFromNavigationMenu.click();

        WebElement itemFromNavigationSubMenu = driver.findElement(By.cssSelector("#menu_attendance_punchIn"));
        itemFromNavigationSubMenu.click();

        dateTime = LocalDateTime.now();
    }

    public void writeNote() {
        WebElement noteField = driver.findElement(By.cssSelector("#note"));
        noteField.sendKeys(message);

        WebElement buttonPunch = driver.findElement(By.cssSelector("#btnPunch"));
        buttonPunch.click();

        System.out.println("Punch was written successfully!");
    }

    public void checkRecord() {
        WebElement itemFromNavigationMenu = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        itemFromNavigationMenu.click();

        WebElement itemFromNavigationSubMenu = driver.findElement(By.cssSelector("#menu_attendance_viewMyAttendanceRecord"));
        itemFromNavigationSubMenu.click();

        WebElement calendarIcon = driver.findElement(By.cssSelector("#attendance_date"));
        calendarIcon.clear();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String labelDate = dateTime.format(formatter);

        calendarIcon.sendKeys(LocalDate.now().toString());
        calendarIcon.submit();

        List<WebElement> punchInDate = driver.findElements(By.xpath("//*[text()[contains(.,'" + labelDate + "')]]"));

        int i = 0;
        for (WebElement element : punchInDate) {
            if (element.findElement(By.xpath("following-sibling::*")).getText().equals(message)) {
                System.out.printf("Punch '%s' from '%s' exists. ", message, labelDate);
                i++;
            }
            if (i == 0) {
                System.out.println("There is no such note!");
            }
        }
        driver.close();
    }
}
