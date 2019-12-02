package ua.biz.test.userData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.BaseTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorrectUserDataTest extends BaseTest {

    @Test
    public void testCorectUserData() {
        mainPage.openMyInfoPage(driver).editEmployeeData();
        mainPage.openEmployeeListPage(driver);
        Map<String,String> userData = getUserDate();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userData.get("first name"),MY_TEST_EMPLOYEE.getFirstName());
        softAssert.assertEquals(userData.get("last name"),MY_TEST_EMPLOYEE.getLastName());
        softAssert.assertAll();
    }

    private Map<String,String> getUserDate() {
        Map<String,String> userData = new HashMap<>();
        List<WebElement> emloyeeDataList = driver.findElements(By.xpath("//table[@id='resultTable']//tr[@class='odd' or @class='even']"));

       //Зробити через Lambda
        for (WebElement element : emloyeeDataList) {
            List<WebElement> emloyeeData = element.findElements(By.tagName("a"));
            if (emloyeeData.get(0).getText().equals(String.valueOf(MY_TEST_EMPLOYEE.getId()))) {
                userData.put("first name",emloyeeData.get(1).getText());
                userData.put("last name",emloyeeData.get(2).getText());
                //---------------------------------------------------
            }
        }
        return userData;
    }
}
