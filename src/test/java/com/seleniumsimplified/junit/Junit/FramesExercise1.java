package com.seleniumsimplified.junit.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class FramesExercise1 {

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
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/frames/frames-test.html");


        //Driver.getDriver()get...("ww.google.com");
    }



    //switch to the middle frame by number (2) and assert on something in the list, ej: find "Middle List Item 1"
    @Test
    public void exerciseUno(){

        assertEquals("Nested Frames Example", Driver.getDriver().getTitle());

        Driver.getDriver().switchTo().frame(2);

        WebElement secondListItem = Driver.getDriver().findElement(By.id("middle1"));

        assertEquals("Middle List Item 1", secondListItem.getText());



    }


    //switch to the "left" frame by name and find and assert on something in the list, ej: "Left List Item 2"
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


    //switch to the right frame by WebElement and find  and assert on something in the list, ej: "Right List Item 5"
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

    //switch to a frame, assert you are in the frame, and switch to the main page using defaultContent()

    //switch to a frame, assert you are in the frame, and switch to the main page using parentFrame()




    @AfterClass
    public static void stopDriver() {
        //driver.quit();
    }




}
