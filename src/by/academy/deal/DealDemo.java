package by.academy.deal;

import by.academy.deal.logic.DealLogic;
import by.academy.deal.services.interfaces.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealDemo {
    static Pattern email = Pattern.compile("^.*?@.*?\\..*$");
    static public Validator emailValidator;

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
        deals.startDeals();
    }
}
