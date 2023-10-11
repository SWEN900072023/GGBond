package com.example.musiceventsystem.service;

import com.example.musiceventsystem.dto.AdminDto;
//import com.example.musiceventsystem.dto.AdminRegistrationDto; // Add import for registration DTO if needed

public interface AdminService {
    AdminDto login(String username, String password);

    // Add additional methods if needed, e.g., for registration
    // void registerAdmin(AdminRegistrationDto adminRegistrationDto);
}
