package com.example.musiceventsystem.model;

import java.sql.Timestamp;

public class Order {
    private Integer id;
    private Integer customerId;
    private Integer ticketId;
    private Integer eventId;
    private String eventName;
    private String section;
    private Integer price;
    private Integer num;
    private Timestamp  time;

    public Order(Integer customerId, Integer ticketId, Integer eventId, String eventName, String section, Integer price, Integer num) {
        this.customerId = customerId;
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.eventName = eventName;
        this.section = section;
        this.price = price;
        this.num = num;
    }

    public Order(Integer id, Integer customerId, Integer ticketId, Integer eventId, String eventName, String section, Integer price, Integer num, Timestamp time) {
        this.id = id;
        this.customerId = customerId;
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.eventName = eventName;
        this.section = section;
        this.price = price;
        this.num = num;
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp  time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
