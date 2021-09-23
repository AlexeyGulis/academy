package by.academy.classwork.lesson18.entity;

import java.util.List;

public class Order {
    private String orderNo;
    public List<OrderItem> orderItemList;
    public Order(List<OrderItem> orderItemList){
        this.orderItemList = orderItemList;
    }
}
