package com.davivienda.orangehrm.stepdefinitions.e2e;

import com.davivienda.orangehrm.api.questions.ObtainText;
import com.davivienda.orangehrm.e2e.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.davivienda.orangehrm.e2e.userinterfaces.PIMUI.EMPLOYEE_NAME_TITLE;
import static com.davivienda.orangehrm.utils.Constants.EMPLOYEE_NAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class AdicionarEmpleadoSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("el administrador inicia sesión en OrangeHRM")
    public void adminLogin() {
        OnStage.theActorCalled("Admin").attemptsTo(AbrirLaPagina.enElNavegador(),
                Login.conCredenciales("Admin", "admin123")
        );
    }

    @Cuando("agrega un nuevo empleado con nombre {string} y apellido {string}")
    public void addEmployee(String firstName, String lastName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AdicionarEmpleado.conDatos(firstName, lastName)
        );
    }

    @Y("sube una foto de perfil para el empleado")
    public void uploadPhoto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SubirFoto.desde("src/test/resources/img/imagen_perfil.jpg")
        );
    }

    @And("busca el empleado {string} en el módulo de Directorio")
    public void buscaElEmpleadoEnElModuloDeDirectorio(String name) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarEmpleado.conNombre(name));
    }

    @Then("valida que la información del empleado se haya guardado correctamente")
    public void validaQueLaInformacionDelEmpleadoSeHayaGuardadoCorrectamente() {
        OnStage.theActorInTheSpotlight().should(seeThat(ObtainText.element(EMPLOYEE_NAME_TITLE), containsString(EMPLOYEE_NAME)));
    }
}
