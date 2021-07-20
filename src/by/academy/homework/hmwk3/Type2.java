package by.academy.homework.hmwk3;

public class Type2 extends Product{
    double discount = 0.25;
    Type2(String name,double price,int count){
        super(name,price,count);
    }

    @Override
    public double getPrice() {
        return super.getPrice()*discount;
    }
}
