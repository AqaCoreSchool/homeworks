package testsapi;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import data.WorkExperience;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateEmployeeWorkExperienceTest extends BaseApiTest{

    @Test
    public void testUpdateEmployeeWorkExperience(){
        WorkExperience workExperience = new WorkExperience();
        Response response = workExperience.updateEmployeeExperience(29, 6);

        assertThat(response.getStatusCode())
                .as(response.getBody().asString()).isEqualTo(200);
    }
}
