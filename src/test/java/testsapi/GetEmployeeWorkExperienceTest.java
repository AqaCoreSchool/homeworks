package testsapi;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import data.WorkExperience;

import static org.assertj.core.api.Assertions.assertThat;


public class GetEmployeeWorkExperienceTest extends BaseApiTest{

    @Test
    public void testGetEmployeeExperience(){
        Response response = workExperience.getEmployeeExperience();

        assertThat(response.getStatusCode())
                .as(response.getBody().asString()).isEqualTo(200);
        System.out.println(response.getBody().asString());
    }
}
