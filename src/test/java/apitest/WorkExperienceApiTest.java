package apitest;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.anyOf;

import data.WorkExperienceData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WorkExperienceApiTest extends BaseApiTest {
    private WorkExperienceData experience = new WorkExperienceData();
    private WorkExperienceData experienceUpd = new WorkExperienceData();

    @Test
    public void SaveWorkExperience(){
        RestAssured.baseURI = uri;
        RestAssured.basePath = path;
        Response response = RestAssured.given()
                .pathParam("id", USER_ID)
                .auth().oauth2(token)
                .contentType("multipart/form-data")
                .multiPart("id", USER_ID)
                .multiPart("company", experience.getCompany())
                .multiPart("title", experience.getJobTitle())
                .multiPart("fromDate", experience.getFromDate())
                .multiPart("toDate", experience.getToDate())
                .multiPart("comment", experience.getComment())
                .post();
        String body = response.getBody().asString();
        seqId = JsonPath.from(body).getString("seqId");
        assertThat(response.getStatusCode()).as("Status code").isEqualTo(200);
        assertThat(response.getBody().asString().contains("Successfully Saved")).as("Save notification").isTrue();

    }

    @Test(priority = 2, dependsOnMethods = "SaveWorkExperience")
    public void GetWorkExperience(){
        RestAssured.baseURI = uri;
        RestAssured.basePath = path;
        RestAssured.given()
                .pathParam("id", USER_ID)
                .auth().oauth2(token)
                .when()
                .get()
                .then()
                .body("data.company", anyOf(hasItem(experience.getCompany())))
                .body("data.jobTitle", anyOf(hasItem(experience.getJobTitle())))
                .body("data.fromDate", anyOf(hasItem(experience.getFromDate())))
                .body("data.toDate", anyOf(hasItem(experience.getToDate())))
                .body("data.comment", anyOf(hasItem(experience.getComment())))
                .statusCode(200);

    }

    @Test(priority = 3, dependsOnMethods = "SaveWorkExperience")
    public void UpdateWorkExperience(){
        RestAssured.baseURI = uri;
        RestAssured.basePath = path;
        RestAssured.given()
                .pathParam("id", USER_ID)
                .auth().oauth2(token)
                .contentType("application/x-www-form-urlencoded")
                .formParam("id", USER_ID)
                .formParam("seqId", seqId)
                .formParam("company", experienceUpd.getCompany())
                .formParam("title", experienceUpd.getJobTitle())
                .formParam("fromDate", experienceUpd.getFromDate())
                .formParam("toDate", experienceUpd.getToDate())
                .formParam("comment", experienceUpd.getComment())
                .when()
                .put()
                .then()
                .body("success", equalTo("Successfully Updated"))
                .statusCode(200);
    }

    @Test(priority = 4, dependsOnMethods = "SaveWorkExperience")
    public void DeleteWorkExperience(){
        RestAssured.baseURI = uri;
        RestAssured.basePath = path;
        RestAssured.given().pathParam("id", USER_ID)
                .auth().oauth2(token)
                .contentType("application/x-www-form-urlencoded")
                .formParam("id", USER_ID)
                .formParam("seqId", seqId)
                .when()
                .delete()
                .then()
                .body("success", equalTo("Successfully Deleted"))
                .statusCode(200);
    }
}
