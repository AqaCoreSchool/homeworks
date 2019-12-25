package orangetest.apitask.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateEmployeeExperienceTest extends BaseApiTest {
    @Test
    public void updateEmployeeExperienceTest() {
        Assert.assertEquals(e.updateEmployeeExperience().getStatusCode(),200);
    }
}
