package com.davivienda.orangehrm.e2e.tasks;

import com.davivienda.orangehrm.e2e.userinterfaces.PIMUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.davivienda.orangehrm.e2e.userinterfaces.PIMUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.nio.file.Paths;

public class SubirFoto implements Task {

    private final String photoPath;

    public SubirFoto(String photoPath){
        this.photoPath = photoPath;
    }

    public static SubirFoto desde(String photoPath){
        return instrumented(SubirFoto.class, photoPath);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(SAVE_BUTTON, isVisible()).forNoMoreThan(30).seconds(),
                Upload.theFile(Paths.get(photoPath)).to(PHOTO_UPLOAD_FIELD),
                Click.on(SAVE_BUTTON)
        );
    }
}

