package ru.ibs.selenium.day2;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class PersonAggregator implements ArgumentsAggregator {
    @Override
    public Person aggregateArguments(ArgumentsAccessor args, ParameterContext context) throws ArgumentsAggregationException {
        String firstName = args.get(1,String.class);
        String middleName = (String) args.get(2);
        String lastName = args.getString(3);
        return new Person(firstName,middleName,lastName);
    }
}
