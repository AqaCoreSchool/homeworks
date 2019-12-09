package apitask.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetEmployeeExperienceTest extends BaseApiTest {
    @Test
    public void getEmployeeExperienceTest() {
        Assert.assertEquals(e.getEmployeeExperience().getStatusCode(),200);
    }
}
