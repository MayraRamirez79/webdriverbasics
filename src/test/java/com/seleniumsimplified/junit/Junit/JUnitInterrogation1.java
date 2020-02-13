package com.seleniumsimplified.junit.Junit;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class JUnitInterrogation1 {
    public static WebDriver driver;



    @BeforeClass
    public static void createDriver() {
        //System.setProperty("webdriver.gecko.driver",
        driver = new FirefoxDriver();
        // driver.get("https://google.com");
    }

    @Test
    public void navigateWithNavigateTo(){
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_web_page.html");
        assertTrue(driver.getTitle().
                startsWith("Basic Web Page Title"));
        // driver.findElement(By.linkText("about")).click();
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println(CurrentUrl);
        String PageSource = driver.getPageSource();
        assertTrue(PageSource.contains("A paragraph of text"));
        System.out.println(PageSource);

    }

    @AfterClass
    public static void stopDriver() {
        driver.quit();
    }




}
