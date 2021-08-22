package by.academy.deal;

import by.academy.deal.entities.Chips;
import by.academy.deal.entities.Peach;
import by.academy.deal.entities.Product;
import by.academy.deal.entities.Tea;
import by.academy.deal.logic.DealLogic;
import by.academy.deal.services.interfaces.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealDemo {
    static public Pattern email = Pattern.compile("^.*?@.*?\\..*$");
    static public Validator emailValidator;
    static public String[] us1 = {"Name1", "+375-29-123-32-12", "02-10-1992", "abc@bss.by"};
    static public String[] us2 = {"Name2", "+375-29-333-31-32", "15-06-1996", "ccc@aass.bcy"};
    static private List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Сделка");
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

        DealLogic deals = new DealLogic();
        deals.startDeals(us1,us2,createProductList());
    }
    private static List<Product> createProductList() {
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
        return productList;
    }
}
