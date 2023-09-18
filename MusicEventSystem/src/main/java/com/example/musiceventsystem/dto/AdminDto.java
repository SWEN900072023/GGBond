package com.example.musiceventsystem.dto;

import com.example.musiceventsystem.model.Admin;

public class AdminDto {

    private Integer code;
    private Admin admin;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
