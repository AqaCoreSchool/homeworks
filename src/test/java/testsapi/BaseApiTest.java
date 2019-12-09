package testsapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    @BeforeMethod
    public static String getToken() {
        RestAssured.baseURI = "http://test.biz.ua/symfony/web/index.php";
        JSONObject ob = new JSONObject();
        ob.put("grant_type", "client_credentials");
        ob.put("client_id", "myadmin");
        ob.put("client_secret", "kt]p]$BF6K`2wLWT");

        String response = given()
                .header("Content-Type", "application/json")
                .body(ob)
                .post("/oauth/issueToken").getBody().asString();
        return JsonPath.from(response).getString("access_token");
    }


}

