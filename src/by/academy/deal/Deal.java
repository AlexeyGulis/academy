package by.academy.deal;

import by.academy.deal.entities.Product;
import by.academy.deal.entities.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class Deal {
    private List<Product> productsTest;
    private Product[] products;
    private User seller;
    private User buyer;
    private LocalDate dateOfDeal;
    private LocalDate deadlineDate;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Deal(User buyer, User seller, Product[] products, LocalDate dateOfDeal) {
        this.seller = seller;
        this.buyer = buyer;
        productsTest = new ArrayList<>(Arrays.asList(products));
        this.products = products;
        this.dateOfDeal = dateOfDeal;
        LocalDate currentDate = LocalDate.now();
        deadlineDate = currentDate.plusDays(10L);
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
        str.append(dateOfDeal.format(formatter)).append(";");
        System.out.println(str.toString());
    }

    public void getPriceList() {
        System.out.println();
        Formatter f = new Formatter();
        f.format("%1$-25s%2$30s", "Дата:", dateOfDeal.format(formatter));
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
            f.format("%1$-10s%2$-25s%3$-10s%4$10s", products[i].getName(), products[i].getFeature()[0] + ", " + products[i].getFeature()[1], products[i].getQuantity(), String.format("%.2f", products[i].getSumPrice()) + " $");
            System.out.println(f);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println();
        f = new Formatter();
        f.format("%1$-30s%2$25s", "Сумма сделки:", String.format("%.2f", this.getSumDeal()) + " $");
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

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public LocalDate getDateOfDeal() {
        return dateOfDeal;
    }

    public void setDateOfDeal(LocalDate dateOfDeal) {
        this.dateOfDeal = dateOfDeal;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deal deal = (Deal) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(products, deal.products)) return false;
        if (seller != null ? !seller.equals(deal.seller) : deal.seller != null) return false;
        if (buyer != null ? !buyer.equals(deal.buyer) : deal.buyer != null) return false;
        if (dateOfDeal != null ? !dateOfDeal.equals(deal.dateOfDeal) : deal.dateOfDeal != null) return false;
        return deadlineDate != null ? deadlineDate.equals(deal.deadlineDate) : deal.deadlineDate == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(products);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + (dateOfDeal != null ? dateOfDeal.hashCode() : 0);
        result = 31 * result + (deadlineDate != null ? deadlineDate.hashCode() : 0);
        return result;
    }
}
