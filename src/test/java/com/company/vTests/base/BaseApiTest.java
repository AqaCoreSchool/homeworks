package com.company.vTests.base;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    @BeforeClass
    public static String getToken(){
        JSONObject login = new JSONObject();
        login.put("grant_type", "client_credentials");
        login.put("client_id", "myadmin");
        login.put("client_secret","kt]p]$BF6K`2wLWT");

        String response = given()
                .header("Content-Type", "application/json")
                .body((login.toString()))
                .post("http://test.biz.ua/symfony/web/index.php/oauth/issueToken")
                .getBody()
                .asString();

        String token = JsonPath.from(response).getString("access_token");
        return token;
    }


}
