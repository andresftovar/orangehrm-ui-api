package com.davivienda.orangehrm.e2e.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PIMUI {
    public static final Target PIM_MENU = Target.the("Menú PIM").located(By.xpath("//span[text()='PIM']"));
    public static final Target ADD_EMPLOYEE_BUTTON = Target.the("Botón para agregar empleado").located(By.xpath("//a[text()='Add Employee']"));
    public static final Target FIRST_NAME_FIELD = Target.the("Campo nombre").locatedBy("//*[@name='firstName']");
    public static final Target LAST_NAME_FIELD = Target.the("Campo apellido").located(By.name("lastName"));
    public static final Target SAVE_BUTTON = Target.the("Botón guardar").located(By.xpath("//button[@type='submit']"));
    public static final Target PHOTO_UPLOAD_FIELD = Target.the("Campo de carga de foto").located(By.xpath("//input[@type='file']"));
    public static final Target EMPLOYEE_LIST = Target.the("Lista de empleados").located(By.xpath("//a[normalize-space(text())='Employee List']"));
    public static final Target EMPLOYEE_NAME_FIELD = Target.the("Campo de búsqueda empleado").located(By.xpath("//div[1]/div/div[2]/div/div/input[@placeholder='Type for hints...']"));
    public static final Target SEARCH_BUTTON = Target.the("Botón de búsqueda empleado").located(By.xpath("//form/div[2]/button[2]"));
    public static final Target EMPLOYEE_CARD = Target.the("Card de empleado encontrado").located(By.cssSelector("div.oxd-table-body > div:nth-child(1)"));
    public static final Target EMPLOYEE_NAME_TITLE = Target.the("Título de empleado encontrado").located(By.cssSelector("div.orangehrm-edit-employee-name"));
}

