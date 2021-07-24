package by.academy.homework.hmwk3;

import java.util.Calendar;
import java.util.Date;

public class Deal {
    Product[] products;
    User user1;
    User user2;
    String date;
    Calendar deadlineDate;

    Deal(User user1, User user2, String[] nameProduct, double[] price, int[] count, String date) {
        this.user1 = user1;
        this.user2 = user2;
        this.products = new Product[nameProduct.length];
        for (int i = 0; i < nameProduct.length; i++) {
            if ("p1".equals(nameProduct[i])) {
                products[i] = new Type1(nameProduct[i], price[i], count[i]);
            } else if ("p2".equals(nameProduct[i])) {
                products[i] = new Type2(nameProduct[i], price[i], count[i]);
            } else if ("p3".equals(nameProduct[i])) {
                products[i] = new Type3(nameProduct[i], price[i], count[i]);
            } else products[i] = new Product(nameProduct[i], price[i], count[i]);
        }
        this.date = date;
        Date currentDate = new Date();
        deadlineDate = Calendar.getInstance();
        deadlineDate.setTime(currentDate);
        deadlineDate.set(Calendar.DAY_OF_MONTH, +10);
    }
    public Deal(User buyer,User seller,Product[] products,String date){
        user1 = buyer;
        user2 = seller;
        this.products = products;
        this.date = date;
    }

    public void getDeal() {
        StringBuilder str = new StringBuilder();
        str.append(user1);
        System.out.println(str.toString());
        str.setLength(0);
        str.append(user2);
        System.out.println(str.toString());
        str.setLength(0);
        str.append("Date of deal: ");
        str.append(date);
        str.append(";");
        System.out.println(str.toString());
        System.out.println("Table of products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }

    }

    public void addProduct(String name, double price, int count) {
        Product[] temp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            temp[i] = products[i];
        }
        if ("p1".equals(name)) {
            temp[products.length] = new Type1(name, price, count);
        } else if ("p2".equals(name)) {
            temp[products.length] = new Type2(name, price, count);
        } else if ("p3".equals(name)) {
            temp[products.length] = new Type3(name, price, count);
        } else temp[products.length] = new Product(name, price, count);
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
                System.out.println("Product not available with this name");
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
