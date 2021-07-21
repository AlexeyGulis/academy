package by.academy.homework.hmwk3;

public class Type3 extends Product {
    double discount = 0.05;
    Type3(String name,double price,int count){
        super(name,price,count);
    }

    @Override
    public double getPrice() {
        return super.getPrice()-super.getPrice()*discount;
    }
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Product name = '").append(super.getName()).append('\'');
        sb.append(", count = ").append(super.getCount());
        sb.append(", price (included discount) = ").append(getPrice());
        sb.append('}');
        return sb.toString();
    }
}
