package orangetest.tests;

import orangetest.data.Location;
import orangetest.pages.LocationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddLocationTest extends BaseTest {
    private LocationPage addLocationPage;

    @Test
    public void addLocationTest() {
        Location location = new Location();
        addLocationPage = new LocationPage();
        Assert.assertTrue(addLocationPage
                        .addLocation(location.getName(),
                                    location.getCountry(),
                                    location.getCity(),
                                    location.getAddress(),
                                    location.getState(),
                                    location.getZipPostalCode())
                        .isLocationAdded(location.getName(),
                                    location.getCountry(),
                                    location.getCity()),
                "Location is not added or added incorrectly");
    }
}
