package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Automation {

    private WebDriver driver;

    public Automation() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    public String generateMessage() {
        Random random = new Random();
        return "Andrii" + random.nextInt();
    }

    public void login() {
        driver.get("http://test.biz.ua");

        WebElement userNameElement = driver.findElement(By.cssSelector("#txtUsername"));
        userNameElement.sendKeys("TestUser01");
        WebElement passwordElement = driver.findElement(By.cssSelector("#txtPassword"));
        passwordElement.sendKeys("Vfylhfujhf!1");

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
    }

    public void writeNote(String message) {
        WebElement noteField = driver.findElement(By.cssSelector("#note"));
        noteField.sendKeys(message);

        WebElement buttonPunch = driver.findElement(By.cssSelector("#btnPunch"));
        buttonPunch.click();

        System.out.println("Punch was written successfully!");
    }

    public void checkRecord(String message) {
        WebElement itemFromNavigationMenu = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        itemFromNavigationMenu.click();

        WebElement itemFromNavigationSubMenu = driver.findElement(By.cssSelector("#menu_attendance_viewMyAttendanceRecord"));
        itemFromNavigationSubMenu.click();

        WebElement calendarIcon = driver.findElement(By.cssSelector("#attendance_date"));
        calendarIcon.clear();

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String labelDate = dateTime.format(formatter);

        calendarIcon.sendKeys(LocalDate.now().toString());
        calendarIcon.submit();

        WebElement punchInNOte = driver.findElement(By.xpath("//*[text()[contains(.,'" + labelDate + "')]]"));
        WebElement next = punchInNOte.findElement(By.xpath("following-sibling::*"));

        System.out.println("Punch " + message + " exists: " + (next.getText().equals(message)));
    }
}
