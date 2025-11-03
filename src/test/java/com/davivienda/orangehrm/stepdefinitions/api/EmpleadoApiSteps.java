package com.davivienda.orangehrm.stepdefinitions.api;

import io.cucumber.java.en.*;
import com.davivienda.orangehrm.api.tasks.CreateEmployeeApiTask;
import com.davivienda.orangehrm.api.questions.Respuesta;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;

public class EmpleadoApiSteps {

    private Response response;


    @Given("que el administrador accede a la API de OrangeHRM")
    public void queElAdministradorAccedeALaAPIDeOrangeHRM() {
        System.out.println("Conectando a OrangeHRM API...");
    }

    @When("realiza el login con credenciales válidas")
    public void realizaElLoginConCredencialesValidas() {
        response = CreateEmployeeApiTask.login("Admin", "admin123");
    }

    @Then("la respuesta debe tener el código de estado {int}")
    public void laRespuestaDebeTenerElCodigoDeEstado(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }

    @And("se debe guardar el token de sesión")
    public void seDebeGuardarElTokenDeSesion() {
        String cookie = Serenity.sessionVariableCalled("PHPSESSID");
        Assert.assertNotNull(cookie);
    }

    @Given("que el administrador está autenticado en la API")
    public void que_el_administrador_esta_autenticado_en_la_api() {
        CreateEmployeeApiTask.login("Admin", "admin123");
    }

    @When("crea un nuevo empleado con datos válidos")
    public void crea_un_nuevo_empleado_con_datos_validos() {
        response = CreateEmployeeApiTask.createEmployee("Carlos", "Test");
    }

    @And("el nombre del empleado debe coincidir")
    public void el_nombre_del_empleado_debe_coincidir() {
        String firstName = response.jsonPath().getString("data.firstName");
        Assert.assertEquals("Carlos", firstName);
    }
}
