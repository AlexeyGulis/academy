package by.academy.classwork.lesson9;

import java.util.Comparator;
import java.util.TreeSet;

public class CompareDemo {
    public static void main(String[] args) {
        Comparator<Product> comparator = new Comparator<>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.equalsPrice(o2);
            }
        };
        TreeSet<Product> treeProduct = new TreeSet<>(comparator);
        treeProduct.add(new Product("Apple",3));
        treeProduct.add(new Product("Tea",10));
        treeProduct.add(new Product("Chips",-2));
        treeProduct.add(new Product("Milk",34));
        System.out.println(treeProduct.toString());
    }
}
