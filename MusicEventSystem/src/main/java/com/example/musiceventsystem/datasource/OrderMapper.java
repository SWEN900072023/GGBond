package com.example.musiceventsystem.datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.model.Order;
import com.example.musiceventsystem.util.JDBCUtil;

public class OrderMapper {
    public Integer save(Order order) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into customerorder(customer_id,ticket_id,event_id,event_name,section,price,num) values(?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getCustomerId());
            statement.setInt(2, order.getTicketId());
            statement.setInt(3, order.getEventId());
            statement.setString(4, order.getEventName());
            statement.setString(5, order.getSection());
            statement.setInt(6, order.getPrice());
            statement.setInt(7, order.getNum());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public Integer update(Order order) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "UPDATE customerorder SET customer_id = ?, ticket_id = ?, event_id = ?, event_name = ?, section = ?, price = ?, num = ?, timestamp = ? WHERE id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getCustomerId());
            statement.setInt(2, order.getTicketId());
            statement.setInt(3, order.getEventId());
            statement.setString(4, order.getEventName());
            statement.setString(5, order.getSection());
            statement.setInt(6, order.getPrice());
            statement.setInt(7, order.getNum());
            statement.setTimestamp(8, order.getTime());
            statement.setInt(9, order.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "DELETE FROM customerorder WHERE id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public List<Order> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "SELECT * FROM customerorder WHERE "+key+"="+value;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> orders = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                int ticketId = resultSet.getInt("ticket_id");
                int eventId = resultSet.getInt("event_id");
                String eventName = resultSet.getString("event_name");
                String section = resultSet.getString("section");
                int price = resultSet.getInt("price");
                int num = resultSet.getInt("num");
                Timestamp timestamp = resultSet.getTimestamp("timestamp");

                Order order = new Order(id, customerId, ticketId, eventId, eventName, section, price, num, timestamp);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return orders;
    }

    public List<Order> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "SELECT * FROM customerorder";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                int ticketId = resultSet.getInt("ticket_id");
                int eventId = resultSet.getInt("event_id");
                String eventName = resultSet.getString("event_name");
                String section = resultSet.getString("section");
                int price = resultSet.getInt("price");
                int num = resultSet.getInt("num");
                Timestamp timestamp = resultSet.getTimestamp("timestamp");
                Order order = new Order(id, customerId, ticketId, eventId, eventName, section, price, num, timestamp);
                list.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}
