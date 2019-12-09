package apitask.data;

import apitask.utils.Token;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class EmployeeWorkExperienceApi {
    private final String baseUrl = "http://test.biz.ua/symfony/web/index.php/api/v1/employee/";
    Token token = new Token();
    Faker faker = new Faker();

    public Response getEmployeeExperience() {
        RestAssured.baseURI = baseUrl;
        Response response = RestAssured.given().auth().oauth2(token.getToken()).get("5/work-experience");
        System.out.println(response.getBody().asString());
        return response;
    }


    public Response saveEmployeeExperience() {
        RestAssured.baseURI = baseUrl;
        Response response = given().given().auth().oauth2(token.getToken())
                .contentType("multipart/form-data")
                .multiPart("company", "OOps company")
                .multiPart("title", "AQA Junior")
                .multiPart("job", "Junior")
                .multiPart("fromDate", "2019-01-01")
                .multiPart("toDate", "2020-01-03")
                .multiPart("comment", "Good job")
                .when()
                .post("5/work-experience");
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
        return response;
    }

    public Response updateEmployeeExperience() {
        RestAssured.baseURI = baseUrl;
        String company = faker.words(2).stream().collect(Collectors.joining(" "));
        Response response = given().auth().oauth2(token.getToken())
                .formParam("company", company)
                .formParam("title", "AQA Junior")
                .formParam("job", "Junior")
                .formParam("fromDate", "2019-01-01")
                .formParam("toDate", "2020-01-03")
                .formParam("comment", "Good job")
                .formParam("seqId", "1")
                .when()
                .put("5/work-experience");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        return response;
    }

    public Response deleteEmployeeExperience() {
        RestAssured.baseURI = baseUrl;
        Response response = given().auth().oauth2(token.getToken())
                .contentType(ContentType.URLENC)
                .formParam("id", 5)
                .formParam("seqId", 1)
                .when()
                .delete("5/work-experience");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        return response;
    }

    public void VerifyJsonResponse() {
        RestAssured.baseURI = baseUrl;
        Response response = RestAssured.given().auth().oauth2(token.getToken()).get("5/work-experience");
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        JSONArray jsonArrayOfRecords =jsonResponse.getJSONArray("data");
        String title = jsonArrayOfRecords.getJSONObject(0).getString("jobTitle");
        System.out.println(title);
        Assert.assertEquals(title, "Job Title");
    }
}
