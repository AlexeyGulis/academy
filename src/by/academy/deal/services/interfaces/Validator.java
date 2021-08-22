package by.academy.deal.services.interfaces;

import by.academy.deal.services.exceptions.ParseException;

public interface Validator {
    boolean validate(String t) throws ParseException;
}
