package com.davivienda.orangehrm.e2e.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static final Target USERNAME_FIELD = Target.the("Campo de usuario").locatedBy("//*[@name='username']");
    public static final Target PASSWORD_FIELD = Target.the("Campo de contraseña").located(By.name("password"));
    public static final Target LOGIN_BUTTON = Target.the("Botón de login").located(By.xpath("//button[@type='submit']"));
}
