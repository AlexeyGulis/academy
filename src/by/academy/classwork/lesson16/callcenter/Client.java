package by.academy.classwork.lesson16.callcenter;

public class Client extends Thread{
    public String name;
    public CallCenter callCenter;
    public Client(String name, CallCenter callCenter){
        this.callCenter = callCenter;
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        Operator operator = callCenter.takeOperator();
        while (operator == null){
            operator = callCenter.takeOperator();
        }
        operator.takeCall();
        callCenter.returnOperator(operator);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client");
        return sb.toString();
    }
}
