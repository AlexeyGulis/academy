package by.academy.homework.hmwk7.task2;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private LocalDate dateOfBirth;

    public Person(String firstName, String secondName, int age, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    private String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getSecondName() {
        return secondName;
    }

    private void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
