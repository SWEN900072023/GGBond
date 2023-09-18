package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.model.Venue;
import com.example.musiceventsystem.model.Ticket;
import com.example.musiceventsystem.util.JDBCUtil;

public class VenueMapper {

    /**
     * List all venues in the database
     *
     * @return a list of the venues
     */
    public List<Venue> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from venue";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Venue> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int sectionSta = resultSet.getInt(3);
                int sectionMos = resultSet.getInt(4);
                int sectionSea = resultSet.getInt(5);
                int sectionVip = resultSet.getInt(6);
                int sectionOth = resultSet.getInt(7);
                list.add(new Venue(id, name, sectionSta, sectionMos, sectionSea, sectionVip,sectionOth));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * Search venues by name
     *
     * @param value the name of the value
     * @return the list of the value
     */
    public List<Venue> search(String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from venue where name like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Venue> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int sectionSta = resultSet.getInt(3);
                int sectionMos = resultSet.getInt(4);
                int sectionSea = resultSet.getInt(5);
                int sectionVip = resultSet.getInt(6);
                int sectionOth = resultSet.getInt(7);
                list.add(new Venue(id, name, sectionSta, sectionMos, sectionSea, sectionVip,sectionOth));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    public Ticket generateTicket(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from venue where id = " + id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int sectionSta = resultSet.getInt(3);
                int sectionMos = resultSet.getInt(4);
                int sectionSea = resultSet.getInt(5);
                int sectionVip = resultSet.getInt(6);
                int sectionOth = resultSet.getInt(7);
                return new Ticket(sectionSta, sectionMos, sectionSea, sectionVip,sectionOth);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return null;
    }
}