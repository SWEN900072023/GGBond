package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
