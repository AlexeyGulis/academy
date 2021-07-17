package by.academy.classwork.lesson5;

public class Product {
    String nice;
    double price;
    int quantity;

    public Product() {
    }

    public Product(String nice, double price, int quantity) {
        this.nice = nice;
        this.price = price;
        this.quantity = quantity;
    }

    public String getNice() {
        return nice;
    }

    public void setNice(String nice) {
        this.nice = nice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        return nice != null ? nice.equals(product.nice) : product.nice == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nice != null ? nice.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("nice='").append(nice).append('\'');
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
