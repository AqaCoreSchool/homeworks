package testpackage.test.apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import testpackage.base.BaseAPITest;

public class GetEmployeeTest extends BaseAPITest {

    @Test
    public void verifyGetEmployeeWorkExperiences() {
        Assert.assertEquals(getEmployeeWorkExperiences().getStatusCode(), 200);
    }
}
