package by.academy.classwork.lesson1;


public class Animal {
    int age;
    String name;

    public Animal() {
    }

    public Animal(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}