package by.academy.homework.hmwk7.task2;

import java.time.LocalDate;

public class User extends Person{
    public String login;
    private String password;
    public String email;

    public User(String firstName, String secondName, int age, LocalDate dateOfBirth, String login, String password, String email) {
        super(firstName, secondName, age, dateOfBirth);
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printUserInfo(){
        System.out.println("Login - " + login + "; Email - " + email);
    }
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
