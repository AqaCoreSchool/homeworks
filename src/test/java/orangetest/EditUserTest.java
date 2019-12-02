package orangetest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EditUserTest extends BaseTest{
    private EditUserPage userPage;

    @BeforeTest
    public void beforeClass() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05","Vfylhfujhf!1");
        userPage = new EditUserPage(driver);
    }

    @Test
    public void editUserTest(){
        userPage.editUser();
        boolean result = userPage.checkEditedUser();
        Assert.assertTrue(result);

    }

    @AfterTest
    public void close() {
        driver.close();
    }

}
