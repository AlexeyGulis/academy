package by.academy.homework.hmwk7.task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class ReflectionDemo {
    public static void main(String[] args) {
        User user1 = new User("alex", "bil", 23, LocalDate.now(), "alex123", "lex32123", "bil_alex@gmail.ru");
        Person person1 = new Person("alex", "bil", 23, LocalDate.now());
        Class<? extends User> us1 = user1.getClass();
        Class<? extends Person> ps1 = person1.getClass();
        getFieldsAndMethods(us1);
        setValueField(us1,user1);
        getValueField(us1,user1);
        toStringValue(us1,user1);
    }

    public static void toStringValue(Class<? extends User> us1,User u1){
        try{
            System.out.println();
            System.out.println("Method toString");
            Method toStringMethod = us1.getDeclaredMethod("toString");
            toStringMethod.setAccessible(true);
            System.out.println(toStringMethod.invoke(u1));
        }catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }
    }

    public static void setValueField(Class<? extends User> us1,User u1){
        try{
            System.out.println();
            System.out.println("Изменияем пароль");
            Field passField = us1.getDeclaredField("password");
            passField.setAccessible(true);
            passField.set(u1,"111111");
            passField = us1.getDeclaredField("login");
            passField.set(u1,"admin");
            passField = us1.getDeclaredField("email");
            passField.set(u1,"admin@contoso.com");

        }catch(NoSuchFieldException | IllegalAccessException e){
            e.getMessage();
        }
    }

    public static void getValueField(Class<? extends User> us1,User u1){
        try{
            Field passField = us1.getDeclaredField("login");
            System.out.println("Теперь логин: " + passField.get(u1));
            passField = us1.getDeclaredField("password");
            passField.setAccessible(true);
            System.out.println("Теперь пароль: " + passField.get(u1));
            passField = us1.getDeclaredField("email");
            System.out.println("Теперь email: " + passField.get(u1));
        }catch(NoSuchFieldException | IllegalAccessException e){
            e.getMessage();
        }
    }

    public static void getFieldsAndMethods(Class<? extends User> us1){
        System.out.println("Доступные поля");
        userFields(us1);
        System.out.println();
        System.out.println("Все поля");
        userFieldsDeclared(us1);
        System.out.println();
        System.out.println("Доступные методы");
        userMethods(us1);
        System.out.println();
        System.out.println("Все методы");
        userMethodsDeclared(us1);
        System.out.println();
        System.out.println("Доступный метод getLogin,setLogin,getEmail,setEmail,printUserInfo");
        userMethod(us1, "getLogin");
        userMethod(us1, "setLogin");
        userMethod(us1, "getEmail");
        userMethod(us1, "setEmail");
        userMethod(us1, "printUserInfo");
        System.out.println();
        System.out.println("Недоступный метод getPassword,setPassword");
        userMethodDeclared(us1, "getPassword");
        userMethodDeclared(us1, "setPassword");
        System.out.println();
        System.out.println("Доступное поле login");
        userField(us1, "login");
        userField(us1, "email");
        System.out.println();
        System.out.println("Недоступное поле password");
        userFieldDeclared(us1, "password");
    }

    public static void userFields(Class<? extends User> us1) {
        Field[] userFields = us1.getFields();
        for (Field t : userFields
        ) {
            System.out.println(t);
        }
    }

    public static void userField(Class<? extends User> us1, String nameField) {
        try {
            Field userField = us1.getField(nameField);
            System.out.println(userField);
        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userFieldsDeclared(Class<? extends User> us1) {
        Field[] userFields = us1.getDeclaredFields();
        for (Field t : userFields
        ) {
            System.out.println(t);
        }
    }

    public static void userFieldDeclared(Class<? extends User> us1, String nameField) {
        try {
            Field userField = us1.getDeclaredField(nameField);
            System.out.println(userField);
        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userMethods(Class<? extends User> us1) {
        Method[] userMethods = us1.getMethods();
        for (Method t : userMethods
        ) {
            System.out.println(t);
        }
    }

    public static void userMethod(Class<? extends User> us1, String nameMethod) {
        try {
            Method userField = us1.getMethod(nameMethod);
            System.out.println(userField);
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userMethodsDeclared(Class<? extends User> us1) {
        Method[] userMethods = us1.getDeclaredMethods();
        for (Method t : userMethods
        ) {
            System.out.println(t);
        }
    }

    public static void userMethodDeclared(Class<? extends User> us1, String nameMethod) {
        try {
            Method userField = us1.getDeclaredMethod(nameMethod);
            System.out.println(userField);
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }
}
