package by.academy.homework.hmwk3;

public class User {
    String name;
    boolean sellerOrbuyer;
    String dateOfbirth;
    User(String name,boolean sellerOrbuyer,String dateOfbirth){
        this.name = name;
        this.sellerOrbuyer = sellerOrbuyer;
        this.dateOfbirth = dateOfbirth;
    }
    public String getName() {
        return name;
    }

    public boolean isSellerOrbuyer() {
        return sellerOrbuyer;
    }

    @Override
    public String toString() {
        if(sellerOrbuyer){
            return "Name seller - " + name + ", ";
        }else return "Name buyer - " + name + ", ";
    }
}
