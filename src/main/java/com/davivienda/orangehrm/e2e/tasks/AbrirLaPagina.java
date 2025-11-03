package com.davivienda.orangehrm.e2e.tasks;

import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirLaPagina implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String baseUrl = ConfiguredEnvironment.getConfiguration().getBaseUrl();
        actor.attemptsTo(Open.url(baseUrl));
    }

    public static AbrirLaPagina enElNavegador(){
        return new AbrirLaPagina();
    }
}