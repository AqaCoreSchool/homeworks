package com.company.vTests.testsAPI;

import com.company.vTests.base.BaseApiTest;
import com.company.vTests.data.Candidate;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PutEmployeeWorkTest extends BaseApiTest {

    @Test
    public void testPutWork(){
        Candidate candidate = new Candidate("Olya","Bilynska","798");
        given().auth().oauth2(getToken())
                .contentType("application/x-www-form-urlencoded")
                .formParam("seqId", 1)
                .formParam("company","JavaCore")
                .formParam("title", "Senior Dev")
                .formParam("fromDate", candidate.getFromDate())
                .formParam("toDate", candidate.getToDate())
                .formParam("comment","Updated Comment.")
                .urlEncodingEnabled(false)
                .when()
                .put("http://test.biz.ua/symfony/web/index.php/api/v1/employee/91/work-experience")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
