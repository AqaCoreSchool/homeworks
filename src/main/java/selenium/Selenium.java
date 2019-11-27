package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    static final String username = "TestUser01";
    static final String password = "Vfylhfujhf!1";
    static final String startMessage = "Start work!";
    static final String endMessage = "Stop work!";
    static final String todayDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.biz.ua");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement timeSection = driver.findElement(By.id("menu_time_viewTimeModule"));
        timeSection.click();
        WebElement attendanceMenu =  driver.findElement(By.id("menu_attendance_Attendance"));
        attendanceMenu.click();
        WebElement punchInOut =  driver.findElement(By.id("menu_attendance_punchIn"));
        punchInOut.click();
        WebElement startDate = driver.findElement(By.id("currentDate"));
        WebElement startTime = driver.findElement(By.id("currentTime"));
        String punchInDateTime = String.format("%s %s:00 GMT 2", startDate.getText(), startTime.getText());
        WebElement inTextArea = driver.findElement(By.xpath("//textarea[@id='note']"));
        inTextArea.sendKeys(startMessage);
        WebElement buttonPunchIn = driver.findElement(By.id("btnPunch"));
        buttonPunchIn.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement endDate = driver.findElement(By.id("currentDate"));
        WebElement endTime = driver.findElement(By.id("currentTime"));
        String punchOutDateTime = String.format("%s %s:00 GMT 2", endDate.getText(), endTime.getText());
        WebElement outTextArea = driver.findElement(By.xpath("//textarea[@id='note']"));
        outTextArea.sendKeys(endMessage);
        WebElement buttonPunchOut = driver.findElement(By.id("btnPunch"));
        buttonPunchOut.click();
        attendanceMenu =  driver.findElement(By.id("menu_attendance_Attendance"));
        attendanceMenu.click();
        WebElement myRecords =  driver.findElement(By.id("menu_attendance_viewMyAttendanceRecord"));
        myRecords.click();
        WebElement dateField =  driver.findElement(By.id("attendance_date"));
        dateField.clear();
        dateField.sendKeys(todayDate + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> tableRows = driver.findElements(By.xpath(
                "//form[@id='employeeRecordsForm']/table/tbody/tr[@class='odd' or @class='even']"));
        WebElement latestRecord = tableRows.get(tableRows.size()-1);
        List<WebElement> latestRecordBody = latestRecord.findElements(By.xpath("./td"));
        String recordStartDateTime = latestRecordBody.get(1).getText();
        System.out.println(recordStartDateTime);
        String recordPunchInNote = latestRecordBody.get(2).getText();
        System.out.println(recordPunchInNote);
        String recordEndDateTime = latestRecordBody.get(3).getText();
        System.out.println(recordEndDateTime);
        String recordPunchOutNote = latestRecordBody.get(4).getText();
        System.out.println(recordPunchOutNote);
        if(!punchInDateTime.equals(recordStartDateTime)){
            System.out.println("Test failed - record Punch In datetime is different then actual Punch In datetime!");
        } else if(!startMessage.equals(recordPunchInNote)){
            System.out.println("Test failed - record Punch In note is different then actual Punch In note!");
        } else if(!punchOutDateTime.equals(recordEndDateTime)){
            System.out.println("Test failed - record Punch Out datetime is different then actual Punch Out datetime!");
        } else if(!endMessage.equals(recordPunchOutNote)){
            System.out.println("Test failed - record Punch Out note is different then actual Punch Out note!");
        } else {
            System.out.println("All data matched correctly - test passed!");
        }
        driver.quit();


    }
}
