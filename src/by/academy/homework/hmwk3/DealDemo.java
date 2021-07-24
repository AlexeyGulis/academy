package by.academy.homework.hmwk3;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealDemo {
    //static Pattern email = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    static Pattern email = Pattern.compile("^.*?@.*?\\..*$");
    static Deal[] deals = new Deal[20];
    static Validator emailValidator;
    static Product[] products;

    public static void main(String[] args) throws ParseException {
        System.out.println("Deals");
        emailValidator = new Validator() {
            @Override
            public boolean validate(String t) {
                Matcher matcher = email.matcher(t);
                if (matcher.find()) {
                    return true;
                } else {
                    System.out.println("Incorrect email");
                    return false;
                }
            }
        };
        //Количество сделок неопределено, поэтому возьму значение 20, можно написать чтобы массив динамически расширялся (2хдлины) доходя до границы.
        User seller;
        User buyer;
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < 20) {
            System.out.println("Would you like to make a deal? (1) - yes,(2) - no");
            if (scan.nextInt() == 1) {
                scan.nextLine();
                String[] nk1;
                String[] nk2;
                while (true) {
                    System.out.println("Buyer information");
                    System.out.println("Name Phone(+375XXXXXXX|+1XXXXXXX) Date of birth(dd-MM-yyyy|dd/mm/yyyy) Email(XXXX@XXX.XX)");
                    nk1 = scan.nextLine().split(" ");
                    if (chekUser(nk1)) {
                        break;
                    } else {
                        System.out.println("Incorrect info");
                        System.out.println("Please re-enter info");
                    }

                }

                buyer = new User(nk1[0], true, nk1[2], nk1[1], nk1[3]);

                while (true) {
                    System.out.println("Seller information");
                    System.out.println("Name Phone(+375XXXXXXX|+1XXXXXXX) Date of birth(dd-MM-yyyy|dd/mm/yyyy) Email(XXXX@XXX.XX)");
                    nk2 = scan.nextLine().split(" ");
                    if (chekUser(nk2)) {
                        break;
                    } else {
                        System.out.println("Incorrect info");
                        System.out.println("Please re-enter info");
                    }

                }

                seller = new User(nk2[0], false, nk2[2], nk2[1], nk2[3]);
                int count = 0;
                System.out.println("Number of all products: ");
                count = scan.nextInt();
                scan.nextLine();
                products = new Product[count];
                String[] nk3;
                for (int j = 0; j < count; j++) {
                    System.out.println("Enter info about product #" + (j + 1));
                    System.out.println("Name Price Quantity");
                    nk3 = scan.nextLine().split(" ");
                    if ("p1".equals(nk3[0])) {
                        products[j] = new Type1(nk3[0],Double.valueOf(nk3[1]),Integer.valueOf(nk3[2]));
                    } else if ("p2".equals(nk3[0])) {
                        products[j] = new Type2(nk3[0],Double.valueOf(nk3[1]),Integer.valueOf(nk3[2]));
                    } else if ("p3".equals(nk3[0])) {
                        products[j] = new Type3(nk3[0],Double.valueOf(nk3[1]),Integer.valueOf(nk3[2]));
                    } else {
                        products[j] = new Product(nk3[0],Double.valueOf(nk3[1]),Integer.valueOf(nk3[2]));
                    }
                }
                String dateDeal;
                while(true){
                    System.out.print("Deal date (dd-MM-yyyy|dd/MM/yyyy): ");
                     dateDeal = scan.nextLine();
                    if (TimeValidator.dateValidate(dateDeal)) {
                        break;
                    }
                }
                deals[i] = new Deal(buyer, seller, products, dateDeal);
                //deals[i].getDeal();
                //Можно показать сделку, можно просто написать сделка добавлена
                System.out.println("Deal added");
                i++;
            } else break;
        }
        // можно сделать меню, основываясь на не нулевых элементах массива deals и предлагать ввести номер сделки (Пример, создали 7,
        // проверили массив на не нулевые, узнали что их 7, предложили пользователю выбрать сделку 1-7)
        System.out.println("Would you like check|correct any deal? (1) - yes,(2) - exit");
        if (scan.nextInt() == 1) {
            scan.nextLine();
            for (int j = 0; j < deals.length; j++) {
                if (deals[j] != null) {
                    deals[j].getDeal();
                    System.out.println("Would you like check|correct this deal? (1) - yes,(2) - next deal");
                    if (scan.nextInt() == 1) {
                        while (true) {
                            System.out.println("Would you like? (1) - remove product,(2) - add product,(3) - calculate sum of deal, (4) - next deal");
                            int menu = scan.nextInt();
                            scan.nextLine();
                            if (menu == 1) {
                                System.out.println("The name of the product you want to remove ");
                                deals[j].removeProduct(scan.nextLine());
                                System.out.println("Product removed");
                            } else if (menu == 2) {
                                System.out.println("Enter info about product");
                                System.out.println("Name Price Quantity");
                                String[] nk3 = scan.nextLine().split(" ");
                                deals[j].addProduct(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]));
                                System.out.println("Product added");
                            } else if (menu == 3) {
                                System.out.println("Sum of deal: " + deals[j].getSumDeal());
                                System.out.println();
                                System.out.println();
                            } else if (menu == 4) {
                                break;
                            }
                            deals[j].getDeal();
                        }
                    }
                }
            }
            System.out.println("End of deals");
        }
        System.out.println("Thanks for deals");
        scan.close();
    }

    // Когда проверяю поля с помощью валидаторов повторно просить ввести данные если что-то неправильно введено
    public static boolean chekUser(String[] str) throws ParseException {
        if (str.length == 4 && str[0] != null && TimeValidator.dateValidate(str[2])
                && (new BelarusPhoneValidator().validate(str[1]) || new AmericanPhoneValidator().validate(str[1]))
                && emailValidator.validate(str[3])) {
            return true;
        } else {
            return false;
        }
    }
}
