package by.academy.classwork.lesson1;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {
    int age;
    String name;
    private int money;
    private char initials;
    private boolean isHomeAnimal;


    public void grow(){
        age++;
    }
    public void sleep(){
        System.out.println("Кот спит");
    }
    public void eat(){
        System.out.println("Кот ест");
    }
    public void walk(){
        System.out.println("Кот гуляет");
    }
    public Cat(){
    }
    public Cat(String name){
        this.name = name;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }
    public void setInitials(char initials){
        this.initials = initials;
    }
    public char getInitials(){
        return initials;
    }
    public void setIsHomeAnimal(boolean isHomeAnimal){
        this.isHomeAnimal = isHomeAnimal;
    }
    public boolean getIsHomeAnimal(){
        return isHomeAnimal;
    }
}
