package by.academy.homework.hmwk3;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealDemo {
    //static Pattern email = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    static Pattern email = Pattern.compile("^.*?@.*?\\..*$");

    public static void main(String[] args) throws ParseException {
        System.out.println("Deals");
        Validator emailValidator = new Validator() {
            @Override
            public boolean validate(String t) {
                Matcher matcher = email.matcher(t);
                return matcher.find();
            }
        };
        //Количество сделок неопределено, поэтому возьму значение 20, можно написать чтобы массив динамически расширялся (2хдлины) доходя до границы.
        Deal[] deals = new Deal[20];
        User user1;
        User user2;
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(i<20) {
            System.out.println("Would you like to make a deal? (1) - yes,(2) - no");
            if(scan.nextInt()==1){
                scan.nextLine();
                System.out.println("Buyer information (Name Phone(+375XXXXXXX|+1XXXXXXX) Date of birth(dd-MM-yyyy|dd/mm/yyyy) Email(XXXXX@XXX.XX)): ");
                String[] nk1 = scan.nextLine().split(" ");
                System.out.println("Seller information (Name Phone(+375XXXXXXX|+1XXXXXXX) Date of birth(dd-MM-yyyy|dd/mm/yyyy) Email(XXXX@XXX.XX)): ");
                String[] nk2 = scan.nextLine().split(" ");
                if(nk1.length==4 && nk2.length==4
                        && TimeValidator.dateValidate(nk1[2]) && TimeValidator.dateValidate(nk2[2])
                        && (new BelarusPhoneValidator().validate(nk1[1]) || new AmericanPhoneValidator().validate(nk1[1]))
                        && (new BelarusPhoneValidator().validate(nk2[1]) || new AmericanPhoneValidator().validate(nk2[1]))
                        && emailValidator.validate(nk1[3]) && emailValidator.validate(nk2[3])){
                    user1 = new User(nk1[0],true,nk1[2],nk1[1],nk1[3]);
                    user2 = new User(nk2[0],false,nk2[2],nk2[1],nk2[3]);
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
                    System.out.print("Date of deal (dd-MM-yyyy|dd/MM/yyyy): ");
                    String dateDeal = scan.nextLine();
                    if(!TimeValidator.dateValidate(dateDeal)){
                        System.out.println("Incorrect info");
                        continue;
                    }
                    deals[i] = new Deal(user1,user2,products,price,countElem,dateDeal);
                    deals[i].getDeal();
                    i++;
                }else {
                    System.out.println("Incorrect info");
                    continue;
                }
            }else break;
        }
        System.out.println("Would you like to correct any deal? (1) - yes,(2) - no");
        if(scan.nextInt()==1){
            scan.nextLine();
            for (int j = 0; j < deals.length; j++) {
                if(deals[j]!=null){
                    deals[j].getDeal();
                    System.out.println("Would you like to correct this deal? (1) - yes,(2) - no");
                    if(scan.nextInt()==1){
                        System.out.println("Would you like? (1) - remove product,(2) - add product,(3) - nothing");
                        if(scan.nextInt()==1){
                            scan.nextLine();
                            System.out.println("Name removal product ");
                            deals[i].removeProduct(scan.nextLine());
                        }
                        if(scan.nextInt()==2){
                            String name = "";
                            double price = 0.0;
                            int count = 0;
                            scan.nextLine();
                            System.out.println("Name addition product ");
                            name = scan.nextLine();
                            System.out.print("Price of product: ");
                            price = scan.nextDouble();
                            scan.nextLine();
                            System.out.print("Count elements of product: ");
                            count = scan.nextInt();
                            scan.nextLine();
                            deals[i].addProduct(name,price,count);
                        }
                    }
                }
            }
        }
        scan.close();
    }
}
