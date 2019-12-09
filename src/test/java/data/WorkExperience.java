package data;

import io.restassured.response.Response;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static testsapi.BaseApiTest.getToken;

public class WorkExperience {

    public Response saveEmployeeExperience(){
        return given().auth().oauth2(getToken())
                .contentType("multipart/form-data")
                .multiPart("id", 29)
                .multiPart("company", "SpaceX")
                .multiPart("title", "space engineer")
                .multiPart("fromDate", LocalDate.now().minusYears(5).toString())
                .multiPart("toDate", LocalDate.now().minusYears(2).toString())
                .multiPart("comment", "it's a joke")
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
                .contentType("multipart/form-data")
                .multiPart("id", id)
                .multiPart("seqId", seqId)
                .multiPart("company", "SpaceX")
                .multiPart("title", "space engineer")
                .multiPart("fromDate", LocalDate.now().minusYears(5).toString())
                .multiPart("toDate", LocalDate.now().minusYears(2).toString())
                .multiPart("comment", "it's a joke")
                .when()
                .put("/api/v1/employee/29/work-experience");
    }

    public Response deleteEmployeeExperience(int id, int seqId){
        return given().auth().oauth2(getToken())
                .contentType("multipart/form-data")
                .multiPart("id", id)
                .multiPart("seqId", seqId)
                .when()
                .delete("/api/v1/employee/29/work-experience");
    }
}
