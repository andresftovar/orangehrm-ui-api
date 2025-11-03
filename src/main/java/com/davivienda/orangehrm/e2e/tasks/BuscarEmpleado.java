package com.davivienda.orangehrm.e2e.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.davivienda.orangehrm.e2e.userinterfaces.PIMUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarEmpleado implements Task {

    private final String name;

    public BuscarEmpleado(String name){
        this.name = name;
    }

    public static BuscarEmpleado conNombre(String name){
        return instrumented(BuscarEmpleado.class, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(EMPLOYEE_LIST, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(EMPLOYEE_LIST),
                Enter.theValue(name).into(EMPLOYEE_NAME_FIELD),
                Click.on(SEARCH_BUTTON),
                Click.on(EMPLOYEE_CARD)
        );
    }
}

