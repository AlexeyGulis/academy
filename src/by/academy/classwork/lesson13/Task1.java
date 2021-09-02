package by.academy.classwork.lesson13;

import java.lang.Integer.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task1 {

    public static void main(String args[]){
        Cat cat1 = new Cat("1",1,"12");
        Tiger cat2 = new Tiger("2",1,"12",3,"123");

        Class<? extends Cat> ct1 = cat1.getClass();

        Class<? extends Tiger> ct2 = cat2.getClass();

        Field[] catsField = ct1.getDeclaredFields();
        System.out.println("Fields from cat");
        for (Field t : catsField
             ) {
            System.out.println(t);
        }
        Field[] tigersField = ct2.getDeclaredFields();
        System.out.println("Fields from tiger");
        for (Field t : tigersField
        ) {
            System.out.println(t);
        }
        Method[] catsMethod = ct1.getDeclaredMethods();
        Method[] tigersMethod = ct2.getDeclaredMethods();
        System.out.println("Methods from cat");
        for (Method t: catsMethod
             ) {
            System.out.println(t);
        }
        System.out.println("Methods from tiger");
        for (Method t: tigersMethod
        ) {
            System.out.println(t);
        }
        System.out.println("cost " + cat1.getCost());
        try{
            Field privCat = ct1.getDeclaredField("cost");
            privCat.setAccessible(true);
            privCat.set(cat1,32);
            System.out.println("change cost " + cat1.getCost());
        }catch(NoSuchFieldException | IllegalAccessException e){
            e.getMessage();
        }
        System.out.println(cat2.getAge());
        try{
            Method privTiger = ct2.getDeclaredMethod("setAge", int.class);
            privTiger.setAccessible(true);
            privTiger.invoke(cat2,5);
            System.out.println("change age from private method, result " + cat2.getAge());
        }catch( NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            e.getMessage();
        }
        System.out.println("Annotations");
        try{
            Field f1 = ct2.getDeclaredField("type");
            Method m1 = ct1.getDeclaredMethod("setCost", int.class);
            TestReflex annoTiger = f1.getAnnotation(TestReflex.class);
            TestReflex annoCat = m1.getAnnotation(TestReflex.class);
            System.out.println("Tiger annotation field type is " + annoTiger.name() + " " + annoTiger.type());
            System.out.println("Cat annotation method setCost is " + annoCat.name() + " " + annoCat.type());
        }catch (NoSuchFieldException | NoSuchMethodException e){
            e.getMessage();

        }


    }
}
