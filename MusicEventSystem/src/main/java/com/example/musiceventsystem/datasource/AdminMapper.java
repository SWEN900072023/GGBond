package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.musiceventsystem.model.Admin;
import com.example.musiceventsystem.util.JDBCUtil;

public class AdminMapper {

    public Admin findByUsername(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from admin where username = '"+username+"'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                return new Admin(id, username, password, name, telephone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return null;
    }

    /**
     * Check the in put is valid or not
     *
     * @param username the username of the planner
     * @param password the password of the planner
     * @return state code int
     */
    public int isLoginValid(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM admin WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (storedPassword.equals(password)) {
                    return resultSet.getInt("id"); // login successful
                } else {
                    return 0; // wrong password
                }
            } else {
                return -1; // user does not exits
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
    }
}



