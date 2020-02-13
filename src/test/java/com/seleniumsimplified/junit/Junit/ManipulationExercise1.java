package com.seleniumsimplified.junit.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class ManipulationExercise1 {

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
        Driver.getDriver().get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");


        //Driver.getDriver()get...("ww.google.com");
    }

    //DONDE DEBE DE IR ESTO?
    //public WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));



    // debe ir es metodo test para que corra, aunque este vacio
    //test para probar el webdriver wait
    //@Test
    public void exampleUsingExpectedConditions(){

        new WebDriverWait(Driver.getDriver(),10).until(ExpectedConditions.titleIs("HTML Form Elements"));
        assertEquals("HTML Form Elements", Driver.getDriver().getTitle());

    }


    //submit form and assert page title changes
    @Test
    public void exercise1(){

        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();
        assertEquals("Processed Form Details", Driver.getDriver().getTitle());

    }

    //clear,then type comments, submit form and check output
    // como hacer que submitButton se pueda usar en todos los tests?
    @Test
    public void exercise2(){

        Driver.getDriver().navigate().back();
        WebElement textAreaComment = Driver.getDriver().findElement(By.cssSelector("textarea[name='comments']"));
        textAreaComment.clear();
        textAreaComment.sendKeys("Mis primeros comentarios");
        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();
        WebElement comments = Driver.getDriver().findElement(By.cssSelector("li[id='_valuecomments']"));
        assertEquals("Mis primeros comentarios",comments.getText());

    }


    //submit form with radio 2 selected
    @Test
    public void exercise3(){
        Driver.getDriver().navigate().back();
        WebElement textAreaComment = Driver.getDriver().findElement(By.cssSelector("textarea[name='comments']"));
        textAreaComment.clear();
        WebElement checkBox3 = Driver.getDriver().findElement(By.cssSelector("input[value='cb3']"));
        checkBox3.click();
        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();
        WebElement radio2 = Driver.getDriver().findElement(By.cssSelector("li[id='_valueradioval']"));
        assertEquals("rd2",radio2.getText());

    }


    //submit form with only checkbox 1 selected
    @Test
    public void exercise4(){
        Driver.getDriver().navigate().back();
        WebElement checkBox1 = Driver.getDriver().findElement(By.cssSelector("input[value='cb1']"));
        checkBox1.click();
        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();
        WebElement checkBox = Driver.getDriver().findElement(By.cssSelector("li[id='_valuecheckboxes0']"));
        assertEquals("cb1",checkBox.getText());

    }

    //submit form with drop down item 5 selected
    @Test
    public void exercise5(){
        Driver.getDriver().navigate().back();
        WebElement dropDown5 = Driver.getDriver().findElement(By.cssSelector("option[value='dd5']"));
        dropDown5.click();
        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();
        WebElement dropDown = Driver.getDriver().findElement(By.cssSelector("li[id='_valuedropdown']"));
        assertEquals("dd5",dropDown.getText());

    }


    //submit form with multiple select 1,2,y 3
    @Test
    public void exercise6(){
        Driver.getDriver().navigate().back();
        WebElement multiple1 = Driver.getDriver().findElement(By.cssSelector("option[value='ms1']"));
        multiple1.click();
        WebElement multiple2 = Driver.getDriver().findElement(By.cssSelector("option[value='ms2']"));
        multiple2.click();
        WebElement multiple3 = Driver.getDriver().findElement(By.cssSelector("option[value='ms3']"));
        multiple3.click();
        WebElement multiple4 = Driver.getDriver().findElement(By.cssSelector("option[value='ms4']"));
        multiple4.click();


        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();
        WebElement multipleSelect1 = Driver.getDriver().findElement(By.cssSelector("li[id='_valuemultipleselect0']"));
        assertEquals("ms1",multipleSelect1.getText());
        WebElement multipleSelect2 = Driver.getDriver().findElement(By.cssSelector("li[id='_valuemultipleselect1']"));
        assertEquals("ms2",multipleSelect2.getText());
        WebElement multipleSelect3 = Driver.getDriver().findElement(By.cssSelector("li[id='_valuemultipleselect2']"));
        assertEquals("ms3",multipleSelect3.getText());



    }


    //submit with a file and check name on output
    @Test
    public void exercise7(){
        Driver.getDriver().navigate().back();
        WebElement fileN = Driver.getDriver().findElement(By.cssSelector("input[name='filename']"));
        //fileN.click();
        fileN.sendKeys("/Users/mayraramirezduarte/Desktop/Screen Shot 2020-01-08 at 09.35.58.png");

        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();

        WebElement fileName = Driver.getDriver().findElement(By.cssSelector("li[id='_valuefilename']"));
        assertEquals("Screen Shot 2020-01-08 at 09.35.58.png",fileName.getText());

    }

    //tratar de dar clear a un checkbox
    @Test
    public void canIClickACheckbox(){

        Driver.getDriver().navigate().back();
        WebElement checkBox3 = Driver.getDriver().findElement(By.cssSelector("input[value='cb3']"));

        try{
            checkBox3.clear();
           //fail("Expected an exception as you can not clear a checkbox");
        }catch (WebDriverException e){
            //Expected an exception as you can not clear a multi select
            // you have to click to remove check

        }

    }

    //submit form with multiple select 1,2,y 3 USING THE SELECT SUPPORT CLASS
    @Test
    public void exercise8(){

        Driver.getDriver().navigate().back();
        WebElement multipleSelectElement;
        multipleSelectElement = Driver.getDriver().findElement(By.cssSelector("select[multiple='multiple']"));
        Select multipleSelect = new Select(multipleSelectElement);
        multipleSelect.selectByIndex(0);
        multipleSelect.selectByIndex(1);
        multipleSelect.selectByIndex(2);
        multipleSelect.deselectByIndex(3);

        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[value='submit']"));
        submitButton.click();
        WebElement multipleSelect1 = Driver.getDriver().findElement(By.cssSelector("li[id='_valuemultipleselect0']"));
        assertEquals("ms1",multipleSelect1.getText());
        WebElement multipleSelect2 = Driver.getDriver().findElement(By.cssSelector("li[id='_valuemultipleselect1']"));
        assertEquals("ms2",multipleSelect2.getText());
        WebElement multipleSelect3 = Driver.getDriver().findElement(By.cssSelector("li[id='_valuemultipleselect2']"));
        assertEquals("ms3",multipleSelect3.getText());

    }




    @AfterClass
    public static void stopDriver() {
        //driver.quit();
    }




}
