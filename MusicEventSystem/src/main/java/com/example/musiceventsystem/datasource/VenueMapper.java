package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.musiceventsystem.util.JDBCUtil;
import com.example.musiceventsystem.model.Venue;

public class VenueMapper {
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

    public Venue selectVenue(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from venue where id = " + id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int venueId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int sectionSta = resultSet.getInt(3);
                int sectionMos = resultSet.getInt(4);
                int sectionSea = resultSet.getInt(5);
                int sectionVip = resultSet.getInt(6);
                int sectionOth = resultSet.getInt(7);
                return new Venue(venueId, name, sectionSta, sectionMos, sectionSea, sectionVip,sectionOth);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return null;
    }

    public Integer save(Venue venue) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into venue(name,sectionsta,sectionmos,sectionsea,sectionvip,sectionoth) values(?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, venue.getName());
            statement.setInt(2, venue.getSectionSta());
            statement.setInt(3, venue.getSectionMos());
            statement.setInt(4, venue.getSectionSea());
            statement.setInt(5, venue.getSectionVip());
            statement.setInt(6, venue.getSectionOth());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    public Integer update(Venue venue) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update venue set name = ?,sectionsta = ?,sectionmos = ?,sectionsea = ?,sectionvip=?,sectionoth=? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, venue.getName());
            statement.setInt(2, venue.getSectionSta());
            statement.setInt(3, venue.getSectionMos());
            statement.setInt(4, venue.getSectionSea());
            statement.setInt(5, venue.getSectionVip());
            statement.setInt(6, venue.getSectionOth());
            statement.setInt(7, venue.getId());
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
        String sql = "delete from venue where id = "+id;
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
