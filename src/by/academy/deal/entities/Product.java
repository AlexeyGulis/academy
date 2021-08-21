package by.academy.deal.entities;

import java.io.Serializable;

public abstract class Product implements Serializable{
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

    public abstract String[] getFeature();

    public double getSumPrice() {
        return (1.0 - getDiscount()) * price * quantity;
    }

    @Deprecated
    public void test(){
        System.out.println("Nothing");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Название продукта = '").append(name).append('\'');
        sb.append(", Цена = ").append(price);
        sb.append(", Количество = ").append(quantity);
        sb.append(", Общая цена = ").append(getSumPrice());
        sb.append('}');
        return sb.toString();
    }
}
