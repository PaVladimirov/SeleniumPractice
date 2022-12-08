package ru.ibs.selenium.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTest {
    private int a = 10;//10
    private int b = 3;//3

    @Test
    public void verifySum(){
        //Given

        //When
        int c = a + b;
        //Then c==13
        String message = a + "+" + b + " equal to "+c+" but should be 13";
        //Version 1
        //Assertions.assertEquals(13, c, message);

        //Version 2
        if (c!=13){
            throw  new AssertionError(message);
        }
    }

    @Test
    public void verifyMinus(){
        //Given

        //When
        int c = a - b;
        //Then c==13
        String message = a + "-" + b + " equal to "+c+" but should be 7";
        //Version 1
        //Assertions.assertEquals(13, c, message);

        //Version 2
        if (c!=7){
            throw  new AssertionError(message);
        }
    }

    @Test
    public void verifyMultiplication(){
        //Given

        //When
        int c = a * b;
        //Then c==13
        String message = a + "*" + b + " equal to "+c+" but should be 30";
        //Version 1
        //Assertions.assertEquals(13, c, message);

        //Version 2
        if (c!=30){
            throw  new AssertionError(message);
        }
    }

    @Test
    public void verifyDivision(){
        //Given

        //When
        double c = (double)a / (double) b;
        //Then c==13
        String message = a + "/" + b + " equal to "+c+" but should be 3.3334";
        //Version 1
        /*
        double value = c;
        double scale = Math.pow(10, 4);
        double result = Math.ceil(value * scale) / scale;
        System.out.println((result)); //34.778
        if (result!=3.3334){
            throw  new AssertionError(message);
        }
        */
        //Version 2 сравнивается модуль разности
        c = 1.0*a/b;
        System.out.printf("%1.20f\n", c);
        Assertions.assertTrue(Math.abs(3.3333-c) < 0.0001);
        //Assertions.assertEquals(3.33333333333,c); It will not work
    }
}
