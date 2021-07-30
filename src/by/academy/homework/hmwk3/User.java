package by.academy.homework.hmwk3;

import java.time.LocalDate;

public class User {
    private String name;
    private boolean sellerOrbuyer;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;

    User(String name, boolean sellerOrbuyer, LocalDate dateOfBirth, String phone, String email) {
        this.name = name;
        this.sellerOrbuyer = sellerOrbuyer;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
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
            str.append("Имя продовца - ").append(name).append(", ");
            str.append("Дата рождения - ").append(dateOfBirth).append(", ");
            str.append("Номер телефона - ").append(phone).append(", ");
            str.append("Электронный ящик - ").append(email).append(";");
        } else {
            str.append("Имя покупателя - ").append(name).append(", ");
            str.append("Дата рождения - ").append(dateOfBirth).append(", ");
            str.append("Номер телефона - ").append(phone).append(", ");
            str.append("Электронный ящик - ").append(email).append(";");
        }
        return str.toString();
    }
}

