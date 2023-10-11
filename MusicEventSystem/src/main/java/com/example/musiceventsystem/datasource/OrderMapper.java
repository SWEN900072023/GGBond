package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.domain.Order;

public class OrderMapper {
    private Connection connection;

    public OrderMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertOrder(String orderId, String customerId, String eventId, java.sql.Date orderDate, int quantity, double totalPrice) {
        try {
            String sql = "INSERT INTO ORDERS (Order_ID, Customer_ID, Event_ID, Order_Date, Quantity, Total_Price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            statement.setString(2, customerId);
            statement.setString(3, eventId);
            statement.setDate(4, orderDate);
            statement.setInt(5, quantity);
            statement.setDouble(6, totalPrice);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(String orderId, String customerId, String eventId, java.sql.Date orderDate, int quantity, double totalPrice) {
        try {
            String sql = "UPDATE ORDERS SET Customer_ID = ?, Event_ID = ?, Order_Date = ?, Quantity = ?, Total_Price = ? WHERE Order_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerId);
            statement.setString(2, eventId);
            statement.setDate(3, orderDate);
            statement.setInt(4, quantity);
            statement.setDouble(5, totalPrice);
            statement.setString(6, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(String orderId) {
        try {
            String sql = "DELETE FROM ORDERS WHERE Order_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order getOrderById(String orderId) {
        try {
            String sql = "SELECT * FROM ORDERS WHERE Order_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String customerId = resultSet.getString("Customer_ID");
                String eventId = resultSet.getString("Event_ID");
                java.sql.Date orderDate = resultSet.getDate("Order_Date");
                int quantity = resultSet.getInt("Quantity");
                double totalPrice = resultSet.getDouble("Total_Price");

                return new Order(orderId, customerId, eventId, orderDate, quantity, totalPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String orderId = resultSet.getString("Order_ID");
                String customerId = resultSet.getString("Customer_ID");
                String eventId = resultSet.getString("Event_ID");
                java.sql.Date orderDate = resultSet.getDate("Order_Date");
                int quantity = resultSet.getInt("Quantity");
                double totalPrice = resultSet.getDouble("Total_Price");

                Order order = new Order(orderId, customerId, eventId, orderDate, quantity, totalPrice);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
