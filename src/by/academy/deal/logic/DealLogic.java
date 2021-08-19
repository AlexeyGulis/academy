package by.academy.deal.logic;

import by.academy.deal.entities.*;
import by.academy.deal.services.BelarusPhoneValidator;
import by.academy.deal.services.TimeValidator;
import by.academy.deal.services.interfaces.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DealLogic {
    static Pattern date1 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static String format1 = "dd/MM/yyyy";
    static Pattern date2 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static String format2 = "dd-MM-yyyy";
    static Pattern email = Pattern.compile("^.*?@.*?\\..*$");
    //можно использовать второй метод на email
    //static Pattern email = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    static Deal[] deals;
    static Validator emailValidator;
    static Product[] products;
    static Product product;
    final static String[] availableProducts = {"Чай", "Персик", "Чипсы"};
    public static Scanner scan = new Scanner(System.in);
    static User[] users = new User[2];
    static LocalDate dateOfDeal;
    static LocalDate dateOfBirth;

    public DealLogic(int i) {
        deals = new Deal[i];
    }

    public void startDeals() {
        for (int i = 0; i < deals.length; i++) {

        }
    }
    public void createDeal(){

    }

    public static void createUser(boolean isBuyer) {
        String[] nk1 = new String[4];
        while (true) {
            System.out.println("Введите имя");
            nk1[0] = scan.nextLine();
            System.out.println("Введите номер телефона (Формат:+375-**-***-**-** где * - цифра)");
            nk1[1] = scan.nextLine();
            System.out.println("Введите дату рождения (Формат:dd-MM-yyyy или dd/MM/yyyy)");
            nk1[2] = scan.nextLine();
            System.out.println("Введите электронную почту(Формат: *@*.* где * - n-ое количество знаков)");
            nk1[3] = scan.nextLine();
            if (chekUser(nk1)) {
                break;
            } else {
                System.out.println("Пожалуйста повторите ввод");
            }
        }
        if (isBuyer) {
            users[0] = new User(nk1[0], isBuyer, dateOfBirth, nk1[1], nk1[3]);
        } else {
            users[1] = new User(nk1[0], isBuyer, dateOfBirth, nk1[1], nk1[3]);
        }
    }

    public static boolean chekUser(String[] str) {
        boolean result = false;
        if (str.length == 4 && str[0] != null
                && new BelarusPhoneValidator().validate(str[1])
                && emailValidator.validate(str[3])) {
            StringBuilder strb = new StringBuilder();
            if (TimeValidator.dateValidate(str[2], format1, date1)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format1);
                dateOfBirth = LocalDate.parse(str[2], formatter);
                strb.append("День: <").append(dateOfBirth.getDayOfMonth())
                        .append(">, Месяц: <").append(dateOfBirth.getMonthValue())
                        .append(">, Год: <").append(dateOfBirth.getYear()).append(">");
                System.out.println(strb);
                result = true;
            } else if (TimeValidator.dateValidate(str[2], format2, date2)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format2);
                dateOfBirth = LocalDate.parse(str[2], formatter);
                strb.append("День: <").append(dateOfBirth.getDayOfMonth())
                        .append(">, Месяц: <").append(dateOfBirth.getMonthValue())
                        .append(">, Год: <").append(dateOfBirth.getYear()).append(">");
                System.out.println(strb);
                result = true;
            } else {
                System.out.println("Дата введена неправильно");
            }
        } else {
            result = false;
        }
        return result;
    }

    public static Product createProduct() {
        String nk3[] = new String[5];
        Product product;
        while (true) {
            System.out.println("Введите информацию о продукте");
            System.out.println("Доступные продкуты:");
            for (String str : availableProducts
            ) {
                System.out.println(str);
            }
            System.out.println("Введите название продукта");
            nk3[0] = scan.nextLine();
            System.out.println("Введите ценну продукта");
            nk3[1] = scan.nextLine();
            System.out.println("Введите колличество продукта");
            nk3[2] = scan.nextLine();
            if (availableProducts[0].equals(nk3[0])) {
                System.out.println("Введите тип чая");
                nk3[3] = scan.nextLine();
                System.out.println("Введите количество пакетиков");
                nk3[4] = scan.nextLine();
                try {
                    Double.valueOf(nk3[1]);
                    Integer.valueOf(nk3[2]);
                    Integer.valueOf(nk3[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Некоректные данные");
                    continue;
                }
                product = new Tea(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]), Integer.valueOf(nk3[4]), nk3[3]);
                break;
            } else if (availableProducts[1].equals(nk3[0])) {
                System.out.println("Введите тип персиков");
                nk3[3] = scan.nextLine();
                System.out.println("Введите возраст персиков(количество дней)");
                nk3[4] = scan.nextLine();
                try {
                    Double.valueOf(nk3[1]);
                    Integer.valueOf(nk3[2]);
                    Double.valueOf(nk3[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Некоректные данные");
                    continue;
                }
                product = new Peach(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]), Double.valueOf(nk3[4]), nk3[3]);
                break;
            } else if (availableProducts[2].equals(nk3[0])) {
                System.out.println("Введите название чипсов");
                nk3[3] = scan.nextLine();
                System.out.println("Введите с каким вкусом");
                nk3[4] = scan.nextLine();
                try {
                    Double.valueOf(nk3[1]);
                    Integer.valueOf(nk3[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Некоректные данные");
                    continue;
                }
                product = new Chips(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]), nk3[3], nk3[4]);
                break;
            } else {
                System.out.println("Продукт с таким названием не доступен");
            }
        }
        return product;
    }

}
