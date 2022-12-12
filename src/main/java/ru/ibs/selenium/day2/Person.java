package ru.ibs.selenium.day2;

import java.util.Objects;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;

    public Person(String firstName,String middleName,String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && Objects.equals(middleName, person.middleName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    public String getFullName(){
        StringBuilder sb = new StringBuilder();

        sb.append(firstName);

        if (middleName != null && !middleName.isEmpty()){
            sb.append(" ");
            sb.append(middleName);
        }

        sb.append(" ");
        sb.append(lastName);

        return sb.toString();
    }

    public Person(String personStr){
        String [] parts = personStr.split(";");
        firstName=parts[0];
        middleName=parts[1];
        lastName=parts[2];
        //ненадежный код, тк пердполагается что всегда в конструктор падает 3 элемента ращделенные точкой с запятой
        //но для тренирвоки ОК
    }
}
