package ua.biz.test.tests.APItest.workExperience;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseAPItest;

public class CreateEmployeeWorkExperienceTest extends BaseAPItest {

    @Test
    public void testCreateEmployeeWorkExperience() {
        Assert.assertEquals(createEmployeeWorkExperience(workExperience).getStatusCode(), 200);
    }
}
