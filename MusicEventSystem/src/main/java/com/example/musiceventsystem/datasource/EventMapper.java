package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.domin.Event; //

public class EventMapper {
    private Connection connection;

    public EventMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertEvent(String eventId, String plannerId, String venueId, float standingPrice, float moshPrice, float seatedPrice, float vipPrice, float otherPrice) {
        try {
            String sql = "INSERT INTO EVENT (Event_ID, Planner_ID, Venue_ID, Section_Standing_Price, Section_Mosh_Price, Section_Seated_Price, Section_VIP_Price, Section_Other_Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventId);
            statement.setString(2, plannerId);
            statement.setString(3, venueId);
            statement.setFloat(4, standingPrice);
            statement.setFloat(5, moshPrice);
            statement.setFloat(6, seatedPrice);
            statement.setFloat(7, vipPrice);
            statement.setFloat(8, otherPrice);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateEvent(String eventId, String plannerId, String venueId, float standingPrice, float moshPrice, float seatedPrice, float vipPrice, float otherPrice) {
        try {
            String sql = "UPDATE EVENT SET Planner_ID = ?, Venue_ID = ?, Section_Standing_Price = ?, Section_Mosh_Price = ?, Section_Seated_Price = ?, Section_VIP_Price = ?, Section_Other_Price = ? WHERE Event_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, plannerId);
            statement.setString(2, venueId);
            statement.setFloat(3, standingPrice);
            statement.setFloat(4, moshPrice);
            statement.setFloat(5, seatedPrice);
            statement.setFloat(6, vipPrice);
            statement.setFloat(7, otherPrice);
            statement.setString(8, eventId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteEvent(String eventId) {
        try {
            String sql = "DELETE FROM EVENT WHERE Event_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Event getEventById(String eventId) {
        try {
            String sql = "SELECT * FROM EVENT WHERE Event_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String plannerId = resultSet.getString("Planner_ID");
                String venueId = resultSet.getString("Venue_ID");
                float standingPrice = resultSet.getFloat("Section_Standing_Price");
                float moshPrice = resultSet.getFloat("Section_Mosh_Price");
                float seatedPrice = resultSet.getFloat("Section_Seated_Price");
                float vipPrice = resultSet.getFloat("Section_VIP_Price");
                float otherPrice = resultSet.getFloat("Section_Other_Price");

                return new Event(eventId, plannerId, venueId, standingPrice, moshPrice, seatedPrice, vipPrice, otherPrice);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> events = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EVENT";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String eventId = resultSet.getString("Event_ID");
                String plannerId = resultSet.getString("Planner_ID");
                String venueId = resultSet.getString("Venue_ID");
                float standingPrice = resultSet.getFloat("Section_Standing_Price");
                float moshPrice = resultSet.getFloat("Section_Mosh_Price");
                float seatedPrice = resultSet.getFloat("Section_Seated_Price");
                float vipPrice = resultSet.getFloat("Section_VIP_Price");
                float otherPrice = resultSet.getFloat("Section_Other_Price");

                Event event = new Event(eventId, plannerId, venueId, standingPrice, moshPrice, seatedPrice, vipPrice, otherPrice);
                events.add(event);
            }
        } catch (SQLException e) {
        }
        return events;
    }
}
