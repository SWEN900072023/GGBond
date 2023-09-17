package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.domin.Order;

public class OrderMapper {
    private Connection connection;

    public OrderMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertOrder(String orderId, String customerId, String ticketId, java.sql.Date date) {
        try {
            String sql = "INSERT INTO ORDER (Order_ID, Customer_ID, Ticket_ID, Date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            statement.setString(2, customerId);
            statement.setString(3, ticketId);
            statement.setDate(4, date);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateOrder(String orderId, String customerId, String ticketId, java.sql.Date date) {
        try {
            String sql = "UPDATE ORDER SET Customer_ID = ?, Ticket_ID = ?, Date = ? WHERE Order_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerId);
            statement.setString(2, ticketId);
            statement.setDate(3, date);
            statement.setString(4, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteOrder(String orderId) {
        try {
            String sql = "DELETE FROM ORDER WHERE Order_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Order getOrderById(String orderId) {
        try {
            String sql = "SELECT * FROM ORDER WHERE Order_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String customerId = resultSet.getString("Customer_ID");
                String ticketId = resultSet.getString("Ticket_ID");
                java.sql.Date date = resultSet.getDate("Date");

                return new Order(orderId, customerId, ticketId, date);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDER";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String orderId = resultSet.getString("Order_ID");
                String customerId = resultSet.getString("Customer_ID");
                String ticketId = resultSet.getString("Ticket_ID");
                java.sql.Date date = resultSet.getDate("Date");

                Order order = new Order(orderId, customerId, ticketId, date);
                orders.add(order);
            }
        } catch (SQLException e) {
        }
        return orders;
    }
}
