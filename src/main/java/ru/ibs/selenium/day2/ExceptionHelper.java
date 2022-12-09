package ru.ibs.selenium.day2;

public class ExceptionHelper {
    public void throwsExeption(){
        System.out.println("Throw exception");
        throw new RuntimeException();
    }

    public void doesNotThrowsExeption(){
        System.out.println("Does not throw exception");
        //throw new RuntimeException();
    }
}
