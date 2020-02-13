package com.seleniumsimplified.junit.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;


public class UserInteractionsExercise1 {

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
        Driver.getDriver().get("http://compendiumdev.co.uk/selenium/gui_user_interactions.html");


        //Driver.getDriver()get...("ww.google.com");
    }

    //DONDE DEBE DE IR ESTO?
    //public WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));






    //Move draggable1 on to droppable1
    @Test
    public void exerciseUno(){

        WebElement dragMe1 = Driver.getDriver().findElement(By.cssSelector("div[id='draggable1']"));
        WebElement dropHere1 = Driver.getDriver().findElement(By.cssSelector("div[id='droppable1']"));
        WebElement dropHere1Txt = dropHere1.findElement(By.cssSelector("p"));

        new Actions(Driver.getDriver()).dragAndDrop(dragMe1,dropHere1).release().perform();

        //System.out.print(dropHere1Txt);

        assertEquals("Dropped!",dropHere1Txt.getText());



    }

    //Drag and Drop draggable2 to droppable1
    @Test
    public void exerciseDos(){




        WebElement dragMe2 = Driver.getDriver().findElement(By.cssSelector("div[id='draggable2']"));
        WebElement dropHere1 = Driver.getDriver().findElement(By.cssSelector("div[id='droppable1']"));
        WebElement dropHere1Txt = dropHere1.findElement(By.cssSelector("p"));

        new Actions(Driver.getDriver()).dragAndDrop(dragMe2,dropHere1).release().perform();

        //System.out.print(dropHere1Txt);

        assertEquals("Get Off Me!",dropHere1Txt.getText());



    }

    //Press control+B and assert for text change on draggable1 to “Bwa! Ha! Ha!”
    // sin el keysup del control marca error
    @Test
    public void exerciseTres(){



        WebElement dragMe1 = Driver.getDriver().findElement(By.cssSelector("div[id='draggable1']"));
        //WebElement dragMe1Txt = dragMe1.findElement(By.cssSelector("p"));

        Actions actions = new Actions(Driver.getDriver());

        new Actions(Driver.getDriver()).keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).perform();



        assertEquals("Bwa! Ha! Ha!",dragMe1.getText());

    }

    // Control+Space and red squares say “Let GO!!”
    @Test
    public void exerciseCuatro(){

        WebElement droppable1 = Driver.getDriver().findElement(By.id("droppable1"));

        Actions actions = new Actions(Driver.getDriver());
        actions.click(droppable1).build().perform();
        //sendkeys does a keydown followed by keyup, so you can't use it for this as keys need to be
        //held down
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).build().perform();
        String dropText =  droppable1.getText();
        actions.keyUp(droppable1,Keys.CONTROL).build().perform();

        try{
            assertEquals("Let GO!!", dropText );
            fail("send keys should not be held down long enough to get the text");
        } catch (ComparisonFailure e){
                    assertTrue("How can we hold down the keys?", true);
                    assertEquals("Drop Here", dropText );
             }
    }



    // draw something in the canvas
    @Test
    public void exerciseCinco(){

        WebElement canvas = Driver.getDriver().findElement(By.id("canvas"));
        WebElement eventList = Driver.getDriver().findElement(By.id("keyeventslist"));

        int eventCount = eventList.findElements(By.tagName("li")).size();

        new Actions(Driver.getDriver()).
                //click does not do it, need to click and hold
                clickAndHold(canvas).
                moveByOffset(10,10).
                        release().
                        perform();
        assertTrue("we should have had some draw events", eventCount < eventList.findElements(By.tagName("li")).size());
    }



    @AfterClass
    public static void stopDriver() {
        //driver.quit();
    }




}
