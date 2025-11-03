package com.davivienda.orangehrm.api.tasks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateEmployeeApiTask {

    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php";

    /*@Step("Crea un nuevo empleado por API")
    public static void conDatosBasicos(String firstName, String lastName) {
        JSONObject body = new JSONObject();
        body.put("firstName", firstName);
        body.put("lastName", lastName);

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(body.toString())
                .when()
                .post(BASE_URL + "/api/v2/pim/employees")
                .then()
                .log().ifValidationFails();
    }*/

    public static Response login(String username, String password) {
        RestAssured.baseURI = BASE_URL;
        Response response = given()
                .relaxedHTTPSValidation()
                .formParam("username", username)
                .formParam("password", password)
                .post("/auth/validate")
                .then()
                .extract().response();

        if (response.getStatusCode() == 302) {
            String sessionId = response.getCookie("PHPSESSID");
            Serenity.setSessionVariable("PHPSESSID").to(sessionId);
        }

        return response;
    }

    public static Response createEmployee(String firstName, String lastName) {
        RestAssured.baseURI = BASE_URL;
        String sessionId = Serenity.sessionVariableCalled("PHPSESSID");

        String body = "{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\" }";

        return given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .header("Cookie", "PHPSESSID=" + sessionId)
                .body(body)
                .post("/api/v2/pim/employees")
                .then()
                .extract().response();
    }
}
