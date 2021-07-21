package by.academy.homework.hmwk3;

public class Product {
    private String name;
    private double price;
    private int count;
    Product(String name,double price,int count){
        this.name = name;
        this.price = price;
        this.count = count;
    }
    public double getPrice() {
        return price*count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Product name = '").append(name).append('\'');
        sb.append(", count = ").append(count);
        sb.append(", price = ").append(price);
        sb.append('}');
        return sb.toString();
    }
}
