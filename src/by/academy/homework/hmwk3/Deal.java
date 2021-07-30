package by.academy.homework.hmwk3;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class Deal {
    private Product[] products;
    private User seller;
    private User buyer;
    private LocalDate dateOfDeal;
    Calendar deadlineDate;

    public Deal(User buyer, User seller, Product[] products, LocalDate dateOfDeal) {
        this.seller = seller;
        this.buyer = buyer;
        this.products = products;
        this.dateOfDeal = dateOfDeal;
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
        System.out.println("Таблица продуктов:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
        str.setLength(0);
        str.append("Дата сделки: ");
        str.append(dateOfDeal).append(";");
        System.out.println(str.toString());
    }

    public void getPriceList() {
        System.out.println();
        Formatter f = new Formatter();
        f.format("%1$-25s%2$30s", "Дата:", dateOfDeal);
        System.out.println(f);
        System.out.println();
        f = new Formatter();
        f.format("%1$-10s%2$-25s%3$-10s%4$10s", "Продукт", "Характеристики продукта", "Количество", "Цена");
        System.out.println(f);
        System.out.println();

        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < products.length; i++) {
            f = new Formatter();
            System.out.println();
            f.format("%1$-10s%2$-25s%3$-10s%4$10s", products[i].getName(), products[i].getFeature()[0] + ", " + products[i].getFeature()[1], products[i].getQuantity(), products[i].getSumPrice() + " $");
            System.out.println(f);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println();
        f = new Formatter();
        f.format("%1$-30s%2$25s", "Сумма сделки:", this.getSumDeal() + " $");
        System.out.println(f);
        System.out.println();
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
            boolean flag = false;
            int[] remProdInd = new int[products.length];
            for (int i = 0; i < products.length; i++) {
                remProdInd[i] = 0;
            }
            int countRemProd = 0;
            for (int i = 0; i < products.length; i++) {
                if (name.equals(products[i].getName())) {
                    flag = true;
                    remProdInd[i] = 1;
                    countRemProd++;
                }
            }
            if (flag) {
                int j = 0;
                int menuRemove = 0;
                while (true) {
                    System.out.println("Выберите вариант: (1) - Удалить i-ый продукт, (2) - Удалить все названные продукты");
                    menuRemove = DealDemo.scan.nextInt();
                    DealDemo.scan.nextLine();
                    if (menuRemove == 1) {
                        for (int i = 0; i < remProdInd.length; i++) {
                            if (remProdInd[i] == 1) {
                                System.out.println("Номер " + i + "  " + products[i]);
                            }
                        }
                        System.out.println("Выберите номер продукта");
                        j = DealDemo.scan.nextInt();
                        DealDemo.scan.nextLine();
                        Product[] temp = new Product[products.length - 1];
                        int index = 0;
                        for (int i = 0; i < products.length; i++) {
                            if (j != i) {
                                temp[index++] = products[i];
                            }
                        }
                        products = temp;
                        break;
                    } else if (menuRemove == 2) {
                        Product[] temp = new Product[products.length - countRemProd];
                        int index = 0;
                        for (int i = 0; i < products.length; i++) {
                            if (remProdInd[i] != 1) {
                                temp[index++] = products[i];
                            }
                        }
                        products = temp;
                        break;
                    }
                }
            } else {
                System.out.println("Продукта с таким именем не существует");
            }

        } else {
            System.out.println("Продукта с таким именем не существует");
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
