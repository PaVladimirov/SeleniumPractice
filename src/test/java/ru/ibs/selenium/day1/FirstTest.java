package ru.ibs.selenium.day1;

import org.junit.jupiter.api.*;

public class FirstTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("- Before all");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("- After all");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("- - before each");
    }
    @BeforeEach
    public void beforeEach2(){
        System.out.println("- - before each2");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("- - after each");
    }

    @AfterEach
    @Tag(Tags.SECOND)
    @org.junit.jupiter.api.Tags({@Tag(Tags.ALL),@Tag(Tags.SECOND)})
    public void afterEach2(){
        System.out.println("- - after each2");
    }

    @Test
    @Tag(Tags.SECOND)
    @RepeatedTest(3)
    @DisplayName("My first test")
    public void firstTest(){
        //Given
        //When
        //Then
        System.out.println("Hello from test!");
    }

    @Test
    public void secondTest(){
        System.out.println("Yet another test");
    }
}
