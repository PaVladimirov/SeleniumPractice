package ru.ibs.selenium.day1;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@Tag(Tags.SECOND)
public class OrderedTest {
    @Test
    @Order(333)
    @Tag (Tags.FIRST)
    public void m1(){
        System.out.println("m1");
    }
    @Test
    @Order(10)
    public void m3(){
        System.out.println("m3");
    }
    @Test
    @Order(20)
    public void m2(){
        System.out.println("m2");
    }
}
