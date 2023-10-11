package com.example.musiceventsystem.domain;

public class EventPlanner {
    private String plannerId;
    private String email;
    private String phone;
    private String username;
    private String password;

    public EventPlanner(String plannerId, String email, String phone, String username, String password) {
        this.plannerId = plannerId;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(String plannerId) {
        this.plannerId = plannerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EventPlanner{" +
                "plannerId='" + plannerId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
