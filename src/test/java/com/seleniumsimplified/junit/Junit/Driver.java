package com.seleniumsimplified.junit.Junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

public static WebDriver driver;

//metodo constructor
public Driver(String driverType){
        if (driverType.equals("chrome"))
        {
        driver= new ChromeDriver();
        }
        else
        {
        driver= new FirefoxDriver();
        }

        }
//metodo funcion , porque regresa algo
public static WebDriver getDriver(){
        return driver;
        }


}
