package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.musiceventsystem.domain.Venue; // Make sure to import the correct Venue class

public class VenueMapper {
    private Connection connection;

    public VenueMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertVenue(String venueId, String location, int sectionStanding, int sectionMosh, int sectionSeated, int sectionVIP, int sectionOther) {
        try {
            String sql = "INSERT INTO VENUE (Venue_ID, Location, Section_Standing_Capacity, Section_Mosh_Capacity, Section_Seated_Capacity, Section_VIP_Capacity, Section_Other_Capacity) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
            e.printStackTrace();
        }
    }

    public void updateVenue(String venueId, String location, int sectionStanding, int sectionMosh, int sectionSeated, int sectionVIP, int sectionOther) {
        try {
            String sql = "UPDATE VENUE SET Location = ?, Section_Standing_Capacity = ?, Section_Mosh_Capacity = ?, Section_Seated_Capacity = ?, Section_VIP_Capacity = ?, Section_Other_Capacity = ? WHERE Venue_ID = ?";
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
            e.printStackTrace();
        }
    }

    public void deleteVenue(String venueId) {
        try {
            String sql = "DELETE FROM VENUE WHERE Venue_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, venueId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
                int sectionStanding = resultSet.getInt("Section_Standing_Capacity");
                int sectionMosh = resultSet.getInt("Section_Mosh_Capacity");
                int sectionSeated = resultSet.getInt("Section_Seated_Capacity");
                int sectionVIP = resultSet.getInt("Section_VIP_Capacity");
                int sectionOther = resultSet.getInt("Section_Other_Capacity");

                return new Venue(venueId, location, sectionStanding, sectionMosh, sectionSeated, sectionVIP, sectionOther);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Venue> getAllVenues() {
        List<Venue> venues = new ArrayList<>();
        try {
            String sql = "SELECT * FROM VENUE";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String venueId = resultSet.getString("Venue_ID");
                String location = resultSet.getString("Location");
                int sectionStanding = resultSet.getInt("Section_Standing_Capacity");
                int sectionMosh = resultSet.getInt("Section_Mosh_Capacity");
                int sectionSeated = resultSet.getInt("Section_Seated_Capacity");
                int sectionVIP = resultSet.getInt("Section_VIP_Capacity");
                int sectionOther = resultSet.getInt("Section_Other_Capacity");

                Venue venue = new Venue(venueId, location, sectionStanding, sectionMosh, sectionSeated, sectionVIP, sectionOther);
                venues.add(venue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venues;
    }
}
