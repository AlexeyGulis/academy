package by.academy.classwork.lesson18.entity;

import by.academy.classwork.lesson18.service.Payment;

import java.util.Date;

public class DebitCard implements Payment {
    private String issuer;
    private Long cardNo;
    private Date expiryDate;

    @Override
    public boolean authorise(double amount) {
        return false;
    }
}
