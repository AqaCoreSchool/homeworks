package data;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static testsapi.BaseApiTest.getToken;

public class WorkExperience {

    public Response saveEmployeeExperience(){
        return given().auth().oauth2(getToken())
                .contentType(ContentType.URLENC)
                .formParam("id", 29)
                .formParam("company", "SpaceX")
                .formParam("title", "space engineer")
                .formParam("fromDate", LocalDate.now().minusYears(5).toString())
                .formParam("toDate", LocalDate.now().minusYears(2).toString())
                .formParam("comment", "it's a joke")
                .when()
                .post("/api/v1/employee/29/work-experience");
    }

    public Response getEmployeeExperience(){
        return given().auth().oauth2(getToken())
                .when()
                .get("/api/v1/employee/29/work-experience");
    }

    public Response updateEmployeeExperience(int id, int seqId){
        return given().auth().oauth2(getToken())
                .contentType(ContentType.URLENC)
                .formParam("id", id)
                .formParam("seqId", seqId)
                .formParam("company", "SpaceX")
                .formParam("title", "space engineer")
                .formParam("fromDate", LocalDate.now().minusYears(20).toString())
                .formParam("toDate", LocalDate.now().minusYears(10).toString())
                .formParam("comment", "it's a joke")
                .when()
                .put("/api/v1/employee/29/work-experience");
    }

    public Response deleteEmployeeExperience(int id, int seqId){
        return given().auth().oauth2(getToken())
                .contentType(ContentType.URLENC)
                .formParam("id", id)
                .formParam("seqId", seqId)
                .when()
                .delete("/api/v1/employee/29/work-experience");
    }
}
