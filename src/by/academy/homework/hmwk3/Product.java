package by.academy.homework.hmwk3;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price * (1 - getDiscount());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected abstract double getDiscount();

    public double getSumPrice() {
        return (1.0 - getDiscount()) * price * quantity;
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
