package by.academy.homework.hmwk3;

import java.util.Date;

public class Peach extends Product {
    protected static double ageDis = 5.0;
    protected static String typeDis = "Кардинал";
    protected String type;
    protected double age;
    protected double discount = 0.15;

    public Peach(String name, double price, int quantity, double age, String type) {
        super(name, price, quantity);
        this.type = type;
        this.age = age;
    }

    protected double getDiscount() {
        double result = 0.0;
        if (age >= ageDis && typeDis.equals(type)) {
            result = discount;
        }
        return result;
    }

    public String[] getFeature() {
        String[] prodFeature = new String[2];
        prodFeature[0] = type;
        prodFeature[1] = String.valueOf(age);
        return prodFeature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAge() {
        return age;
    }

    public void setage(double age) {
        this.age = age;
    }

    @Override

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Имя продукта = '").append(getName()).append('\'');
        sb.append(", Тип персика = ").append(getType());
        sb.append(", Возраст = ").append(getAge());
        sb.append(", Цена (включая скидку) = ").append(String.format("%.2f", getPrice()));
        sb.append(", Количество = ").append(getQuantity());
        sb.append(", Общая цена = ").append(String.format("%.2f", getSumPrice()));
        sb.append('}');
        return sb.toString();
    }
}
