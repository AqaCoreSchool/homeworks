
package testpackage.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import testpackage.entity.WorkExperience;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
    private String token;

    @BeforeClass
    protected void getToken() {
        RestAssured.baseURI="http://test.biz.ua/symfony/web/index.php";
        JSONObject ob = new JSONObject();
        ob.put("grant_type", "client_credentials");
        ob.put("client_id", "myadmin");
        ob.put("client_secret", "kt]p]$BF6K`2wLWT");

        String response = given()
                .header("Content-Type", "application/json")
                .body(ob)
                .post("/oauth/issueToken").getBody().asString();
        token = JsonPath.from(response).getString("access_token");
    }

    protected Response createEmployeeWorkExperience(WorkExperience workExperience) {
        return given().auth().oauth2(token).contentType("multipart/form-data")
                .multiPart("company", workExperience.getCompany())
                .multiPart("title", workExperience.getTitle())
                .when()
                .post("/api/v1/employee/31/work-experience");
    }


    protected Response getEmployeeWorkExperiences() {
        return given().auth().oauth2(token)
                .contentType("multipart/form-data")
                .when().get("/api/v1/employee/31/work-experience");
    }


    protected Response updateEmployeeWorkExperience(WorkExperience workExperience) {
        return given().auth().oauth2(token)
                .contentType(ContentType.URLENC)
                .formParam("company", workExperience.getCompany())
                .formParam("title", workExperience.getTitle())
                .formParam("seqId", 1)
                .when()
                .put("/api/v1/employee/31/work-experience");
    }


    protected Response deleteEmployeeWorkExperience(WorkExperience workExperience) {
        return given().auth().oauth2(token)
                .contentType(ContentType.URLENC)
                .formParam("id", "31")
                .formParam("seqId", 1)
                .when()
                .delete("/api/v1/employee/31/work-experience");
    }
}
