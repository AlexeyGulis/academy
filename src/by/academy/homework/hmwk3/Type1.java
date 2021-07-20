package by.academy.homework.hmwk3;

public class Type1 extends Product{
    double discount = 0.25;
    Type1(String name,double price,int count){
        super(name,price,count);
    }

    @Override
    public double getPrice() {
        return super.getPrice()*discount;
    }
}

