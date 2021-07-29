package by.academy.homework.hmwk3;

public class User {
    private String name;
    private boolean sellerOrbuyer;
    private String dateOfbirth;
    private String phone;
    private String email;

    User(String name, boolean sellerOrbuyer, String dateOfbirth, String phone, String email) {
        this.name = name;
        this.sellerOrbuyer = sellerOrbuyer;
        this.dateOfbirth = dateOfbirth;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
        } else {
            str.append("Seller name - ").append(name).append(", ");
            str.append("Date of birth - ").append(dateOfbirth).append(", ");
            str.append("Phone - ").append(phone).append(", ");
            str.append("Email - ").append(email).append(";");
        }
        return str.toString();
    }
}

