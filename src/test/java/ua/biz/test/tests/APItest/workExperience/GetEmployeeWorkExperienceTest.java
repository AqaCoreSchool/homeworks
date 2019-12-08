package ua.biz.test.tests.APItest.workExperience;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseAPItest;

public class GetEmployeeWorkExperienceTest extends BaseAPItest {
    @Test
    public void validateGettingEmployeeWorkExperiences() {
        Assert.assertEquals(getEmployeeWorkExperiences().getStatusCode(), 200);
    }
}
