package selenium.api.test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import selenium.model.WorkExperience;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkExperienceApiTest extends ApiBaseTest {
    private WorkExperience workExperience = new WorkExperience();

    @Test(priority = 1)
    public void postWorkExperience() {
        Response response = given().auth().oauth2(token)
                .contentType(ContentType.URLENC)
                .formParam("company", workExperience.getCompany())
                .formParam("title", workExperience.getTitle())
                .formParam("fromDate", workExperience.getFromDate())
                .formParam("toDate", workExperience.getToDate())
                .formParam("comment", workExperience.getComment())
                .post("http://test.biz.ua/symfony/web/index.php/api/v1/employee/35/work-experience");

        String body = response.getBody().asString();
        workExperience.setSeqId(JsonPath.from(body).getString("seqId"));
        assertThat(response.getStatusCode()).as("Status code should be 200").isEqualTo(HttpStatus.SC_OK);
    }

    @Test(priority = 2)
    public void getWorkExperience() {
        given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .when()
                .get("http://test.biz.ua/symfony/web/index.php/api/v1/employee/35/work-experience")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("work-experience-schema.json"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(priority = 3, dependsOnMethods = "postWorkExperience")
    public void updateWorkExperience() {
        WorkExperience updatedWorkExperience = new WorkExperience();
        Response response = given().auth().oauth2(token)
                .contentType(ContentType.URLENC)
                .formParam("seqId", workExperience.getSeqId())
                .formParam("company", updatedWorkExperience.getCompany())
                .formParam("title", updatedWorkExperience.getTitle())
                .formParam("fromDate", updatedWorkExperience.getFromDate())
                .formParam("toDate", updatedWorkExperience.getToDate())
                .formParam("comment", updatedWorkExperience.getComment())
                .urlEncodingEnabled(false)
                .when()
                .put("http://test.biz.ua/symfony/web/index.php/api/v1/employee/35/work-experience");

        assertThat(response.getStatusCode()).as("Status code should be " + HttpStatus.SC_OK)
                .isEqualTo(HttpStatus.SC_OK);

        assertThat(JsonPath.from(response.getBody().asString()).getString("success"))
                .as("Status message").isEqualTo("Successfully Updated");

        assertThat(JsonPath.from(response.getBody().asString()).getString("seqId"))
                .as("seqId number should be " + workExperience.getSeqId())
                .isEqualTo(workExperience.getSeqId());
    }

    @Test(priority = 4, dependsOnMethods = "postWorkExperience")
    public void deleteWorkExperience() {
        Response response = given().auth().oauth2(token)
                .contentType(ContentType.URLENC)
                .formParam("seqId", workExperience.getSeqId())
                .delete("http://test.biz.ua/symfony/web/index.php/api/v1/employee/35/work-experience");

        assertThat(response.getStatusCode()).as("Status code should be " + HttpStatus.SC_OK)
                .isEqualTo(HttpStatus.SC_OK);

        assertThat(JsonPath.from(response.getBody().asString()).getString("success"))
                .as("Successfully Deleted message")
                .isEqualTo("Successfully Deleted");
    }
}
