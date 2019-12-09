package testsapi;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import data.WorkExperience;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteEmployeeWorkExperienceTest extends BaseApiTest{

    @Test
    public void testdeleteEmployeeWorkExperience(){
        WorkExperience workExperience = new WorkExperience();
        Response response = workExperience.deleteEmployeeExperience(29, 3);

        assertThat(response.getStatusCode())
                .as(response.getBody().asString()).isEqualTo(200);
    }
}
