package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.musiceventsystem.domain.Customer;

public class CustomerMapper {
    private Connection connection;

    public CustomerMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertCustomer(String customerId, String email, String phone, String username, String password) {
        try {
            String sql = "INSERT INTO Customer (Customer_ID, Email, Phone, Username, Password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerId);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(String customerId, String email, String phone, String username, String password) {
        try {
            String sql = "UPDATE Customer SET Email = ?, Phone = ?, Username = ?, Password = ? WHERE Customer_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, phone);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(String customerId) {
        try {
            String sql = "DELETE FROM Customer WHERE Customer_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(String customerId) {
        try {
            String sql = "SELECT * FROM Customer WHERE Customer_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                return new Customer(customerId, email, phone, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer getCustomerByName(String username) {
        try {
            String sql = "SELECT * FROM Customer WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String customerId = resultSet.getString("Customer_ID");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String password = resultSet.getString("Password");
                return new Customer(customerId, email, phone, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Customer";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String customerId = resultSet.getString("Customer_ID");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");

                Customer customer = new Customer(customerId, email, phone, username, password);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
