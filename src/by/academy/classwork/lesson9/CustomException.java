package by.academy.classwork.lesson9;

public class CustomException extends Exception{
    private static final long serialVersionUID = 1;
    public CustomException(){
        super();
    }
    public CustomException(String message){
        super(message);
    }
}
