package by.academy.deal.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static by.academy.deal.logic.DealLogic.scan;

public class Deal {
    private List<Product> productsList;
    private User seller;
    private User buyer;
    private LocalDate dateOfDeal;
    private LocalDate deadlineDate;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Deal(User buyer, User seller, List<Product> productsList, LocalDate dateOfDeal) {
        this.seller = seller;
        this.buyer = buyer;
        this.productsList = productsList;
        this.dateOfDeal = dateOfDeal;
        LocalDate currentDate = LocalDate.now();
        deadlineDate = currentDate.plusDays(10L);
    }

    public void getDealList() {
        StringBuilder str = new StringBuilder();
        str.append(seller);
        System.out.println(str);
        str.setLength(0);
        str.append(buyer);
        System.out.println(str);
        System.out.println("Таблица продуктов:");
        for (Product p : productsList
        ) {
            if (p != null) System.out.println(p);
        }
        str.setLength(0);
        str.append("Дата сделки: ");
        str.append(dateOfDeal.format(formatter)).append(";");
        System.out.println(str);
    }


    public String[] getPriceListOfDealList() {
        List<String> list = new ArrayList<>();
        System.out.println();
        Formatter f = new Formatter();
        f.format("%1$-25s%2$30s", "Дата:", dateOfDeal.format(formatter));
        list.add(f.toString());
        System.out.println(f);
        System.out.println();
        f = new Formatter();
        f.format("%1$-10s%2$-25s%3$-10s%4$10s", "Продукт", "Характеристики продукта", "Количество", "Цена");
        list.add(f.toString());
        System.out.println(f);
        System.out.println();

        System.out.println("-------------------------------------------------------");
        for (Product p : productsList
        ) {
            if (p != null) {
                f = new Formatter();
                System.out.println();
                f.format("%1$-10s%2$-25s%3$-10s%4$10s", p.getName(), p.getFeature()[0] + ", " + p.getFeature()[1], p.getQuantity(), String.format("%.2f", p.getSumPrice()) + " $");
                list.add(f.toString());
                System.out.println(f);
            }
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println();
        f = new Formatter();
        f.format("%1$-30s%2$25s", "Сумма сделки:", String.format("%.2f", this.getSumDealList()) + " $");
        list.add(f.toString());
        System.out.println(f);
        System.out.println();
        return list.toArray(new String[list.size()]);
    }

    public void getReversePriceListOfDealList() {
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
        for (int i = productsList.size() - 1; i >= 0 ; i--) {
            if (productsList.get(i) != null){
                f = new Formatter();
                System.out.println();
                f.format("%1$-10s%2$-25s%3$-10s%4$10s", productsList.get(i).getName(), productsList.get(i).getFeature()[0] + ", " + productsList.get(i).getFeature()[1], productsList.get(i).getQuantity(), String.format("%.2f", productsList.get(i).getSumPrice()) + " $");
                System.out.println(f);
            }
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println();
        f = new Formatter();
        f.format("%1$-30s%2$25s", "Сумма сделки:", String.format("%.2f", this.getSumDealList()) + " $");
        System.out.println(f);
        System.out.println();
    }

    public void addProductToDealList(Product product) {
        productsList.add(product);
    }

    public void removeProductFromDealList(String name) {
        int index = 0;
        for (Product p : productsList
        ) {
            if (p != null && p.getName().equals(name)) {
                System.out.println(p);
                System.out.println("Удалить - 1, Не удалять - все остальное");
                String str = scan.nextLine();
                if (str.equals("1")) {
                    System.out.println("Продукт " + name + " удален");
                    productsList.remove(index);
                    break;
                } else {
                    index++;
                    continue;
                }
            }
            index++;
        }
    }

    public double getSumDealList() {
        double sumdeal = 0.0;
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i) != null) {
                sumdeal += productsList.get(i).getSumPrice();
            }
        }
        return sumdeal;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
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

    public void sortProductList(){
        Collections.sort(productsList, new Comparator() {
            public int compare(Object obj1, Object obj2) {
                return ((Product) obj1).getName()
                        .compareTo(((Product) obj2).getName());
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deal deal = (Deal) o;

        if (productsList != null ? !productsList.equals(deal.productsList) : deal.productsList != null) return false;
        if (seller != null ? !seller.equals(deal.seller) : deal.seller != null) return false;
        if (buyer != null ? !buyer.equals(deal.buyer) : deal.buyer != null) return false;
        if (dateOfDeal != null ? !dateOfDeal.equals(deal.dateOfDeal) : deal.dateOfDeal != null) return false;
        return deadlineDate != null ? deadlineDate.equals(deal.deadlineDate) : deal.deadlineDate == null;
    }

    @Override
    public int hashCode() {
        int result = productsList != null ? productsList.hashCode() : 0;
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + (dateOfDeal != null ? dateOfDeal.hashCode() : 0);
        result = 31 * result + (deadlineDate != null ? deadlineDate.hashCode() : 0);
        return result;
    }
}