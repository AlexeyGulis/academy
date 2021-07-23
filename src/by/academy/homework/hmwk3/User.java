package by.academy.homework.hmwk3;

public class User {
    String name;
    boolean sellerOrbuyer;
    String dateOfbirth;
    String phone;
    String email;

    User(String name, boolean sellerOrbuyer, String dateOfbirth) {
        this.name = name;
        this.sellerOrbuyer = sellerOrbuyer;
        this.dateOfbirth = dateOfbirth;
    }

    User(String name, boolean sellerOrbuyer, String dateOfbirth, String phone, String email) {
        this.name = name;
        this.sellerOrbuyer = sellerOrbuyer;
        this.dateOfbirth = dateOfbirth;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public boolean isSellerOrbuyer() {
        return sellerOrbuyer;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (sellerOrbuyer) {
            str.append("Buyer name - ").append(name).append(", ");
            str.append("Date of birth - ").append(dateOfbirth).append(", ");
            str.append("Phone - ").append(phone).append(", ");
            str.append("Email - ").append(email).append(";");
            return str.toString();
        } else {
            str.append("Seller name - ").append(name).append(", ");
            str.append("Date of birth - ").append(dateOfbirth).append(", ");
            str.append("Phone - ").append(phone).append(", ");
            str.append("Email - ").append(email).append(";");
            return str.toString();
        }
    }
}

