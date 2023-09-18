package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.model.Customer;
import com.example.musiceventsystem.util.JDBCUtil;

public class CustomerMapper {

    /**
     * Get all customers' information
     *
     * @return a list of customers
     */
    public List<Customer> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from customer";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                list.add(new Customer(id, username, password, name, telephone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * Search customers by the value of the key
     *
     * @param key the components of the customer
     * @param value the value of the key
     * @return the list of customers
     */
    public List<Customer> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from customer where "+key+" like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                list.add(new Customer(id, username, password, name, telephone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * Insert a new customer
     *
     * @param customer customer information
     * @return will explain by Bao rui
     */
    public Integer save(Customer customer) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into customer(username,password,name,telephone) values(?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getTelephone());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    /**
     * Update customer information
     *
     * @param customer customer information
     * @return will explain by Bao rui
     */
    public Integer update(Customer customer) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update customer set username = ?,password = ?,name = ?,telephone = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getTelephone());
            statement.setInt(5, customer.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    /**
     * Delete a customer information
     *
     * @param id the primary key of the customer
     * @return will explain later
     */
    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from customer where id = "+id;
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

}
