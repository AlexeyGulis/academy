package by.academy.homework.hmwk3;

import java.util.Date;

public class Chips extends Product {
    private String nameDis = "Lays";
    private String typeDis = "with Cheese";
    private String name;
    private String type;
    private double discount = 0.05;

    public Chips(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    protected double getDiscount(){
        if(nameDis.equals(name) && typeDis.equals(type)){
            return discount;
        }
        return 0.0;
    }
    @Override
    public String getName() {
        return super.getName();
    }

    public int getQuantity() {
        return super.getQuantity();
    }

    public double getSumPrice() {
        return super.getSumPrice() - super.getSumPrice() * discount;
    }

    public double getPrice() {
        return super.getPrice() - super.getPrice() * discount;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Product name = '").append(getName()).append('\'');
        sb.append(", price (included disquantity) = ").append(getPrice());
        sb.append(", quantity = ").append(getQuantity());
        sb.append(", sumPrice = ").append(getSumPrice());
        sb.append('}');
        return sb.toString();
    }
}
