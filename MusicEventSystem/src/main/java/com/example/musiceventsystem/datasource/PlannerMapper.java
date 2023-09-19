package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.model.Planner;
import com.example.musiceventsystem.util.JDBCUtil;

public class PlannerMapper {

    /**
     * List all event planners
     *
     * @return a list of planners
     */
    public List<Planner> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from planner";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Planner> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                list.add(new Planner(id, username, password, name, telephone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * Search event planner by some value
     *
     * @param key the components of the planners
     * @param value the value of the key
     * @return a list of planners
     */
    public List<Planner> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from planner where "+key+" like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Planner> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                list.add(new Planner(id, username, password, name, telephone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * Insert a planner
     *
     * @param planner the information of a planner
     * @return will explain later
     */
    public Integer save(Planner planner) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into planner(username,password,name,telephone) values(?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, planner.getUsername());
            statement.setString(2, planner.getPassword());
            statement.setString(3, planner.getName());
            statement.setString(4, planner.getTelephone());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    /**
     * Update the information of the planner
     *
     * @param planner information of the planner
     * @return will explain later
     */
    public Integer update(Planner planner) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update planner set username = ?,password = ?,name = ?,telephone = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, planner.getUsername());
            statement.setString(2, planner.getPassword());
            statement.setString(3, planner.getName());
            statement.setString(4, planner.getTelephone());
            statement.setInt(5, planner.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    /**
     * Delete a event planner
     *
     * @param id the primary key of the planner
     * @return will explain later
     */
    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from planner where id = "+id;
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
            String sql = "SELECT * FROM planner WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (storedPassword.equals(password)) {
                    return 1; // longin success
                } else {
                    return 0; // wrong password
                }
            } else {
                return -1; // unknown user
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
    }
}
