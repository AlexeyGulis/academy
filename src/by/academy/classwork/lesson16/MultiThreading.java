package by.academy.classwork.lesson16;

import by.academy.classwork.lesson16.callcenter.CallCenter;
import by.academy.classwork.lesson16.callcenter.Client;
import by.academy.classwork.lesson16.callcenter.Operator;
import by.academy.classwork.lesson16.callcenter.RandClients;

import java.util.LinkedList;

public class MultiThreading {
    public static void main(String[] args) {
        LinkedList<Operator> operators = new LinkedList<>();
        Operator operator1 = new Operator("Vasya");
        Operator operator2 = new Operator("Lilya");
        Operator operator3 = new Operator("Dima");
        operators.add(operator1);
        operators.add(operator2);
        operators.add(operator3);
        CallCenter callCenter = new CallCenter(operators);
        RandClients randClients = new RandClients(callCenter);
        new Thread(randClients).start();
    }
}
