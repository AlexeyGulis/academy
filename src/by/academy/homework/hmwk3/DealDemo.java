package by.academy.homework.hmwk3;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class DealDemo {
    public static void main(String[] args) {
        System.out.println("Deal");
        //Количество сделок неопределено, поэтому возьму значение 20
        Deal[] deals = new Deal[20];
        //test
        User user1 = new User("Vanya",true,"16.09.1993");
        User user2 = new User("Vitya",false,"26.02.1997");
        Deal deal1 = new Deal(user1,user2, new String[]{"product1", "product2", "product3"},new double[]{500.0,215.0,123.0},new int[]{1,4,3},"20.07.2021");
        deal1.getDeal();
        //insert date new deal
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(i<20) {
            System.out.println("Would you like to make a deal? (1) - yes,(2) - no");
            if(scan.nextInt()==1){
                System.out.println("Enter buyer infromation (Name true/false dd.mm.yyyy)");
                String[] nk = scan.nextLine().split(" ");
                if(nk.length==3){
                    int count = 0;
                    System.out.println("Insert count of all products ");
                    count = scan.nextInt();
                    scan.nextLine();
                    String[] products = new String[count];
                    double[] price = new double[count];
                    int[] countElem = new int[count];
                    for (int j = 0; j < products.length; j++) {
                        System.out.print("Type name of product ");
                        products[j]=scan.nextLine();
                        System.out.print("Type price of product ");
                        price[j] = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Type count elements of product ");
                        countElem[j] = scan.nextInt();
                        scan.nextLine();
                    }
                    System.out.print("Date of deal: ");
                    Deal deal2 = new Deal(user1,user2,products,price,countElem,scan.nextLine());
                    deal2.getDeal();
                    i++;
                }else {
                    System.out.println("Incorrect info");
                    continue;
                }
            }else break;
        }
        scan.close();
    }
}
