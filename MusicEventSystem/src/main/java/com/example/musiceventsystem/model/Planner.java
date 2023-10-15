package com.example.musiceventsystem.model;

public class Planner extends WebUser{

    public Planner(String username, String password, String name, String telephone) {
        super(username, password, name, telephone);
    }

    public Planner(Integer id, String username, String password, String name, String telephone) {
        super(id, username, password, name, telephone);
    }
}
