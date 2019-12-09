package apitask.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveEmployeeExperienceTest extends BaseApiTest {

    @Test
    public void saveEmployeeExperienceTest() {
        Assert.assertEquals(e.saveEmployeeExperience().getStatusCode(),200);
    }
}
