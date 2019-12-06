package orangetest.tests;

import orangetest.pages.LocationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddLocationTest extends BaseTest {
    private LocationPage addLocationPage;

    @Test
    public void addLocationTest() {
        addLocationPage = new LocationPage();
        Assert.assertTrue(addLocationPage
                        .addLocation()
                        .checkLocation(),
                "Location is not added or added incorrectly");
    }
}
