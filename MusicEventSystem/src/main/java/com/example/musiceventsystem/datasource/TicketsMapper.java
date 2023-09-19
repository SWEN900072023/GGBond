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

    public List<Ticket> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from ticket";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Ticket> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int eventId = resultSet.getInt(2);
                String eventName = resultSet.getString(3);
                int venueId = resultSet.getInt(4);
                String venueName = resultSet.getString(5);
                int san = resultSet.getInt(6);
                int sbn = resultSet.getInt(7);
                int scn = resultSet.getInt(8);
                int sdn = resultSet.getInt(9);
                int sen = resultSet.getInt(10);
                int sap = resultSet.getInt(11);
                int sbp = resultSet.getInt(12);
                int scp = resultSet.getInt(13);
                int sdp = resultSet.getInt(14);
                int sep = resultSet.getInt(15);
                list.add(new Ticket(id,eventId,eventName,venueId,venueName,san,sbn,scn,sdn,sen,sap,sbp,scp,sdp,sep));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}