package com.example.musiceventsystem.service;

import com.example.musiceventsystem.datasource.AdminMapper;
import com.example.musiceventsystem.model.Admin;
import com.example.musiceventsystem.dto.AdminDto;
import redis.clients.jedis.Jedis;

public class AdminService {
    private AdminMapper adminMapper = new AdminMapper();

    public  AdminDto login(String username, String password) {
        //1. search username in the database
        //2. if return is null, username is not correct
        //3. if return isn't null, determine whether the password is correct
        Admin admin = this.adminMapper.findByUsername(username);
        AdminDto adminDto = new AdminDto();
        if(admin == null){
            adminDto.setCode(-1);
        } else {
            if(!admin.getPassword().equals(password)){
                adminDto.setCode(-2);
            }else {
                adminDto.setCode(0);
                adminDto.setAdmin(admin);
            }
        }
        return adminDto;
    }
}
