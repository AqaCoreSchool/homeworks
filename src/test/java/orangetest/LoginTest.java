package orangetest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        Assert.assertTrue(loginPage.isHomePageOpened());
    }

}
