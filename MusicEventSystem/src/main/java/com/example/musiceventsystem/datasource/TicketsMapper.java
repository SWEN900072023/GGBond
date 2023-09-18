package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.musiceventsystem.model.Ticket;
import com.example.musiceventsystem.util.JDBCUtil;

public class TicketsMapper {
    public Integer save(Ticket ticket) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into ticket(event_id,san,sbn,scn,sdn,sen) values(?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ticket.getId());
            statement.setInt(2, ticket.getStaN());
            statement.setInt(3, ticket.getMosN());
            statement.setInt(4, ticket.getSeaN());
            statement.setInt(5, ticket.getVipN());
            statement.setInt(6, ticket.getOthN());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }
}