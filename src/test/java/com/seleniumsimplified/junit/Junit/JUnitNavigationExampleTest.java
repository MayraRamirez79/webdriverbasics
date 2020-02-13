package com.seleniumsimplified.junit.Junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


public class JUnitNavigationExampleTest {

    private static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        //System.setProperty("webdriver.gecko.driver",
        driver = new FirefoxDriver();
       // driver.get("https://google.com");
    }

    @Test
    public void navigateWithNavigateTo(){
        driver.navigate().to("http://compendiumdev.co.uk/selenium");
        assertTrue(driver.getTitle().
                startsWith("Selenium Simplified"));
        // driver.findElement(By.linkText("about")).click();
    }

    @Test
     public void navigateWithNavigateTo2(){
     driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
     assertTrue(driver.getTitle().
             startsWith("Selenium Simplified Search Engine"));
    }


    /*@Test
     public void navigateWithNavigateBack(){
         driver.navigate().back();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         assertTrue(driver.getTitle().
                 startsWith("Selenium Simplified"));
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_html_form.html");
        assertTrue(driver.getTitle().
                startsWith("HTML Form Elements"));
     }

     @Test
     public void navigateWithNavigateForward(){
         driver.navigate().forward();
         //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //assertTrue(driver.getTitle().
                 //startsWith("Selenium Simplified"));
         driver.navigate().to("http://compendiumdev.co.uk/selenium/refresh.php");
         //assertTrue(driver.getTitle().
                 //startsWith("Refresh me"));
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.navigate().refresh();
         //assertTrue(driver.getTitle().
                    //startsWith("Selenium Simplified"));


     }




      /*@AfterClass
       public static void quitDriver(){
              driver.quit();
       }  */


}
