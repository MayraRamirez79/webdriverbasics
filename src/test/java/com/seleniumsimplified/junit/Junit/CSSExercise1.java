package com.seleniumsimplified.junit.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CSSExercise1 {

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
        WebElement Paragraph31CSS = Driver.getDriver().findElement(By.cssSelector("#p31"));
        //assertEquals("pName31", Paragraph31.getAttribute("name"));
        assertEquals("pName31", Paragraph31CSS.getAttribute("name"));
        //assertEquals("This is a paragraph text", aParagraph.getText());

    }

    @Test
    public void testByTagName(){
       // WebElement justLink = Driver.getDriver().findElement(By.tagName("li"));
        WebElement justLinkCSS = Driver.getDriver().findElement(By.cssSelector("li"));
        //assertEquals("liName1", justLink.getAttribute("name"));
        assertEquals("liName1", justLinkCSS.getAttribute("name"));

    }


    @Test
    public void testByName(){
        //WebElement unoName = Driver.getDriver().findElement(By.name("ulName1"));
        WebElement unoNameCSS = Driver.getDriver().findElement(By.cssSelector("[name=ulName1]"));
        //assertEquals("ul1", unoName.getAttribute("id"));
        assertEquals("ul1", unoNameCSS.getAttribute("id"));

    }



    @Test
    public void testByClassName(){
        //WebElement divSpecial = Driver.getDriver().findElement(By.className("specialDiv"));
        WebElement divSpecialCSS = Driver.getDriver().findElement(By.cssSelector(".specialDiv"));
        //assertEquals("div1", divSpecial.getAttribute("id"));
        assertEquals("div1", divSpecialCSS.getAttribute("id"));

    }

    //@Test
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
