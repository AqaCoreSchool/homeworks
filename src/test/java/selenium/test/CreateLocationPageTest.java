package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.CreateLocationPage;

public class CreateLocationPageTest extends BaseTest {

    @Test
    public void createLocationTest() {
        CreateLocationPage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToAdminMenu()
                .moveToOrganizationMenu()
                .createNewLocation()
                .fillLocationName(getLocation().getName())
                .fillCountry(getLocation().getCountry())
                 .fillCity(getLocation().getCity())
                .fillPhone(getLocation().getPhone())
                .saveLocation();

        boolean isCreated = page.toLocationPage()
                .checkLocation(getLocation().getName(), getLocation().getCity());
        Assert.assertTrue(isCreated, "Location is not created.");
    }
}
