package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.domin.Venue; // 不改会报错

public class VenueMapper {
    private Connection connection;

    public VenueMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertVenue(String venueId, String location, int sectionStanding, int sectionMosh, int sectionSeated, int sectionVIP, int sectionOther) {
        try {
            String sql = "INSERT INTO VENUE (Venue_ID, Location, Section_Standing, Section_Mosh, Section_Seated, Section_VIP, Section_Other) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, venueId);
            statement.setString(2, location);
            statement.setInt(3, sectionStanding);
            statement.setInt(4, sectionMosh);
            statement.setInt(5, sectionSeated);
            statement.setInt(6, sectionVIP);
            statement.setInt(7, sectionOther);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateVenue(String venueId, String location, int sectionStanding, int sectionMosh, int sectionSeated, int sectionVIP, int sectionOther) {
        try {
            String sql = "UPDATE VENUE SET Location = ?, Section_Standing = ?, Section_Mosh = ?, Section_Seated = ?, Section_VIP = ?, Section_Other = ? WHERE Venue_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, location);
            statement.setInt(2, sectionStanding);
            statement.setInt(3, sectionMosh);
            statement.setInt(4, sectionSeated);
            statement.setInt(5, sectionVIP);
            statement.setInt(6, sectionOther);
            statement.setString(7, venueId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteVenue(String venueId) {
        try {
            String sql = "DELETE FROM VENUE WHERE Venue_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, venueId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Venue getVenueById(String venueId) {
        try {
            String sql = "SELECT * FROM VENUE WHERE Venue_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, venueId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String location = resultSet.getString("Location");
                int sectionStanding = resultSet.getInt("Section_Standing");
                int sectionMosh = resultSet.getInt("Section_Mosh");
                int sectionSeated = resultSet.getInt("Section_Seated");
                int sectionVIP = resultSet.getInt("Section_VIP");
                int sectionOther = resultSet.getInt("Section_Other");

                return new Venue(venueId, location, sectionStanding, sectionMosh, sectionSeated, sectionVIP, sectionOther);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<Venue> getAllVenues() {
        ArrayList<Venue> venues = new ArrayList<>();
        try {
            String sql = "SELECT * FROM VENUE";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String venueId = resultSet.getString("Venue_ID");
                String location = resultSet.getString("Location");
                int sectionStanding = resultSet.getInt("Section_Standing");
                int sectionMosh = resultSet.getInt("Section_Mosh");
                int sectionSeated = resultSet.getInt("Section_Seated");
                int sectionVIP = resultSet.getInt("Section_VIP");
                int sectionOther = resultSet.getInt("Section_Other");

                Venue venue = new Venue(venueId, location, sectionStanding, sectionMosh, sectionSeated, sectionVIP, sectionOther);
                venues.add(venue);
            }
        } catch (SQLException e) {
        }
        return venues;
    }
}