package by.academy.homework.hmwk3;

import java.util.Date;

public class Peach extends Product {
    static private double ageDis = 5.0;
    static private String typeDis = "Frost";
    private String type;
    private double age;
    private double discount = 0.15;

    public Peach(String name, double price, int quantity, double age, String type) {
        super(name, price, quantity);
        this.type = type;
        this.age = age;
    }

    protected double getDiscount() {
        if (age >= ageDis && typeDis.equals(type)) {
            return discount;
        }
        return 0.0;
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
        sb.append("{Product name = '").append(getName()).append('\'');
        sb.append(", type = ").append(getType());
        sb.append(", age = ").append(getAge());
        sb.append(", price (included disquantity) = ").append(getPrice());
        sb.append(", quantity = ").append(getQuantity());
        sb.append(", sumPrice = ").append(getSumPrice());
        sb.append('}');
        return sb.toString();
    }
}
