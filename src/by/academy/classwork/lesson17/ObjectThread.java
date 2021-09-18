package by.academy.classwork.lesson17;

public class ObjectThread extends Thread{
    public ObjectLetter letter;
    public ObjectThread(ObjectLetter letter){
        this.letter = letter;
    }
    @Override
    public void run() {
        super.run();
        letter.printB();
    }
}
