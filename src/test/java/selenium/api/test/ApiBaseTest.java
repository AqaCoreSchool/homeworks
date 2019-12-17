package selenium.api.test;

import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class ApiBaseTest {
    public String token;

    @BeforeClass
    public void tokenSetup() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("grant_type", "client_credentials");
        jsonObject.addProperty("client_id", "myadmin");
        jsonObject.addProperty("client_secret", "kt]p]$BF6K`2wLWT");;

        String response = given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .post("http://test.biz.ua/symfony/web/index.php/oauth/issueToken").getBody().asString();

        token = JsonPath.from(response).getString("access_token");
    }
}
