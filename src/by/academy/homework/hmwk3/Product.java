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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
