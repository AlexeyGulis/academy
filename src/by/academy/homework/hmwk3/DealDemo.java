package by.academy.homework.hmwk3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealDemo {
    //static Pattern email = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    static Pattern email = Pattern.compile("^.*?@.*?\\..*$");
    static Deal[] deals = new Deal[20];
    static Validator emailValidator;

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
        User user1;
        User user2;
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < 20) {
            System.out.println("Would you like to make a deal? (1) - yes,(2) - no");
            if (scan.nextInt() == 1) {
                scan.nextLine();
                String[] temp;
                System.out.println("Buyer information");
                System.out.println("Name Phone(+375XXXXXXX|+1XXXXXXX) Date of birth(dd-MM-yyyy|dd/mm/yyyy) Email(XXXX@XXX.XX)");
                String[] nk1 = scan.nextLine().split(" ");
                temp = chekUser(nk1);
                if (temp != null) {
                    nk1 = temp;
                } else {
                    System.out.println("Incorrect info");
                    continue;
                }
                user1 = new User(nk1[0], true, nk1[2], nk1[1], nk1[3]);
                System.out.println("Seller information");
                System.out.println("Name Phone(+375XXXXXXX|+1XXXXXXX) Date of birth(dd-MM-yyyy|dd/mm/yyyy) Email(XXXX@XXX.XX)");
                String[] nk2 = scan.nextLine().split(" ");
                temp = chekUser(nk2);
                if (temp != null) {
                    nk2 = temp;
                } else {
                    System.out.println("Incorrect info");
                    continue;
                }
                user2 = new User(nk2[0], false, nk2[2], nk2[1], nk2[3]);
                int count = 0;
                System.out.println("Count of all products: ");
                count = scan.nextInt();
                scan.nextLine();
                String[] nameproduct = new String[count];
                double[] price = new double[count];
                int[] countElem = new int[count];
                String[] nk3;
                for (int j = 0; j < nameproduct.length; j++) {
                    System.out.println("Enter products #" + (j + 1));
                    System.out.println("Name Price Count");
                    nk3 = scan.nextLine().split(" ");
                    nameproduct[j] = nk3[0];
                    price[j] = Double.valueOf(nk3[1]);
                    countElem[j] = Integer.valueOf(nk3[2]);
                }
                System.out.print("Date of deal (dd-MM-yyyy|dd/MM/yyyy): ");
                String dateDeal = scan.nextLine();
                if (!TimeValidator.dateValidate(dateDeal)) {
                    dateDeal = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                }
                deals[i] = new Deal(user1, user2, nameproduct, price, countElem, dateDeal);
                deals[i].getDeal();
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
                                System.out.println("Name removal product ");
                                deals[j].removeProduct(scan.nextLine());
                            } else if (menu == 2) {
                                System.out.println("Enter additional products");
                                System.out.println("Name Price Count");
                                String[] nk3 = scan.nextLine().split(" ");
                                deals[j].addProduct(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]));
                            } else if (menu == 3) {
                                System.out.println("Sum of deal: " + deals[j].getSumDeal());
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

    // Когда проверяю поля с помощью валидаторов можно просто повторно просить ввести данные или как на данный момент
// ввести в поля дефолтные значения
    public static String[] chekUser(String[] str) throws ParseException {
        if (str.length == 4) {
            if (str[0] == null) {
                str[0] = "NoName";
            }
            if (!TimeValidator.dateValidate(str[2])) {
                str[2] = "Date incorrect";
            }
            if (!(new BelarusPhoneValidator().validate(str[1])) || !(new AmericanPhoneValidator().validate(str[1]))) {
                str[1] = "Number incorrect";
            }
            if (!emailValidator.validate(str[3])) {
                str[3] = "Email incorrect";
            }
            return str;
        } else {
            return null;
        }
    }
}
