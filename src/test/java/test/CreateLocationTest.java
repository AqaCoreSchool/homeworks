package test;

import data.LocationData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeAdminPage;

public class CreateLocationTest extends BaseTest{
    LocationData location = new LocationData();

    @Test
    public void createLocationTest(){
        OrangeAdminPage adminPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toAdminModulePage()
                .toOrganization()
                .toLocations()
                .createLocation(location);
        Assert.assertTrue(adminPage.findLocation(location), "Created location not found!");
    }
}
