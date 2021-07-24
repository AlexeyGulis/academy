package by.academy.homework.hmwk3;

public class Product {
    protected String name;
    protected double price;
    protected int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSumPrice() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Product name = '").append(name).append('\'');
        sb.append(", price = ").append(price);
        sb.append(", quantity = ").append(quantity);
        sb.append(", sumPrice = ").append(getSumPrice());
        sb.append('}');
        return sb.toString();
    }
}
