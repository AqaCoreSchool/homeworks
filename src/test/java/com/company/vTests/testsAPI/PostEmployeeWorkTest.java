package com.company.vTests.testsAPI;

import com.company.vTests.base.BaseApiTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostEmployeeWorkTest extends BaseApiTest {

    @Test
    public void testPostWork(){
        given().auth().oauth2(getToken())
                .contentType("multipart/form-data")
                .multiPart("company", "CoreValue")
                .multiPart("title", "Manager")
                .multiPart("fromDate", getFromDate())
                .multiPart("toDate", "2019-12-18")
                .multiPart("comment", "Hi. Here is my experience.")
                .when()
                .post("http://test.biz.ua/symfony/web/index.php/api/v1/employee/91/work-experience")
                .then()
                .assertThat()
                .statusCode(200);

    }
}
