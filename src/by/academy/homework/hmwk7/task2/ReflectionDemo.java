package by.academy.homework.hmwk7.task2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class ReflectionDemo{
    public static void main(String[] args) {
        User user1 = new User("alex","bil",23, LocalDate.now(),"alex123","lex32123","bil_alex@gmail.ru");
        Person person1 = new Person("alex","bil",23, LocalDate.now());
        Class<? extends User> us1 = user1.getClass();
        Class<? extends Person> ps1 = person1.getClass();
        userField(us1);
        userFieldDeclared(us1);
        userMethods(us1);
        userMethodsDeclared(us1);
    }
    public static void userField(Class<? extends User> us1){
        Field[] userFields = us1.getFields();
        System.out.println("Fields from User");
        for (Field t : userFields
        ) {
            System.out.println(t);
        }
    }
    public static void userFieldDeclared(Class<? extends User> us1){
        Field[] userFields = us1.getDeclaredFields();
        System.out.println("Fields from User");
        for (Field t : userFields
        ) {
            System.out.println(t);
        }
    }
    public static void userMethods(Class<? extends User> us1){
        Method[] userMethods = us1.getMethods();
        System.out.println("Methods from User");
        for (Method t: userMethods
        ) {
            System.out.println(t);
        }
    }
    public static void userMethodsDeclared(Class<? extends User> us1){
        Method[] userMethods = us1.getDeclaredMethods();
        System.out.println("Methods from User");
        for (Method t: userMethods
        ) {
            System.out.println(t);
        }
    }
}
