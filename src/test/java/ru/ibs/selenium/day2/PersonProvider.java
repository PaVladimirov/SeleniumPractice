package ru.ibs.selenium.day2;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class PersonProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of("Ivan Ivanovich Ivanov", new Person("Ivan","Ivanovich","Ivanov")),
                Arguments.of("Jack Smith",new Person("Jack", null, "Smith"))
        );
    }
}
