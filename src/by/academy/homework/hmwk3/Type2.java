package by.academy.homework.hmwk3;

public class Type2 extends Product{
    double discount = 0.15;
    Type2(String name,double price,int count){
        super(name,price,count);
    }

    @Override
    public String getName(){
        return super.getName();
    }
    public int getCount() {
        return super.getCount();
    }
    public double getPrice() {
        return super.getPrice()-super.getPrice()*discount;
    }
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Product name = '").append(getName()).append('\'');
        sb.append(", count = ").append(getCount());
        sb.append(", price (included discount) = ").append(getPrice());
        sb.append('}');
        return sb.toString();
    }
}
