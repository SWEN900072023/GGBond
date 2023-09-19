package com.example.musiceventsystem.model;

public class Customer extends WebUser{

    public Customer(String username, String password, String name, String telephone) {
        super(username,password,name,telephone);
    }

    public Customer(Integer id, String username, String password, String name, String telephone) {
        super(id, username, password, name, telephone);
    }
}
