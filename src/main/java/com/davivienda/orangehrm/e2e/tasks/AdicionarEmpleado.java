package com.davivienda.orangehrm.e2e.tasks;

import com.davivienda.orangehrm.e2e.userinterfaces.PIMUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;

import static com.davivienda.orangehrm.e2e.userinterfaces.PIMUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AdicionarEmpleado implements Task {

    private final String firstName;
    private final String lastName;

    public AdicionarEmpleado(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static AdicionarEmpleado conDatos(String firstName, String lastName){
        return instrumented(AdicionarEmpleado.class, firstName, lastName);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(PIM_MENU, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(PIM_MENU),
                WaitUntil.the(ADD_EMPLOYEE_BUTTON, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(ADD_EMPLOYEE_BUTTON),
                WaitUntil.the(FIRST_NAME_FIELD, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(firstName).into(FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(LAST_NAME_FIELD),
                Click.on(SAVE_BUTTON)
        );
    }
}

