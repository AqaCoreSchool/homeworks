package ua.biz.test.tests.UItest.location;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;
import ua.biz.test.entity.Location;
import ua.biz.test.pages.LocationsPage;


public class LocationDataTest extends BaseTest {

    @Test
    public void testLocationData() {
        LocationsPage locationsPage = mainPage.openLocationPage();
        locationsPage.openCreateLocationPage().createNewLocation(TEST_LOCATION);
        Assert.assertTrue(locationsPage.isLocationPresent(TEST_LOCATION), "Not found a location with  this data");
    }
}