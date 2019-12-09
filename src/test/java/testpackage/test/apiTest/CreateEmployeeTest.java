package testpackage.test.apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import testpackage.base.BaseAPITest;
import testpackage.entity.WorkExperience;
import testpackage.factory.WorkExperienceFactory;

public class CreateEmployeeTest extends BaseAPITest {

    private WorkExperience workExperience = new WorkExperienceFactory().WorkExperienceDefault();

    @Test
    public void verifyCreateEmployeeWorkExperience() {
        Assert.assertEquals(createEmployeeWorkExperience(workExperience).getStatusCode(), 200);
    }
}
