package tests;

import data.LocationInfo;
import data.UserInfo;
import org.testng.annotations.Test;
import pages.LocationsPage;

import static org.assertj.core.api.Assertions.*;

public class LocationsPageTest extends BaseTest{

    @Test
    public void testLocationPage(){
        LocationsPage locationsPage = loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToLocationsPage()
                .createLocation();

        assertThat(locationsPage.isLocationCreated(LocationInfo.LOCATION_NAME, LocationInfo.CITY,
                LocationInfo.COUNTRY, LocationInfo.PHONE_NUMBER))
                .as("Location is already exists").isTrue();
    }
}
