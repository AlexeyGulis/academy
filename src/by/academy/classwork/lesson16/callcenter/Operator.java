package by.academy.classwork.lesson16.callcenter;

public class Operator extends Thread{

    public String name;

    public Operator(String name){
        this.name = name;
    }
    public void takeCall(){
        System.out.println("Оператор " + name + " отвечает на звонок " + Thread.currentThread().getName());
        try {
            sleep(7000 + (long) (Math.random()*3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
