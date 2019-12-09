package com.company.vTests.testsAPI;

import com.company.vTests.base.BaseApiTest;
import com.company.vTests.data.Candidate;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostEmployeeTest extends BaseApiTest {

    @Test
    public void testPostEmployee(){
        Candidate candidate = new Candidate("Olya","Bilynska","798");
        given().auth().oauth2(getToken())
                .contentType("multipart/form-data")
                .multiPart("firstName", candidate.getFirstName())
                .multiPart("lastName", candidate.getLastName())
                .multiPart("code", candidate.getContactNo())
                .when()
                .post("http://test.biz.ua/symfony/web/index.php/api/v1/employee/798")
                .then()
                .assertThat()
                .statusCode(200);

    }
}
