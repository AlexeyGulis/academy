package by.academy.homework.hmwk3;

import java.util.Date;

public class Peach extends Product {
    static private double weightDis = 12.0;
    static private String typeDis = "Frost";
    private String type;
    private double weight;
    private double discount = 0.15;

    public Peach(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    protected double getDiscount(){
        if(weight>=weightDis && typeDis.equals(type)){
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
