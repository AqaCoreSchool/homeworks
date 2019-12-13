package orangetest.apitask.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import orangetest.apitask.utils.Token;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class EmployeeWorkExperienceApi {
    private final String BASE_URL = "http://test.biz.ua/symfony/web/index.php/api/v1/employee/";
    private final String BASE_PATH = "32/work-experience";
    Token token = new Token();
    Faker faker = new Faker();

    public RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH)
                .setAuth(oauth2(token.getToken()))
                .build();
    }

    public Response getEmployeeExperience() {
        Response response = RestAssured.given().spec(getSpec()).when().get();
        System.out.println(response.getBody().asString());
        return response;
    }


    public Response saveEmployeeExperience() {
        Response response = given().spec(getSpec())
                .contentType("multipart/form-data")
                .multiPart("company", "OOps company")
                .multiPart("title", "AQA Junior")
                .multiPart("job", "Junior")
                .multiPart("fromDate", "2019-01-01")
                .multiPart("toDate", "2020-01-03")
                .multiPart("comment", "Good job")
                .when()
                .post();
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
        return response;
    }

    public Response updateEmployeeExperience() {
        String company = faker.words(2).stream().collect(Collectors.joining(" "));
        Response response = given().spec(getSpec())
                .formParam("company", company)
                .formParam("title", "AQA Junior")
                .formParam("job", "Junior")
                .formParam("fromDate", "2019-01-01")
                .formParam("toDate", "2020-01-03")
                .formParam("comment", "Good job")
                .formParam("seqId", "1")
                .when()
                .put();
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        return response;
    }

    public Response deleteEmployeeExperience() {
        Response response = given().spec(getSpec())
                .contentType(ContentType.URLENC)
                .formParam("id", 5)
                .formParam("seqId", 1)
                .when()
                .delete();
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        return response;
    }

    public void VerifyJsonResponse() {
        Response response = RestAssured.given().spec(getSpec()).get("32/work-experience");
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        JSONArray jsonArrayOfRecords =jsonResponse.getJSONArray("data");
        String title = jsonArrayOfRecords.getJSONObject(0).getString("jobTitle");
        System.out.println(title);
        Assert.assertEquals(title, "Job Title");
    }
}
