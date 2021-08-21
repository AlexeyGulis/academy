package by.academy.deal.logic;

import by.academy.deal.entities.*;
import by.academy.deal.services.BelarusPhoneValidator;
import by.academy.deal.services.DealFile;
import by.academy.deal.services.TimeValidator;

import javax.imageio.IIOException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static by.academy.deal.DealDemo.emailValidator;

public class DealLogic {
    static private Pattern date1 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static private String format1 = "dd/MM/yyyy";
    static private Pattern date2 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static private String format2 = "dd-MM-yyyy";
    static private Deal deals;
    static private Product product;
    final static private String[] availableProducts = {"Чай", "Персик", "Чипсы"};
    static private List<Product> productList = new ArrayList<>();
    static public Scanner scan = new Scanner(System.in);
    static private User[] users = new User[2];
    static private LocalDate dateOfDeal;
    static private LocalDate dateOfBirth;

    public DealLogic() {
        createProductList();
    }

    public void startDeals() {
        String[] us1 = {"Name1", "+375-29-123-32-12", "02-10-1992", "abc@bss.by"};
        String[] us2 = {"Name2", "+375-29-333-31-32", "15-06-1996", "ccc@aass.bcy"};
        if (!createUser(us1, true) || !createUser(us2, false)) {
            System.out.println("Некорректно введены данные покупателя-продавца");
            return;
        }
        dateOfDeal();
        deals = new Deal(users[0], users[1], productList, dateOfDeal);
        deals.getDealList();
        menuDeal();
        System.out.println("Сделка завершена");
        scan.close();
    }

    private static void menuDeal() {
        System.out.println("Меню:");
        String menu;
        while (true) {
            System.out.println("Выберите вариант: (1) - Удалить продукт,(2) - Добавить продукт,");
            System.out.println("(3) - Высчитать сумму сделки, (4) - Отсортировать список продуктов по Имени,");
            System.out.println("(5) - Напечатать чек и выйти из меню,");
            System.out.println("(6) - Напечатать чек (список в обратном порядке) и выйти из меню,");
            System.out.println("(Все остальное) - Выйти из меню");
            menu = scan.nextLine();
            if (menu.equals("1")) {
                deals.getDealList();
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                System.out.println("Введите название продукта, который вы хотите удалить");
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                deals.removeProductFromDealList(scan.nextLine());
            } else if (menu.equals("2")) {
                deals.getDealList();
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                product = createProduct();
                if (product != null) {
                    deals.addProductToDealList(product);
                }
                System.out.println("Продукт добавлен");
            } else if (menu.equals("3")) {
                deals.getDealList();
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                System.out.println("Сумма сделки: " + String.format("%.2f", deals.getSumDealList()));
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                System.out.println();
            } else if (menu.equals("4")) {
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                deals.sortProductList();
                deals.getDealList();
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");

            } else if (menu.equals("5")) {
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                try{
                    DealFile.createFile(deals.getPriceListOfDealList(),deals.getDateOfDeal().toString());
                    System.out.println("Создан файл чека");
                }catch(IOException e){
                    System.out.println("Проблема с файлом");
                }
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                break;
            } else if (menu.equals("6")) {
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                deals.getReversePriceListOfDealList();
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                break;
            } else {
                break;
            }
        }
    }

    private static boolean createUser(String[] user, boolean isBuyer) {
        if (isBuyer) {
            if (checkUser(user)) {
                users[0] = new User(user[0], true, dateOfBirth, user[1], user[3]);
                System.out.println(users[0]);
                return true;
            } else {
                return false;
            }
        } else {
            if (checkUser(user)) {
                users[1] = new User(user[0], false, dateOfBirth, user[1], user[3]);
                System.out.println(users[1]);
                return true;
            } else {
                return false;
            }
        }
    }

    private static void dateOfDeal() {
        String dateDeal;
        while (true) {
            System.out.println("Дата сделки (Форма даты: dd-MM-yyyy|dd/MM/yyyy)");
            dateDeal = scan.nextLine();
            StringBuilder strb = new StringBuilder();
            if (TimeValidator.dateValidate(dateDeal, format1, date1)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format1);
                dateOfDeal = LocalDate.parse(dateDeal, formatter);
                strb.append("День: <").append(dateOfDeal.getDayOfMonth())
                        .append(">, Месяц: <").append(dateOfDeal.getMonthValue())
                        .append(">, Год: <").append(dateOfDeal.getYear()).append(">");
                System.out.println(strb);
                break;
            } else if (TimeValidator.dateValidate(dateDeal, format2, date2)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format2);
                dateOfDeal = LocalDate.parse(dateDeal, formatter);
                strb.append("День: <").append(dateOfDeal.getDayOfMonth())
                        .append(">, Месяц: <").append(dateOfDeal.getMonthValue())
                        .append(">, Год: <").append(dateOfDeal.getYear()).append(">");
                System.out.println(strb);
                break;
            } else {
                System.out.println("Дата введена неправильно");
            }
        }
    }

    private static boolean checkUser(String[] str) {
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

    private void createProductList() {
        Product chips1 = new Chips("Чипсы", 120.12, 5, "Лейс", "С сыром");
        Product chips2 = new Chips("Чипсы", 140.51, 2, "Эстрэлла", "Краб");
        Product chips3 = new Chips("Чипсы", 250, 2, "Принглз", "Чили");
        Product tea1 = new Tea("Чай", 45, 1, 50, "Черный");
        Product tea2 = new Tea("Чай", 25, 2, 20, "Китайский");
        Product peach1 = new Peach("Персик", 70, 2, 5, "Домашний");
        Product peach2 = new Peach("Персик", 110.95, 3, 9, "Кардинал");
        productList.add(chips1);
        productList.add(chips2);
        productList.add(chips3);
        productList.add(tea1);
        productList.add(peach1);
        productList.add(tea2);
        productList.add(peach2);
    }

    private static Product createProduct() {
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
