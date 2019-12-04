package tests;

import data.LocationInfo;
import data.UserInfo;
import org.testng.annotations.Test;
import pages.LocationsPage;

import static org.assertj.core.api.Assertions.*;

public class LocationsPageTest extends BaseTest{

    @Test
    public void testLocationPage(){
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToLocationsPage()
                .createLocation();

        assertThat(new LocationsPage().isLocationCreated(LocationInfo.LOCATION_NAME, LocationInfo.CITY,
                LocationInfo.COUNTRY, LocationInfo.PHONE_NUMBER))
                .as("Locations form should contain created location").isTrue();
    }
}
