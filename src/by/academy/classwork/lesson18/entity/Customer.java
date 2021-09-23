package by.academy.classwork.lesson18.entity;

import by.academy.classwork.lesson18.service.Payment;

import java.util.List;

public class Customer extends PrivilegedCustomer{
    private String name;
    List<Address> addressList;
    List<Payment> payments;
    List<Order> orders;
    public Customer(){
        super();
    }
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
    public void setPayments(List<Payment> payments){
        this.payments = payments;
    }
    public void setOrders(List<Order> orders){
        this.orders = orders;
    }
}
