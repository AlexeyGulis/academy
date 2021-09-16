package by.academy.classwork.lesson16.callcenter;

import java.util.LinkedList;

public class CallCenter {
    private LinkedList<Operator> operators;
    public CallCenter(LinkedList<Operator> operators){
        this.operators = operators;
    }
    public synchronized void takeOperator(){
        Operator operator = operators.poll();
        if(operator == null){
            try {
                wait();
                System.out.println("123");
                operator.takeCall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            operator.takeCall();
        }
    }
    public synchronized void returnOperator(){

    }
    //public synchronized void callClient(){
    //        numberCalls++;
    //        while(numberSpareOperators < 1){
    //            try {
    //                System.out.println("Ожидайте оператора или перезвоните в другое время. Количество ожидающих: " + numberCalls);
    //                wait();
    //            } catch (InterruptedException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //        numberSpareOperators--;
    //        notify();
    //        System.out.println(Thread.currentThread().getName() + " на ваш вызов отвечают. Осталось свободных операторов " + numberSpareOperators);
    //        try {
    //            Thread.sleep(15000 + (long) (Math.random()*10000));
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //        numberSpareOperators++;
    //    }
    //    public synchronized void callOperator(){
    //        while(numberCalls < 1){
    //            try {
    //                System.out.println("Ожидание звонков");
    //                wait();
    //            } catch (InterruptedException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //        System.out.println(Thread.currentThread().getName() + " ответил на звонок. Колличество звонков " + numberCalls);
    //        numberCalls--;
    //        notify();
    //    }
    //    public synchronized void addOperator(){
    //        numberSpareOperators++;
    //    }

}
