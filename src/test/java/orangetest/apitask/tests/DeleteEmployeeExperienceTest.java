package orangetest.apitask.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteEmployeeExperienceTest extends BaseApiTest {
    @Test
    public void deleteEmployeeExperienceTest() {
        Assert.assertEquals(e.deleteEmployeeExperience().getStatusCode(),200);
    }
}
