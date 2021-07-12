package by.academy.classwork.lesson1;

public class Application {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat("Витя");
        cat1.eat();
        cat1.sleep();
        cat1.walk();
        for (int i = 0; i < 3; i++) {
            cat2.grow();
        }
        System.out.println("Кот "+cat2.name + ", возраст " + cat2.age);

    }
}
