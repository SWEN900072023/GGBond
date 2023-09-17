package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.musiceventsystem.domin.Tickets; // 不改会报错

public class TicketsMapper {
    private Connection connection;

    public TicketsMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertTickets(String ticketId, String eventId, String sectionType, int soldNum, String seatId) {
        try {
            String sql = "INSERT INTO TICKETS (Ticket_ID, Event_ID, Section_Type, Sold_Num, Seat_ID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ticketId);
            statement.setString(2, eventId);
            statement.setString(3, sectionType);
            statement.setInt(4, soldNum);
            statement.setString(5, seatId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateTickets(String ticketId, String eventId, String sectionType, int soldNum, String seatId) {
        try {
            String sql = "UPDATE TICKETS SET Event_ID = ?, Section_Type = ?, Sold_Num = ?, Seat_ID = ? WHERE Ticket_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventId);
            statement.setString(2, sectionType);
            statement.setInt(3, soldNum);
            statement.setString(4, seatId);
            statement.setString(5, ticketId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteTickets(String ticketId) {
        try {
            String sql = "DELETE FROM TICKETS WHERE Ticket_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ticketId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Tickets getTicketsById(String ticketId) {
        try {
            String sql = "SELECT * FROM TICKETS WHERE Ticket_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ticketId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String eventId = resultSet.getString("Event_ID");
                String sectionType = resultSet.getString("Section_Type");
                int soldNum = resultSet.getInt("Sold_Num");
                String seatId = resultSet.getString("Seat_ID");

                return new Tickets(ticketId, eventId, sectionType, soldNum, seatId);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<Tickets> getAllTickets() {
        ArrayList<Tickets> ticketsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TICKETS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ticketId = resultSet.getString("Ticket_ID");
                String eventId = resultSet.getString("Event_ID");
                String sectionType = resultSet.getString("Section_Type");
                int soldNum = resultSet.getInt("Sold_Num");
                String seatId = resultSet.getString("Seat_ID");

                Tickets tickets = new Tickets(ticketId, eventId, sectionType, soldNum, seatId);
                ticketsList.add(tickets);
            }
        } catch (SQLException e) {
        }
        return ticketsList;
    }
}