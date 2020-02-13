package com.seleniumsimplified.junit.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JUnitInterrogation2 {

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
        WebElement aParagraph = Driver.getDriver().findElement(By.id("a1"));
        assertEquals("a1", aParagraph.getAttribute("id"));
        //assertEquals("This is a paragraph text", aParagraph.getText());

    }

    @Test
    public void testByLinkText(){
        WebElement ceroLinkText = Driver.getDriver().findElement(By.linkText("jump to para 0"));
        assertEquals("aName26", ceroLinkText.getAttribute("name"));

    }


    @Test
    public void testByName(){
        WebElement dosName = Driver.getDriver().findElement(By.name("pName2"));
        assertEquals("p2", dosName.getAttribute("id"));

    }


    @Test
    public void testByPartialLinkText(){
        WebElement unoLinkText = Driver.getDriver().findElement(By.partialLinkText("jump to"));
        assertEquals("aName26", unoLinkText.getAttribute("name"));

    }

    @Test
    public void testByClassName(){
        WebElement aParagraphText = Driver.getDriver().findElement(By.className("normal"));
        assertEquals("This is a paragraph text", aParagraphText.getText());

    }

    @Test
    public void returnAListOfElements(){

        List<WebElement> elements;
        List<WebElement> elements2;
        List<WebElement> elements3;
        List<WebElement> elements4;

        elements = Driver.getDriver().findElements(new By.ByTagName("div"));
        elements2 = Driver.getDriver().findElements(new By.ByTagName("li"));
        elements3 = Driver.getDriver().findElements(new By.ByClassName("nestedDiv"));
        elements4 = Driver.getDriver().findElements(new By.ByTagName("p"));

        /*Set<String> foundTags = new HashSet<>();
        for (WebElement e : elements) {
            foundTags.add(e.getTagName());
        }*/
        //System.out.println("Size:" + foundTags.size());
        System.out.println("Size:" + elements.size());
        System.out.println("Size:" + elements2.size());
        System.out.println("Size:" + elements3.size());
        System.out.println("Size:" + elements4.size());

        //assertTrue("expected div tag", foundTags.contains("div"));
        //assertTrue("expected 19 divs", foundTags.size() == 18);
        assertTrue("expected 19 divs", elements.size() == 19);
        assertTrue("expected 25 a", elements2.size() == 25);
        assertTrue("expected 16 nestedDiv", elements3.size() == 16);
        assertTrue("expected 41 paras in total", elements4.size() == 41);






    }








    
    @AfterClass
    public static void stopDriver() {
        //driver.quit();
    }




}
