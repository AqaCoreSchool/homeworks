package ua.biz.test.tests.APItest.workExperience;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseAPItest;

public class DeleteEmployeeWorkExperienceTest extends BaseAPItest {

    @Test
    public void validateDeletingEmployeeWorkExperience() {
        Assert.assertEquals(deleteEmployeeWorkExperience(workExperience).getStatusCode(), 200);
    }
}
