package by.academy.homework.hmwk3;

public class Type2 extends Product {
    private double discount = 0.15;

    public Type2(String name, double price, int quantity) {
        super(name, price, quantity);
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
