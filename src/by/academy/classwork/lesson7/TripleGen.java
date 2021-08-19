package by.academy.classwork.lesson7;

import java.io.Serializable;
import by.academy.classwork.lesson1.*;
import by.academy.deal.services.interfaces.Validator;

public class TripleGen<T extends Comparable<String>,V extends Animal & Serializable,K extends Number> {
    T ob1;
    V ob2;
    K ob3;
    TripleGen(T ob1,V ob2,K ob3){
        this.ob1 = ob1;
        this.ob2 = ob2;
        this.ob3 = ob3;
    }

    public void getClassNameT(){
        if(ob1 == null) System.out.println("Nothing");
        else System.out.println(ob1.getClass().getName());
    }
    public void getClassNameV(){
        if(ob2 == null) System.out.println("Nothing");
        else System.out.println(ob2.getClass().getName());
    }
    public void getClassNameK(){
        if(ob3 == null) System.out.println("Nothing");
        else System.out.println(ob3.getClass().getName());
    }

    public static void main(String[] args) {
        TripleGen<String,Cat,Integer> ttt = new TripleGen<String, Cat, Integer>("sdsd",new Cat(), 323);
        ttt.getClassNameT();
        ttt.getClassNameV();
        ttt.getClassNameK();
        Validator obj = new Validator() {
            @Override
            public boolean validate(String t) {
                return false;
            }
        };
    }
}
