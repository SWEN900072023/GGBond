package com.example.musiceventsystem.domain;

import java.util.Date;

public class Order {
    private String orderId;
    private String customerId;
    private String eventId;
    private Date orderDate;
    private int quantity;
    private double totalPrice;

    public Order(String orderId, String customerId, String eventId, Date orderDate, int quantity, double totalPrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.eventId = eventId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
