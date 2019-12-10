package testpackage.test.apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import testpackage.base.BaseAPITest;
import testpackage.entity.WorkExperience;
import testpackage.factory.WorkExperienceFactory;

public class DeleteEmployeeTest extends BaseAPITest {

    private WorkExperience workExperience = new WorkExperienceFactory().WorkExperienceDefault();

    @Test
    public void verifyDeleteEmployeeWorkExperience() {
        Assert.assertEquals(deleteEmployeeWorkExperience(workExperience).getStatusCode(), 200);
    }

}
