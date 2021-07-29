package by.academy.homework.hmwk3;

import java.util.Date;

public class Chips extends Product {
    private String nameDis = "Lays";
    private String tasteDis = "Cheese";
    private String name;
    private String taste;
    private double discount = 0.05;

    public Chips(String name, double price, int quantity, String nameChips, String taste) {
        super(name, price, quantity);
        this.name = nameChips;
        this.taste = taste;
    }

    protected double getDiscount() {
        double result = 0.0;
        if (nameDis.equals(name) && tasteDis.equals(taste)) {
            result = discount;
        }
        return result;
    }

    public String getNameChips() {
        return name;
    }

    public void setNameChips(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void settaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Имя продукта = '").append(getName()).append('\'');
        sb.append(", Название чипсов = ").append(getNameChips());
        sb.append(", Вкус чипсов = ").append(getTaste());
        sb.append(", Цена (включая скидку) = ").append(String.format("%.2f",getPrice()));
        sb.append(", Количество = ").append(getQuantity());
        sb.append(", Общая цена = ").append(String.format("%.2f",getSumPrice()));
        sb.append('}');
        return sb.toString();
    }
}
