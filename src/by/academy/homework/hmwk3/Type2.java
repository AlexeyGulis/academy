package by.academy.homework.hmwk3;

public class Type2 extends Product{
    double discount = 0.15;
    Type2(String name,double price,int count){
        super(name,price,count);
    }

    @Override
    public double getPrice() {
        return super.getPrice()-super.getPrice()*discount;
    }
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", price=").append(getPrice());
        sb.append(", count=").append(super.getCount());
        sb.append('}');
        return sb.toString();
    }
}
