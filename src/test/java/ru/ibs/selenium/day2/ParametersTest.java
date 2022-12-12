package ru.ibs.selenium.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParametersTest {

    @ParameterizedTest
    @ArgumentsSource(PersonProvider.class)
    public void argumentsSourceTest(String expected,Person person){
        // When
        String actual = person.getFullName();
        // Then
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({"Ivan Petrovich Sidorov,Ivan;Petrovich;Sidorov",
            "Jack Smith,Jack;;Smith"
    })
    public void personTest(String expected,Person person){
        // When
        String actual = person.getFullName();
        // Then
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({"Ivan Petrovich Sidorov,Ivan,Petrovich,Sidorov",
            "Jack Smith,Jack,,Smith"
    })
    public void aggregatorTest(String expected,@AggregateWith(PersonAggregator.class) Person person){
        // When
        String actual = person.getFullName();
        // Then
        Assertions.assertEquals(expected,actual);
    }


    @ParameterizedTest
    @CsvSource({"Ivan Petrovich Sidorov,Ivan,Petrovich,Sidorov",
    "Jack Smith,Jack,,Smith"
    })
    public void argumentsTest (ArgumentsAccessor args){
        // Given
        String expected = args.getString(0);
        String firstName = args.get(1,String.class);
        String middleName = (String) args.get(2);
        String lastName = args.getString(3);
        Person person = new Person(firstName,middleName,lastName);
        // When
        String actual = person.getFullName();
        // Then
        Assertions.assertEquals(expected,actual);

    }

    @ParameterizedTest
    //@CsvFileSource(files = "/fruits.txt") не отработало
    @CsvFileSource(resources = "/fruits.txt")
    public void csvSource2 (int n, String name, String color, boolean isSweet){
        System.out.println(n+". "+name+color+isSweet);
    }

    @ParameterizedTest
    @CsvSource({"1,Apple,Red,true","2,Lemon,Yello,false"})
    public void csvSource (int n, String name, String color, boolean isSweet){
        System.out.println(n+". "+name+color+isSweet);
    }

    public static Stream<Arguments> modernWay() {
        return Stream.of(
                Arguments.of(1,"One", true), //if will be problems when parametrs more - is OK - (2,"Two", false,"qweqw")
                Arguments.of(2,"Two", false) // but if there is less parameters - fail - (2,"Two")
        );
    }

    public static Object[][] classicWay(){
        return new Object[][]{new Object[]{3,"Three",true},new Object[]{4,"Four",false}};
    }

    @ParameterizedTest
    @MethodSource({"modernWay", "classicWay"})
    public void methodParams(int n, String s, boolean b){
        System.out.println("n= "+n +" s="+s+" b= "+b);
        if (n==2) Assertions.fail();
    }

    @ParameterizedTest
    @ValueSource (strings = {"One","Two","Three"})
    public void valueParams(String param){
        System.out.println("Working with param: "+ param);

    }
}
