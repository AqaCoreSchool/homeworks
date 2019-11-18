package com.burgerking;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static Integer idCounter = 0;
    private Integer orderId;
    private List<Food> orderItems;
    private Integer orderAmount;
    private Double orderPrice;
    private Boolean payed;
    private Boolean prepared;

    public Order() {
        idCounter++;
        this.orderId = idCounter;
        this.orderItems = new ArrayList<>();
        this.orderAmount = 0;
        this.orderPrice = 0.00;
        this.payed = false;
        this.prepared = false;
    }

    public static Integer getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(Integer idCounter) {
        Order.idCounter = idCounter;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Food> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Food> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public Boolean getPrepared() {
        return prepared;
    }

    public void setPrepared(Boolean prepared) {
        this.prepared = prepared;
    }

    public void addProduct(Food food){
//        to be done...
    }

    public void removeProduct(Food food){
//        to be done...
    }

    public void removeAll(){
//        to be done...
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItems=" + orderItems +
                ", orderAmount=" + orderAmount +
                ", orderPrice=" + orderPrice +
                ", payed=" + payed +
                ", prepared=" + prepared +
                '}';
    }
}
