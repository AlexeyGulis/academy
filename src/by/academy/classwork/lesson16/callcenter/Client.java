package by.academy.classwork.lesson16.callcenter;

public class Client extends Thread{
    public String name;
    public CallCenter callCenter;
    public Client(String name,CallCenter callCenter){
        this.name = name;
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 3; i++) {
            callCenter.callClient();
        }
    }
}
