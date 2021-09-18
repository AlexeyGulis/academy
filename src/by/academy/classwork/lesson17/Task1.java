package by.academy.classwork.lesson17;

public class Task1 {
    public static void main(String[] args) {
        StringBuilder strB = new StringBuilder();
        strB.append('a');
        ObjectLetter letter = new ObjectLetter(strB);
        ObjectThread thread1 = new ObjectThread(letter);
        ObjectThread thread2 = new ObjectThread(letter);
        ObjectThread thread3 = new ObjectThread(letter);
        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }
}
