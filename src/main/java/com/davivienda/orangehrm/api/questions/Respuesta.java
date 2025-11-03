package com.davivienda.orangehrm.api.questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.*;

public class Respuesta {

    @Step("Validar estructura de respuesta del empleado")
    public static void shouldHaveBasicFields() {
        SerenityRest.then()
                .statusCode(anyOf(is(200), is(201)))
                .body("data.firstName", notNullValue())
                .body("data.lastName", notNullValue());
    }
}
