package by.academy.classwork.lesson16.callcenter;

public class Operator extends Thread{

    public String name;

    public Operator(String name){
        this.name = name;
    }
    public void takeCall(){
        System.out.println("Hello");
    }
}
