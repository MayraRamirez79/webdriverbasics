package com.seleniumsimplified.junit.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class XpathExercise1 {

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
        Driver.getDriver().get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");

        //Driver.getDriver()get...("ww.google.com");
    }

    // debe ir es metodo test para que corra, aunque este vacio
    @Test
    public void testById(){
        //WebElement Paragraph31 = Driver.getDriver().findElement(By.id("p31"));
        WebElement Paragraph31xp = Driver.getDriver().findElement(By.xpath("//p[@id='p31']"));
        //assertEquals("pName31", Paragraph31.getAttribute("name"));
        assertEquals("pName31", Paragraph31xp.getAttribute("name"));
        //assertEquals("This is a paragraph text", aParagraph.getText());

    }

    @Test
    public void testByTagName(){
        //WebElement justLink = Driver.getDriver().findElement(By.tagName("li"));
        WebElement justLinkXp = Driver.getDriver().findElement(By.xpath("//div/ul/li"));
        //assertEquals("liName1", justLink.getAttribute("name"));
        assertEquals("liName1", justLinkXp.getAttribute("name"));

    }


    @Test
    public void testByName(){
        //WebElement unoName = Driver.getDriver().findElement(By.name("ulName1"));
        WebElement unoNameXp = Driver.getDriver().findElement(By.xpath("//div/ul[@name='ulName1']"));
        //assertEquals("ul1", unoName.getAttribute("id"));
        assertEquals("ul1", unoNameXp.getAttribute("id"));

    }



    @Test
    public void testByClassName(){
        //WebElement divSpecial = Driver.getDriver().findElement(By.className("specialDiv"));
        WebElement divSpecialXp = Driver.getDriver().findElement(By.xpath("//div[@class='specialDiv']"));
        //assertEquals("div1", divSpecial.getAttribute("id"));
        assertEquals("div1", divSpecialXp.getAttribute("id"));

    }


    
    @AfterClass
    public static void stopDriver() {
        //driver.quit();
    }




}
