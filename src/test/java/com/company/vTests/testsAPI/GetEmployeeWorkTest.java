package com.company.vTests.testsAPI;

import com.company.vTests.base.BaseApiTest;
import com.company.vTests.data.Candidate;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetEmployeeWorkTest extends BaseApiTest {

    @Test
    public void testGetWork(){
        Candidate candidate = new Candidate("Olya","Bilynska","798");
        String employee = given().auth().oauth2(getToken())
                .when()
                .get("http://test.biz.ua/symfony/web/index.php/api/v1/employee/91")
                .asString();

        assertThat(employee).contains(candidate.getFirstName());

        given().auth().oauth2(getToken())
                .when()
                .get("http://test.biz.ua/symfony/web/index.php/api/v1/employee/91/work-experience")
                .then()
                .assertThat()
                .statusCode(200);
    }
}