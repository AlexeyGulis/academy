package by.academy.classwork.lesson16.callcenter;

import java.util.Random;

public class RandClients extends Thread{
    public Random rand = new Random();
    public String[] names = {"Masha","Olya","Petya","Sasha","Vitya"};
    public CallCenter callCenter;
    public RandClients(CallCenter callCenter){
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        super.run();
        Client client;
        for (;;){
            try {
                sleep(rand.nextInt(7)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client = new Client(names[rand.nextInt(names.length)],callCenter);
            System.out.println("Звонок от клиента " + client.name);
            new Thread(client,client.name).start();
        }
    }
}
