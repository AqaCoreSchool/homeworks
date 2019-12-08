package apitest;

import com.google.gson.JsonObject;
import data.WorkExperienceData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    public static final String USER_ID = "33";
    public String token;
    public String seqId = "1";
    public String uri = "http://test.biz.ua/symfony/web/index.php";
    public String path = "/api/v1/employee/{id}/work-experience";


    @BeforeClass
    public void getToken(){
        JsonObject ob = new JsonObject();
        ob.addProperty("grant_type", "client_credentials");
        ob.addProperty("client_id", "myadmin");
        ob.addProperty("client_secret", "kt]p]$BF6K`2wLWT");

        String response = RestAssured.given().header("Content-Type", "application/json")
                .body(ob.toString())
                .post("http://test.biz.ua/symfony/web/index.php/oauth/issueToken")
                .getBody().asString();

        token = JsonPath.from(response).getString("access_token");
    }
}
