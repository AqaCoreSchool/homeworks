package ua.biz.test.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

/**
 * Testing class
 *
 * @author Andrew
 * @version 1.0
 */
public class Api {
    private static String token;

    public void init() {
        JSONObject ob = new JSONObject();
        ob.put("grant_type", "client_credentials");
        ob.put("client_id", "myadmin");
        ob.put("client_secret", "kt]p]$BF6K`2wLWT");

        String response = given()
                .header("Content-Type", "application/json")
                .body(ob.toString())
                .post("http://test.biz.ua/symfony/web/index.php/oauth/issueToken").getBody().asString();

        token = JsonPath.from(response).getString("access_token");

        System.out.println(response);
    }

    public void addEmployee() {
        String result = given().auth().oauth2(token)
                .contentType("multipart/form-data")
                .multiPart("firstName", "Big Shaq")
                .multiPart("lastName", "Mans not hot")
                .multiPart("code", "228")
                .when()
                .post("http://test.biz.ua/symfony/web/index.php/api/v1/employee/228")
                .getBody()
                .asString();

        System.out.println(result);
    }

    public void getEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .when()
                .get("http://test.biz.ua/symfony/web/index.php/api/v1/employee/81/work-experience")
                .getBody()
                .asString();

        System.out.println(result);
    }

    public void saveEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .contentType("multipart/form-data")
                .multiPart("id", "81")
                .multiPart("company", "Amazon")
                .multiPart("title", "QA")
                .multiPart("fromDate", "2018-12-03")
                .multiPart("toDate", "2019-12-14")
                .multiPart("comment", "1 year")
                .when()
                .post("http://test.biz.ua/symfony/web/index.php/api/v1/employee/81/work-experience")
                .getBody()
                .asString();

        System.out.println(result);
    }

    public void updateEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .contentType("multipart/form-data")
                .multiPart("id", "81")
                .multiPart("seqId", "3")
                .multiPart("company", "Faceasdasdbook Inc.")
                .multiPart("title", "QA")
                .multiPart("fromDate", "2011-12-03")
                .multiPart("toDate", "2012-12-14")
                .multiPart("comment", "1 year")
                .when()
                .put("http://test.biz.ua/symfony/web/index.php/api/v1/employee/81/work-experience")
                .getBody()
                .asString();

        System.out.println(result);
    }

    public void deleteEmployeeWorkExperience() {
        String result = given().auth().oauth2(token)
                .contentType("multipart/form-data")
                .multiPart("id", "81")
                .multiPart("seqId", 3)
                .when()
                .delete("http://test.biz.ua/symfony/web/index.php/api/v1/employee/81/work-experience")
                .getBody()
                .asString();

        System.out.println(result);
    }

    protected void delEmployeeWorkExperience() {
        String resp = given().auth().oauth2(token)
                .contentType(ContentType.URLENC)
                .formParam("id", "81")
                .formParam("seqId", 1)
                .when()
                .delete("http://test.biz.ua/symfony/web/index.php/api/v1/employee/81/work-experience")
                .asString();

        System.out.println(resp);
    }
}
