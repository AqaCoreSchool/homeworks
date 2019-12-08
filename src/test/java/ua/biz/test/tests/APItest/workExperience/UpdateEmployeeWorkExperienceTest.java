package ua.biz.test.tests.APItest.workExperience;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseAPItest;

public class UpdateEmployeeWorkExperienceTest  extends BaseAPItest {
    @Test
    public void validateUpdatingEmployeeWorkExperience() {
        workExperience.setTitle("My best experience");
        Assert.assertEquals(updateEmployeeWorkExperience(workExperience).getStatusCode(), 200);
    }
}
