package tests;

import data.Location;
import data.LoginInfo;
import org.testng.annotations.Test;
import pages.LocationsPage;

import static org.assertj.core.api.Assertions.*;

public class LocationsPageTest extends BaseTest{

    @Test
    public void testLocationPage(){
        Location location = new Location();
        LocationsPage locationsPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .moveToLocationsPage()
                .createLocation(location);

        assertThat(locationsPage.isLocationCreated(location))
                .as("Location is already exists").isTrue();
    }
}
