package by.academy.deal;

import by.academy.deal.entities.*;
import by.academy.deal.services.BelarusPhoneValidator;
import by.academy.deal.services.TimeValidator;
import by.academy.deal.services.interfaces.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealDemo {

    static Pattern date1 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static String format1 = "dd/MM/yyyy";
    static Pattern date2 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static String format2 = "dd-MM-yyyy";
    static Pattern email = Pattern.compile("^.*?@.*?\\..*$");
    //можно использовать второй метод на email
    //static Pattern email = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    static Deal[] deals = new Deal[20];
    static Validator emailValidator;
    static Product[] products;
    static Product product;
    final static String[] availableProducts = {"Чай", "Персик", "Чипсы"};
    public static Scanner scan = new Scanner(System.in);
    static User[] users = new User[2];
    static LocalDate dateOfDeal;
    static LocalDate dateOfBirth;

    public static void main(String[] args) {
        System.out.println("Сделки");
        emailValidator = new Validator() {
            @Override
            public boolean validate(String t) {
                Matcher matcher = email.matcher(t);
                boolean result;
                if (matcher.find()) {
                    result = true;
                } else {
                    System.out.println("Неправильно введена электронная почта");
                    result = false;
                }
                return result;
            }
        };
        //Количество сделок неопределено, поэтому возьму значение 20, можно написать чтобы массив динамически расширялся (2хдлины) доходя до границы.
        int i = 0;
        while (i < 20) {
            System.out.println("Выберите вариант: (1) - Создать сделку,(2) - Зайти в меню сделок");
            if (scan.nextInt() == 1) {
                scan.nextLine();
                System.out.println("Информация о продавце");
                createUser(true);
                System.out.println("Информация о покупателе");
                createUser(false);
                int count = 0;
                System.out.println("Введите число продуктов: ");
                count = scan.nextInt();
                scan.nextLine();
                products = new Product[count];
                for (int j = 0; j < count; j++) {
                    product = createProduct();
                    if (product != null) {
                        products[j] = product;
                        product.test();
                    }
                    System.out.println("Продукт добавлен");
                }
                String dateDeal;
                while (true) {
                    System.out.print("Дата сделки (Форма даты: dd-MM-yyyy|dd/MM/yyyy)");
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
                deals[i] = new Deal(users[0], users[1], products, dateOfDeal);
                //deals[i].getDeal();
                //Можно показать сделку, можно просто написать сделка добавлена
                System.out.println("Сделка добавлена");
                i++;
            } else break;
        }
        // можно сделать меню, основываясь на не нулевых элементах массива deals и предлагать ввести номер сделки (Пример, создали 7,
        // проверили массив на не нулевые, узнали что их 7, предложили пользователю выбрать сделку 1-7)
        int menu;
        System.out.println("Выберите вариант: (1) - Проверить сделки,(2) - Напечатать чеки всех сделок, (3) - Выйти из программы");
        menu = scan.nextInt();
        scan.nextLine();
        int j = 0;
        if (menu == 1) {
            while (j < deals.length) {
                if (deals[j] != null) {
                    deals[j].getDeal();
                    System.out.println("Выберите вариант: (1) - Зайти в меню сделки,(2) - Перейти к следующей сделке,(3) - Перейти к предыдущей сделке, (4) - Напечатать все чеки и выйти из программы");
                    menu = scan.nextInt();
                    scan.nextLine();
                    if (menu == 1) {
                        while (true) {
                            System.out.println("Выберите вариант: (1) - Удалить продукт,(2) - Добавить продукт,(3) - Высчитать сумму сделки, (4) - Напечатать чек, " +
                                    "(5) - Перейти к следующей сделке, (6) - Перейти к предыдущей сделке, (7) - Выйти из меню");
                            menu = scan.nextInt();
                            scan.nextLine();
                            if (menu == 1) {
                                deals[j].getDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                System.out.println("Введите название продукта, который вы хотите удалить");
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                deals[j].removeProductFromDeal(scan.nextLine());
                                System.out.println("Продукт удален");
                            } else if (menu == 2) {
                                deals[j].getDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                product = createProduct();
                                if (product != null) {
                                    deals[j].addProductToDeal(product);
                                }
                                System.out.println("Продукт добавлен");
                            } else if (menu == 3) {
                                deals[j].getDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                System.out.println("Сумма сделки: " + deals[j].getSumDeal());
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                System.out.println();
                            } else if (menu == 4) {
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                deals[j].getPriceListOfDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            } else if (menu == 5 && j != deals.length - 1) {
                                j++;
                                break;
                            } else if (menu == 6 && j != 0) {
                                j--;
                                break;
                            } else if (menu == 7) {
                                break;
                            }
                        }
                    } else if (menu == 2 && j != deals.length - 1) {
                        j++;
                    } else if (menu == 3 && j != 0) {
                        j--;
                    } else if (menu == 4) {
                        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("Чеки");
                        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                        for (Deal a : deals
                        ) {
                            if (a != null) {
                                a.getPriceListOfDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            }
                        }
                        break;
                    }
                } else if (j == 0 || j == deals.length - 1) {
                    System.out.println("Сделки закончились");
                    break;
                } else {
                    j--;
                }
            }
            System.out.println("Сделки закончились");
        } else if (menu == 2) {
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("Чеки");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            for (Deal a : deals
            ) {
                if (a != null) {
                    a.getPriceListOfDeal();
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                }
            }
        }
        System.out.println("Спасибо");
        scan.close();
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

    // Когда проверяю поля с помощью валидаторов повторно просить ввести данные если что-то неправильно введено
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
