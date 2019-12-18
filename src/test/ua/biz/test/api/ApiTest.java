package ua.biz.test.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ua.biz.test.data.Credential;
import ua.biz.test.data.DataFaker;
import ua.biz.test.data.Path;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

public class ApiTest {
    private String token;
    private String employeeId;
    private String seqId;
    private DataFaker dataFaker = new DataFaker();
    private static final String SUCCESS = "success";

    @BeforeSuite
    public void init() {
        JSONObject ob = new JSONObject();
        ob.put("grant_type", "client_credentials");
        ob.put("client_id", Credential.ID);
        ob.put("client_secret", Credential.SECRET);

        String response = given()
                .header("Content-Type", "application/json")
                .body(ob.toString())
                .post("http://test.biz.ua/symfony/web/index.php/oauth/issueToken").getBody().asString();

        token = JsonPath.from(response).getString("access_token");

        org.junit.Assert.assertThat(response, containsStringIgnoringCase("access_token"));
    }

    @Test
    private void addEmployee() {
        String result = given().auth().oauth2(token)
                .contentType("multipart/form-data")
                .multiPart("firstName", dataFaker.getFirstName())
                .multiPart("lastName", dataFaker.getLastName())
                .multiPart("code", dataFaker.getCode())
                .when()
                .post(Path.URI + dataFaker.getCode())
                .getBody()
                .asString();

        employeeId = JsonPath.from(result).getString("id");

        Assert.assertNotNull(employeeId, "Employee was not created!");
    }

    @Test(dependsOnMethods = "addEmployee")
    public void saveEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .contentType("multipart/form-data")
                .multiPart("id", employeeId)
                .multiPart("company", dataFaker.getCompany())
                .multiPart("title", dataFaker.getTitle())
                .multiPart("fromDate", dataFaker.getFromDate())
                .multiPart("toDate", dataFaker.getToDate())
                .when()
                .post(Path.URI + employeeId + Path.WORK_EXPERIENCE)
                .getBody()
                .asString();

        seqId = JsonPath.from(result).getString("seqId");

        org.junit.Assert.assertThat(result, containsStringIgnoringCase(SUCCESS));
    }

    @Test(dependsOnMethods = "saveEmployeeWorkExperience")
    public void updateEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .contentType(ContentType.URLENC)
                .formParam("id", employeeId)
                .formParam("seqId", seqId)
                .formParam("company", new DataFaker().getCompany())
                .formParam("title", new DataFaker().getTitle())
                .formParam("fromDate", new DataFaker().getFromDate())
                .formParam("toDate", new DataFaker().getToDate())
                .when()
                .put(Path.URI + employeeId + Path.WORK_EXPERIENCE)
                .getBody()
                .asString();

        org.junit.Assert.assertThat(result, containsStringIgnoringCase(SUCCESS));
    }

    @Test(dependsOnMethods = "saveEmployeeWorkExperience")
    public void getEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .when()
                .get(Path.URI + employeeId + Path.WORK_EXPERIENCE)
                .getBody()
                .asString();

        org.junit.Assert.assertThat(result, containsStringIgnoringCase("data"));
    }

    @Test(dependsOnMethods = "updateEmployeeWorkExperience")
    public void deleteEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.URLENC)
                .formParam("id", employeeId)
                .formParam("seqId", seqId)
                .when()
                .delete(Path.URI + employeeId + Path.WORK_EXPERIENCE)
                .getBody()
                .asString();

        org.junit.Assert.assertThat(result, containsStringIgnoringCase(SUCCESS));
    }
}
