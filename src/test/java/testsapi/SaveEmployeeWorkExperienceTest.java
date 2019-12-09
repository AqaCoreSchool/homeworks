package testsapi;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import data.WorkExperience;

import static org.assertj.core.api.Assertions.assertThat;


public class SaveEmployeeWorkExperienceTest extends BaseApiTest {

    @Test
    public void testSaveEmployeeWorkExperience() {
        Response response = workExperience.saveEmployeeExperience();

        assertThat(response.getStatusCode())
                .as(response.getBody().asString()).isEqualTo(200);
    }
}
