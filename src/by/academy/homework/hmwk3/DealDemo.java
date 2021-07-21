package by.academy.homework.hmwk3;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class DealDemo {
    public static void main(String[] args) {
        System.out.println("Deals");
        //Количество сделок неопределено, поэтому возьму значение 20, можно написать чтобы массив динамически расширялся (2хдлины) доходя до границы.
        Deal[] deals = new Deal[20];
        User user1;
        User user2;
        /*test
        User user1 = new User("Vanya",true,"16.09.1993");
        User user2 = new User("Vitya",false,"26.02.1997");
        Deal deal1 = new Deal(user1,user2, new String[]{"product1", "product2", "product3"},new double[]{500.0,215.0,123.0},new int[]{1,4,3},"20.07.2021");
        deal1.getDeal();
        */
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(i<20) {
            System.out.println("Would you like to make a deal? (1) - yes,(2) - no");
            if(scan.nextInt()==1){
                scan.nextLine();
                System.out.println("Buyer infromation (Name true/false dd.mm.yyyy/dd-mm-yyyy)");
                String[] nk1 = scan.nextLine().split(" ");
                System.out.println("Seller infromation (Name true/false dd.mm.yyyy/dd-mm-yyyy)");
                String[] nk2 = scan.nextLine().split(" ");
                if(nk1.length==3 && nk2.length==3){
                    if(Boolean.valueOf(nk1[1]))nk2[1]="false";else nk2[1]="true";
                    user1 = new User(nk1[0],Boolean.valueOf(nk1[1]),nk1[2]);
                    user2 = new User(nk2[0],Boolean.valueOf(nk2[1]),nk2[2]);
                    int count = 0;
                    System.out.println("Count of all products: ");
                    count = scan.nextInt();
                    scan.nextLine();
                    String[] products = new String[count];
                    double[] price = new double[count];
                    int[] countElem = new int[count];
                    for (int j = 0; j < products.length; j++) {
                        System.out.print("Name of product: ");
                        products[j]=scan.nextLine();
                        System.out.print("Price of product: ");
                        price[j] = scan.nextDouble();
                        scan.nextLine();
                        System.out.print("Count elements of product: ");
                        countElem[j] = scan.nextInt();
                        scan.nextLine();
                    }
                    System.out.print("Date of deal (dd.mm.yyyy/dd-mm-yyyy): ");
                    deals[i] = new Deal(user1,user2,products,price,countElem,scan.nextLine());
                    deals[i].getDeal();
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
