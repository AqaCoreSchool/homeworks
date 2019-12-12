package orangetest.apitask.utils;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class Token {
    public String token = null;

    public Token() {

    }

    public String getToken() {
            JSONObject ob = new JSONObject();
            ob.put("grant_type", "client_credentials");
            ob.put("client_id", "myadmin");
            ob.put("client_secret", "kt]p]$BF6K`2wLWT");
            String response = given()
                    .header("Content-Type", "application/json")
                    .body(ob)
                    .post("http://test.biz.ua/symfony/web/index.php/oauth/issueToken").getBody().asString();

            token = JsonPath.from(response).getString("access_token");
            System.out.println(token);
            return token;
    }
}
