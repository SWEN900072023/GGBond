package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.musiceventsystem.datasource.DBManage;

import com.example.musiceventsystem.domain.Admin; // Import the correct Admin class

public class AdminMapper {
    private Connection connection;

    public AdminMapper() {
        this.connection = DBManage.getConnection();
    }

    public void insertAdmin(String adminId, String email, String phone, String username, String password) {
        try {
            String sql = "INSERT INTO ADMIN (Admin_ID, Email, Phone, Username, Password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, adminId);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(String adminId, String email, String phone, String username, String password) {
        try {
            String sql = "UPDATE ADMIN SET Email = ?, Phone = ?, Username = ?, Password = ? WHERE Admin_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, phone);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, adminId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(String adminId) {
        try {
            String sql = "DELETE FROM ADMIN WHERE Admin_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, adminId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Admin getAdminById(String adminId) {
        try {
            String sql = "SELECT * FROM ADMIN WHERE Admin_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, adminId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                return new Admin(adminId, email, phone, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Admin getAdminByUsername(String username) {
        try {
            String sql = "SELECT * FROM ADMIN WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String adminId = resultSet.getString("Admin_ID");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String password = resultSet.getString("Password");
                return new Admin(adminId, email, phone, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
