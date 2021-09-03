package by.academy.homework.hmwk5.task7;

import java.util.ArrayList;
import java.util.List;

interface TestLyambda<T,V>{
    T func(V obj);
}

public class Test {
    public static void main(String[] args) {
        boolean ifTrue = false;
        String test = "123";
        TestLyambda<Boolean,String> testLyam = str -> {
            return str.equals("123");
        };
        ifTrue = testLyam.func(test);
        System.out.println(ifTrue);
    }
}
