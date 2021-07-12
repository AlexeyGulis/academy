package by.academy.homework1;

public class Task14 {
    public static void main(String[] args) {
        int exponent = 0;
       while (Math.pow(2,exponent)<1__000__000){
           System.out.println("2 в степени " + exponent + " равно " + Math.pow(2,exponent++));
       }
    }
}
