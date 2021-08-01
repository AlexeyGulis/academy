package by.academy.deal;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSellerOrbuyer(boolean sellerOrbuyer) {
        this.sellerOrbuyer = sellerOrbuyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (sellerOrbuyer != user.sellerOrbuyer) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return dateOfBirth != null ? dateOfBirth.equals(user.dateOfBirth) : user.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sellerOrbuyer ? 1 : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (sellerOrbuyer) {
            str.append("Имя продовца - ").append(name).append(", ");
            str.append("Дата рождения - ").append(dateOfBirth.format(Deal.formatter)).append(", ");
            str.append("Номер телефона - ").append(phone).append(", ");
            str.append("Электронный ящик - ").append(email).append(";");
        } else {
            str.append("Имя покупателя - ").append(name).append(", ");
            str.append("Дата рождения - ").append(dateOfBirth.format(Deal.formatter)).append(", ");
            str.append("Номер телефона - ").append(phone).append(", ");
            str.append("Электронный ящик - ").append(email).append(";");
        }
        return str.toString();
    }
}

