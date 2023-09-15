package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.musiceventsystem.domin.EventPlanner; //按照domin model去改下位置

public class PlannerMapper {
    private Connection connection;

    public PlannerMapper(Connection connection) {
        this.connection = connection;
    }

    public void insertPlanner(String plannerId, String email, String phone, String username, String password) {
        try {
            String sql = "INSERT INTO EVENTPLANNER (Planner_ID, Email, Phone, Username, Password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, plannerId);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updatePlanner(String plannerId, String email, String phone, String username, String password) {
        try {
            String sql = "UPDATE EVENTPLANNER SET Email = ?, Phone = ?, Username = ?, Password = ? WHERE Planner_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, phone);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, plannerId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deletePlanner(String plannerId) {
        try {
            String sql = "DELETE FROM EVENTPLANNER WHERE Planner_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, plannerId);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public EventPlanner getPlannerById(String plannerId) {
        try {
            String sql = "SELECT * FROM EVENTPLANNER WHERE Planner_ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, plannerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                return new EventPlanner(plannerId, email, phone, username, password);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public EventPlanner getPlannerByName(String username) {
        try {
            String sql = "SELECT * FROM EVENTPLANNER WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String plannerId = resultSet.getString("Planner_ID");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String password = resultSet.getString("Password");
                return new EventPlanner(plannerId, email, phone, username, password);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<EventPlanner> getAllPlanners() {
        ArrayList<EventPlanner> planners = new ArrayList<>();

        try {
            String sql = "SELECT * FROM EVENTPLANNER";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String plannerId = resultSet.getString("Planner_ID");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");

                EventPlanner planner = new EventPlanner(plannerId, email, phone, username, password);
                planners.add(planner);
            }
        } catch (SQLException e) {
        }

        return planners;
    }
}
