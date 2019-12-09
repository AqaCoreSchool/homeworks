package com.company.vTests.testsAPI;

import com.company.vTests.base.BaseApiTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteEmployeeWorkTest extends BaseApiTest {

    @Test
    public void testDeleteWork(){
        given().auth().oauth2(getToken())
                .contentType("application/x-www-form-urlencoded")
                .formParam("seqId", 1)
                .when()
                .delete("http://test.biz.ua/symfony/web/index.php/api/v1/employee/91/work-experience")
                .then()
                .assertThat()
                .statusCode(200);


        given().auth().oauth2(getToken())
                .when()
                .get("http://test.biz.ua/symfony/web/index.php/api/v1/employee/91/work-experience")
                .then()
                .assertThat()
                .statusCode(404);

    }
}
