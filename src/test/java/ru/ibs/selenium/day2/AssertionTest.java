package ru.ibs.selenium.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.function.Supplier;

public class AssertionTest {

    @Test
    public void myTest(){
        waitForSomething(2000,()->{
            Random r = new Random();
            if (r.nextDouble()<0.1)/*emulation of */
            {return  "valid";}
            return "not valid";
        });
    }

    //function for time delay (handmade=) ) Type of second parametr under quation
    public void waitForSomething(long ms, Supplier action){
        long start = System.currentTimeMillis();
        long end = start + ms;
        while (System.currentTimeMillis()<end){
            String data = (String) action.get();
            if (!"valid".equals(data)){
                try {
                Thread.sleep(500);
                }catch(Exception ignored){ }
            }

        }
    }

    @Test
    public void failTest(){
        //Assertions.fail("Just fail"); THIS OK
        try {
            Assertions.fail("Just fail");//Never do this!! FALSE POSITIVE
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @Test
    public void timeoutTest2(){
        try {
            Thread.sleep(Duration.ofSeconds(3));
        }catch(Exception ignored){}

    }


    @Test
    public void timeoutTest(){
        Assertions.assertTimeout(Duration.ofSeconds(1),()->{
            try{
                Thread.sleep(Duration.ofSeconds(2));
            }catch(Exception ignored) {}
        }
            );
    }



    @Test
    public void nullNotNullTest(){
        Object o = getNullObject(false);
        Assertions.assertNotNull(o);
        o = getNullObject(true);
        Assertions.assertNull(o);
    }

    private Object getNullObject(boolean val){
        if (val) return null;
        return new Object();
        //либо return 3; return "";
    }

    @Test
    public void multiplyTest2(){
        MultipleConditions conditions = new MultipleConditions();
        Assertions.assertAll(
                ()->{Assertions.assertTrue(conditions.isA());},
                ()->{Assertions.assertFalse(conditions.isB());},
                ()->{Assertions.assertTrue(conditions.isC());}
        );
        /*некорректный вариант, где при ошибке во втором не будет результата 3
        Assertions.assertTrue(conditions.isA());
        Assertions.assertTrue(conditions.isB());
        Assertions.assertTrue(conditions.isC());*/
    }

    @Test
    public void multiplyTest(){
        MultipleConditions conditions = new MultipleConditions();
        Assertions.assertTrue(conditions.isA());
        Assertions.assertTrue(conditions.isB());
        Assertions.assertTrue(conditions.isC());
    }

    @Test
    public void assertThrows(){
        ExceptionHelper helper = new ExceptionHelper();
        Assertions.assertThrows(RuntimeException.class,
                () -> {
                    //helper.doesNotThrowsExeption();
                    helper.throwsExeption();
                });
        Assertions.assertDoesNotThrow(() -> {
            //helper.throwsExeption();
            helper.doesNotThrowsExeption();
        });
    }

    @Test
    public void assertTrueFalse(){
        Assertions.assertTrue(3>2);
        Assertions.assertFalse(getResult());
    }

    private boolean getResult(){
        return false;
    }

    @Test
    public void equalityTest2(){
        Person expected = new Person("Ivan","Petrovich","Sidorov");
        Person actual = new Person("Ivan","Petrovich","Sidorov");
        Assertions.assertEquals(expected,actual);//тут перегружен equals и hashcode  классе, для сравнения
    }
    @Test
    public void equalityTest3(){
        Person expected = new Person("Ivan","Petrovich","Sidorov");
        Person actual = new Person("2222","Petrovich","Sidorov");
        Assertions.assertNotEquals(expected,actual);//
    }

    @Test
    public void equalityTest(){
        int [] expected = {2,6,1};
        int [] actual = {2,1,6};
        Assertions.assertArrayEquals(expected,actual);
    }
}
