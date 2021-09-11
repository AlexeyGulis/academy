package by.academy;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int v1 = 1;
        int v2 = 1;
        if(v1++ == ++v2){
            System.out.println("1");
        }
        List list = new ArrayList(3);

        int i = 10;
        do{i--;}while (i>1);
        System.out.println(i);
    }
}
