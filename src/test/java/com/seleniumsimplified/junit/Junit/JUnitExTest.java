package com.seleniumsimplified.junit.Junit;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class JUnitExTest {

    static int additionSum=5;


    @BeforeClass
    public static void beforeClass(){
        additionSum=additionSum*5;
        System.out.println("Before class");
        System.out.println("La suma es de :");
        System.out.print(additionSum);
        System.out.println();
    }

    @Before
    public void beforeTest(){
        System.out.println("Before test");
        this.additionSum=additionSum+5;
        System.out.println("La suma es de :");
        System.out.print(additionSum);
        System.out.println();
     }

    @Test
    public void this1Test(){
        additionSum= additionSum + 10;
        assertTrue((this.additionSum==40));
        System.out.println("Test 1");
        System.out.println("Comando AssertTrue");
        System.out.println("La suma es de: ");
        System.out.print(additionSum);
        System.out.println();
    }

    @Test
    public void this2Test(){
        assertFalse((this.additionSum>100));
        System.out.println("Test 2");
        System.out.println("Comando AssertFalse");
        System.out.println("La suma es de: ");
        System.out.print(additionSum);
        System.out.println();
    }

    @Test
    public void this3Test(){
       assertEquals("45 + 5 = 50", 50, 45+5);
       System.out.println("Test 3");
       System.out.println("Comando AssertEquals");
       System.out.println("La suma es de: ");
       System.out.print(additionSum);
       System.out.println();
     }

       @Test
       public void this4Test(){
       assertThat(additionSum, is(55));
       System.out.println("Test 4");
       System.out.println("Comando AssertThat");
       System.out.print(additionSum);
       System.out.println();
       }


    }


