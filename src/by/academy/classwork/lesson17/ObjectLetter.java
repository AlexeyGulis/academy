package by.academy.classwork.lesson17;

public class ObjectLetter {
    public StringBuilder strB;
    public ObjectLetter(StringBuilder strB){
        this.strB = strB;
    }
    public synchronized void printB(){
        for (int i = 0; i < 5; i++) {
            System.out.println(strB);
        }
        strB = new StringBuilder(String.valueOf(Character.valueOf((char) (strB.charAt(0) + 1))));
    }
}
