package com.seleniumsimplified.junit.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class AlertsExercise1 {

    // crea el elemento llamado driver que es de tipo WebDriver

    //public WebDriver driver;

    // un elemento tipo de la clase Driver
    public static Driver Driver;


    @BeforeClass
    public static void createDriverAndVisitTestPage() {
        // a este elemento se le asigna el metodo constructor Driver, que esta dentro de la clase Driver y se le
        //manda de parametro el string dentro del parentesis
        Driver= new Driver("hola");

       //con el elemento driver se hace uso del metodo getDriver que esta declarado en la clase Driver para aceder a
        // los comandos
        Driver.getDriver().get("http://compendiumdev.co.uk/selenium/alerts.html");


        //Driver.getDriver()get...("ww.google.com");
    }



    //Accept and dismiss alert
    @Test
    public void exerciseUno(){

        WebElement alertButton;

        alertButton = Driver.getDriver().findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage, Driver.getDriver().switchTo().alert().getText());

        Driver.getDriver().switchTo().alert().accept();


    }


    //Accept and dismiss confirm (check text on page changes)
    @Test
    public void exerciseDos(){

        WebElement confirmButton;
        WebElement confirmText;

        confirmButton = Driver.getDriver().findElement(By.id("confirmexample"));
        confirmText = Driver.getDriver().findElement(By.id("confirmreturn"));

        confirmButton.click();

        String confirmMessage = "I am a confirm alert";

        assertEquals(confirmMessage, Driver.getDriver().switchTo().alert().getText());

        Driver.getDriver().switchTo().alert().accept();

        assertEquals("true", confirmText.getText());

        //dismiss:

        confirmButton.click();

        Driver.getDriver().switchTo().alert().dismiss();

        assertEquals("false", confirmText.getText());

    }


    //Accept and dismiss prompt (check text on page changes)  and Change text on prompt and accept and dismiss
    @Test
    public void exerciseTresYCuatro(){

        WebElement promptButton;
        WebElement promptText;

        promptButton = Driver.getDriver().findElement(By.id("promptexample"));
        promptText = Driver.getDriver().findElement(By.id("promptreturn"));

        promptButton.click();

        String confirmMessage = "I prompt you";

        assertEquals(confirmMessage, Driver.getDriver().switchTo().alert().getText());

        Driver.getDriver().switchTo().alert().accept();

        assertEquals("change me", promptText.getText());

        //dismiss:

        promptButton.click();

        Driver.getDriver().switchTo().alert().dismiss();

        assertEquals("change me", promptText.getText());

        //Change text on prompt and accept and dismiss

            //accept

        promptButton.click();

        Driver.getDriver().switchTo().alert().sendKeys("Mayra");

        Driver.getDriver().switchTo().alert().accept();

        assertEquals("Mayra", promptText.getText());

         //dismiss

        promptButton.click();

        Driver.getDriver().switchTo().alert().dismiss();

        assertEquals("Mayra", promptText.getText());


    }




    @AfterClass
    public static void stopDriver() {
        //driver.quit();
    }




}
