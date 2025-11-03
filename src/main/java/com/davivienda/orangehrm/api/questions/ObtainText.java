package com.davivienda.orangehrm.api.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ObtainText implements Question<String> {

    private Target target;

    public ObtainText(Target target){
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor){
        actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds());
        return Text.of(target).answeredBy(actor);
    }

    public static ObtainText element(Target target){
        return Instrumented.instanceOf(ObtainText.class).withProperties(target);
    }
}
