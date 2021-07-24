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
        if (nameDis.equals(name) && tasteDis.equals(taste)) {
            return discount;
        }
        return 0.0;
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
        sb.append("{Product name = '").append(getName()).append('\'');
        sb.append(", nameChips = ").append(getNameChips());
        sb.append(", taste = ").append(getTaste());
        sb.append(", price (included disquantity) = ").append(getPrice());
        sb.append(", quantity = ").append(getQuantity());
        sb.append(", sumPrice = ").append(getSumPrice());
        sb.append('}');
        return sb.toString();
    }
}
