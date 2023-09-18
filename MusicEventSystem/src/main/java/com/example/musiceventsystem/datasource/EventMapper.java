package com.example.musiceventsystem.datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.model.Event;
import com.example.musiceventsystem.util.JDBCUtil;

public class EventMapper {

    /**
     * List all events in database
     *
     * @return a list of the events
     */
    public List<Event> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select e.id, e.name, e.venue_id, v.name, e.date, e.stap, e.mosp, e.seap, e.vipp, e.othp from event e, venue v where e.venue_id = v.id;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Event> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int venue_id = resultSet.getInt(3);
                String venue_name = resultSet.getString(4);
                String date = resultSet.getString(5);
                int sectionSta = resultSet.getInt(6);
                int sectionMos = resultSet.getInt(7);
                int sectionSea = resultSet.getInt(8);
                int sectionVip = resultSet.getInt(9);
                int sectionOth = resultSet.getInt(10);
                list.add(new Event(id, name, venue_id, venue_name, date, sectionSta, sectionMos, sectionSea, sectionVip,sectionOth));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * Insert a new event
     *
     * @param event event information
     * @return will explain later
     */
    public Integer save(Event event) {
        int id = 0;
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into event(name,venue_id,date,stap,mosp,seap,vipp,othp) values(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, event.getName());
            statement.setInt(2, event.getVenue_id());
            statement.setString(3, event.getDate());
            statement.setInt(4, event.getStaP());
            statement.setInt(5, event.getMosP());
            statement.setInt(6, event.getSeaP());
            statement.setInt(7, event.getVipP());
            statement.setInt(8, event.getOthP());
            result = statement.executeUpdate();
            ResultSet key = statement.getGeneratedKeys();
            if (key.next()){
                id = key.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return id;
    }

    /**
     * Search event by a value
     *
     * @param key the components of the event
     * @param value the value of the key
     * @return a list of events
     */
    public List<Event> search(String key, String value) {
//        Connection connection = JDBCUtil.getConnection();
//        String sql = "select * from event where "+key+" like '%"+value+"%'";
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
        List<Event> list = new ArrayList<>();
//        try {
//            statement = connection.prepareStatement(sql);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String username = resultSet.getString(2);
//                String password = resultSet.getString(3);
//                String name = resultSet.getString(4);
//                String telephone = resultSet.getString(5);
//                list.add(new Event());
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            JDBCUtil.release(connection, statement, resultSet);
//        }
        return list;
    }

    /**
     * Delete a event
     *
     * @param id the primary key of the event
     * @return will explain later
     */
    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from event where id = "+id;
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
