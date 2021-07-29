package by.academy.homework.hmwk3;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealDemo {
    //ПЕРЕДЕЛАТЬ:
    //поменять поля String date на LocalDate date
    //добавить распечатку чека (StringBuilder форматирование по столбцу)
    //добавить в методе removeProduct функциональность на удаление i-ого элемента или всех
    //static Pattern email = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    static Pattern email = Pattern.compile("^.*?@.*?\\..*$");
    static Deal[] deals = new Deal[20];
    static Validator emailValidator;
    static Product[] products;
    static Product product;
    final static String[] availableProducts = {"Tea", "Peach", "Chips"};
    static Scanner scan = new Scanner(System.in);
    static User[] users = new User[2];

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
                    }
                    System.out.println("Продукт добавлен");
                }
                String dateDeal;
                while (true) {
                    System.out.print("Дата сделки (Форма даты: dd-MM-yyyy|dd/MM/yyyy)");
                    dateDeal = scan.nextLine();
                    if (TimeValidator.dateValidate(dateDeal)) {
                        break;
                    }
                }
                deals[i] = new Deal(users[0], users[1], products, dateDeal);
                //deals[i].getDeal();
                //Можно показать сделку, можно просто написать сделка добавлена
                System.out.println("Сделка добавлена");
                i++;
            } else break;
        }
        // можно сделать меню, основываясь на не нулевых элементах массива deals и предлагать ввести номер сделки (Пример, создали 7,
        // проверили массив на не нулевые, узнали что их 7, предложили пользователю выбрать сделку 1-7)
        System.out.println("Выберите вариант: (1) - Проверить сделки,(2) - Напечатать чеки всех сделок");
        if (scan.nextInt() == 1) {
            scan.nextLine();
            for (int j = 0; j < deals.length; j++) {
                if (deals[j] != null) {
                    deals[j].getDeal();
                    System.out.println("Выберите вариант: (1) - Зайти в меню сделки,(2) - Перейти к следующей сделке");
                    if (scan.nextInt() == 1) {
                        while (true) {
                            System.out.println("Выберите вариант: (1) - Удалить продукт,(2) - Добавить продукт,(3) - Высчитать сумму сделки, (4) - Перейти к следующей сделке, (5) - Напечатать чек");
                            int menu = scan.nextInt();
                            scan.nextLine();
                            if (menu == 1) {
                                deals[j].getDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                System.out.println("Введите название продукта, который вы хотите удалить");
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
                                deals[j].removeProduct(scan.nextLine());
                                System.out.println("Продукт удален");
                            } else if (menu == 2) {
                                deals[j].getDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||");
                                product = createProduct();
                                if (product != null) {
                                    deals[j].addProduct(product);
                                }
                                System.out.println("Продукт добавлен");
                            } else if (menu == 3) {
                                deals[j].getDeal();
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||");
                                System.out.println("Сумма сделки: " + deals[j].getSumDeal());
                                System.out.println("|||||||||||||||||||||||||||||||||||||||||||");
                                System.out.println();
                            } else if (menu == 4) {
                                break;
                            }

                        }
                    }
                }
            }
            System.out.println("Сделки закончились");
        }
        System.out.println("Спасибо за сделки");
        scan.close();
    }

    public static void createUser(boolean isBuyer) {
        String[] nk1 = new String[4];
        while (true) {
            System.out.println("Введите имя");
            nk1[0] = scan.nextLine();
            System.out.println("Введите номер телефона (Формат:+375-**-***-**-**)");
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
            users[0] = new User(nk1[0], isBuyer, nk1[2], nk1[1], nk1[3]);
        } else {
            users[1] = new User(nk1[0], isBuyer, nk1[2], nk1[1], nk1[3]);
        }
    }

    // Когда проверяю поля с помощью валидаторов повторно просить ввести данные если что-то неправильно введено
    public static boolean chekUser(String[] str) {
        boolean result;
        if (str.length == 4 && str[0] != null && TimeValidator.dateValidate(str[2])
                && new BelarusPhoneValidator().validate(str[1])
                && emailValidator.validate(str[3])) {
            result = true;
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
                product = new Tea(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]), Integer.valueOf(nk3[4]), nk3[3]);
                break;
            } else if (availableProducts[1].equals(nk3[0])) {
                System.out.println("Введите тип персиков");
                nk3[3] = scan.nextLine();
                System.out.println("Введите возраст персиков");
                nk3[4] = scan.nextLine();
                product = new Peach(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]), Double.valueOf(nk3[4]), nk3[3]);
                break;
            } else if (availableProducts[2].equals(nk3[0])) {
                System.out.println("Введите название чипсов");
                nk3[3] = scan.nextLine();
                System.out.println("Введите с каким фкусом");
                nk3[4] = scan.nextLine();
                product = new Chips(nk3[0], Double.valueOf(nk3[1]), Integer.valueOf(nk3[2]), nk3[3], nk3[4]);
                break;
            } else {
                System.out.println("Продукт с таким названием не доступен");
            }
        }
        return product;
    }

}
