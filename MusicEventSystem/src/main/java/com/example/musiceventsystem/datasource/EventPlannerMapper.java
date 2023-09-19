package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.util.JDBCUtil;

public class EventPlannerMapper {

    /**
     * save the information of the event holds by many planners
     *
     * @param eventId the id of the event
     * @param plannerId the id of the planner
     * @return
     */
    public Integer save(Integer eventId, Integer plannerId) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into EVENT_PLANNER_ASSOCIATION(event_id,planner_id) values(?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, eventId);
            statement.setInt(2, plannerId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    /**
     * Get event ids by planner id
     *
     * @param plannerId the id of the planner
     * @return the list of the event ids
     */
    public List<Integer> getEventIdsByPlannerId(Integer plannerId) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "SELECT event_id FROM EVENT_PLANNER_ASSOCIATION WHERE planner_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> eventIds = new ArrayList<>();

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, plannerId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int eventId = resultSet.getInt("event_id");
                eventIds.add(eventId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }

        return eventIds;
    }
}
