package by.academy.homework.hmwk2;

import java.util.*;

public class Stack {
    private Card[] stck;
    private static int tos;

    Stack(int numberCards) {
        stck = new Card[numberCards];
        tos = -1;
    }

    public void push(Card ojb) {
        if (tos == stck.length - 1) {
            System.out.println("Колода заполнена");
        } else stck[++tos] = ojb;
    }

    public Card pop() {
        if (tos < 0) {
            System.out.println("Колода пустая");
            return null;
        } else return stck[tos--];
    }

    public void shuffle() {
        Random rnd = new Random();
        Card temp;
        for (int i = 0; i < stck.length; i++) {
            int index = rnd.nextInt(stck.length);
            temp = stck[index];
            stck[index] = stck[i];
            stck[i] = temp;
        }
    }

}
