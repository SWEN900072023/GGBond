package com.example.musiceventsystem.service.impl;

import com.example.musiceventsystem.datasource.AdminMapper;
import com.example.musiceventsystem.domain.Admin;
import com.example.musiceventsystem.dto.AdminDto;
import com.example.musiceventsystem.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper = new AdminMapper();

    @Override
    public AdminDto login(String username, String password) {
        AdminDto adminDto = new AdminDto();

        // Step 1: Search for the admin by username
        Admin admin = adminMapper.getAdminByUsername(username);

        if (admin == null) {
            // Username is not correct
            adminDto.setCode(-1);
            return adminDto;
        }

        // Step 2: Check if the password is correct
        if (!admin.getPassword().equals(password)) {
            // Password is not correct
            adminDto.setCode(-2);
            return adminDto;
        }

        // Both username and password are correct
        adminDto.setCode(0);
        adminDto.setAdmin(admin);

        return adminDto;
    }
}
