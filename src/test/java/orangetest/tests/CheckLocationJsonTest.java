package orangetest.tests;

import orangetest.pages.LocationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLocationJsonTest extends BaseTest {
    LocationPage location;

    @Test
    public void addLocationJson() {
        location = new LocationPage();
        Assert.assertTrue(location.checkFromJSON());
    }
}
