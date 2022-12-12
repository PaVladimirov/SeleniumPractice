package ru.ibs.selenium.day2;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTest {

    @Test
    public void assumptionTest(){
        Assumptions.assumeTrue(true);
        System.out.println("Assumption passed");
    }
    @Test
    public void assumptionFailedTest(){
        Assumptions.assumeTrue(false);
        System.out.println("Assumption failed");
    }
}
