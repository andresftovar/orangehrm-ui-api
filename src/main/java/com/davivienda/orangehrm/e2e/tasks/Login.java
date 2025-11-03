package com.davivienda.orangehrm.e2e.tasks;

import com.davivienda.orangehrm.e2e.userinterfaces.LoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;

import static com.davivienda.orangehrm.e2e.userinterfaces.LoginUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public static Login conCredenciales(String username, String password){
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(USERNAME_FIELD, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(USERNAME_FIELD).afterWaitingUntilPresent(),
                Enter.theValue(username).into(USERNAME_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON).afterWaitingUntilEnabled()
        );
    }
}

