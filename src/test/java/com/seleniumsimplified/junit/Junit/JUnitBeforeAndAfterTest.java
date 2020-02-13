package com.seleniumsimplified.junit.Junit;

import org.junit.*;

public class JUnitBeforeAndAfterTest {

    static int additionSum=4;


    @BeforeClass
    public static void beforeClass(){
        additionSum=13;
        System.out.println("Before class");
    }

    @Before
    public void beforeTest(){
        System.out.println("Before test");
    }

    @Test
    public void this1Test(){
        additionSum= additionSum + 10;
        System.out.println("Aqui esta la suma");
        System.out.print(additionSum);
        System.out.println();
    }

    @Test
    public void this2Test(){
        System.out.println("This 2 test");
    }

    @Test
    public void this3Test(){
        System.out.println("This 3 test");
    }

    @After
    public void afterTest(){
        System.out.println("After test");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After class");
    }



}
