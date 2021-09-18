package by.academy.classwork.lesson16.callcenter;

import java.util.LinkedList;
import java.util.Random;

public class CallCenter {
    private LinkedList<Operator> operators;

    public CallCenter(LinkedList<Operator> operators) {
        this.operators = operators;
    }

    public synchronized Operator takeOperator() {
        Random rand = new Random();
        Operator operator;

        operator = operators.poll();
        while (operator == null) {
            try {
                System.out.println("Ожидайте свободного оператора.");
                if (rand.nextInt(10) > 5) {
                    System.out.println(Thread.currentThread().getName() + " перезвонит");
                    Thread.sleep(10000);
                    return null;
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            operator = operators.poll();
        }
        return operator;
    }

    public synchronized void returnOperator(Operator operator) {
        operators.add(operator);
        System.out.println("Звонок c " + Thread.currentThread().getName() + " завершен. Оператор " + operator.name + " освободился");
        notify();
    }
}
