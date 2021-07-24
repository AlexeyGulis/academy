package by.academy.homework.hmwk3;

import java.util.Calendar;
import java.util.Date;

public class Deal {
    Product[] products;
    User seller;
    User buyer;
    String date;
    Calendar deadlineDate;

    public Deal(User buyer, User seller, Product[] products, String date) {
        this.seller = seller;
        this.buyer = buyer;
        this.products = products;
        this.date = date;
        Date currentDate = new Date();
        deadlineDate = Calendar.getInstance();
        deadlineDate.setTime(currentDate);
        deadlineDate.set(Calendar.DAY_OF_MONTH, +10);
    }

    public void getDeal() {
        StringBuilder str = new StringBuilder();
        str.append(seller);
        System.out.println(str.toString());
        str.setLength(0);
        str.append(buyer);
        System.out.println(str.toString());
        System.out.println("Table of products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
        str.setLength(0);
        str.append("Date of deal: ");
        str.append(date).append(";");
        System.out.println(str.toString());

    }

    public void addProduct(Product product) {
        Product[] temp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            temp[i] = products[i];
        }
        temp[products.length] = product;
        products = temp;
    }

    public void removeProduct(String name) {
        if (products.length != 0 && name != null) {
            Product[] temp = new Product[products.length - 1];
            int index_rem = -10;
            for (int i = 0; i < products.length; i++) {
                if (name.equals(products[i].getName())) {
                    index_rem = i;
                }
            }
            if (index_rem != -10) {
                int j = 0;
                for (int i = 0; i < products.length; i++) {
                    if (index_rem != i) {
                        temp[j] = products[i];
                        j++;
                    }
                }
                products = temp;
            } else {
                System.out.println("Product not exist with this name");
            }

        } else {
            System.out.println("Products not exist");
        }
    }

    public double getSumDeal() {
        double sumdeal = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                sumdeal += products[i].getSumPrice();
            }
        }
        return sumdeal;
    }

}
