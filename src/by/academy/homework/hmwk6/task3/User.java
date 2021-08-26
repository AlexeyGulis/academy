package by.academy.homework.hmwk6.task3;

import java.io.Serializable;

public class User implements Serializable{
    private String firstName;
    private String secondName;
    private int age;
    public User(String firstName,String secondName,int age){
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        return secondName != null ? secondName.equals(user.secondName) : user.secondName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
