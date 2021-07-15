package by.academy.classwork.lesson1;


public class AnimalDemo {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(5, "Frank");
        System.out.println(animal1.getAge());
        System.out.println(animal2.getAge());
    }
}
