package ru.ibs.selenium.day2;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.reflect.Array;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FabricTest {

    @TestFactory
    public Collection <DynamicTest> dynamicTest(){
        List<DynamicTest> steps = new ArrayList<>();

        steps.add(DynamicTest.dynamicTest("Step 1",()->{
            System.out.println("Do something");
        }));
        steps.add(DynamicTest.dynamicTest("Step 2",()->{
            System.out.println("Continue work");
        }));
        steps.add(DynamicTest.dynamicTest("Step 3",()->{
            System.out.println("Finish work");
        }));

        return steps;
        //return Arrays.asList();
    }
}
