package com.example.musiceventsystem.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManage {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb"; // MySQL database URL
    private static final String DB_USER = "root"; // Database username
    private static final String DB_PASSWORD = "password"; // Database password

    private Connection connection;

    public DBManage() {
        this(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static Connection getConnection() {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return connection;
    }
    public DBManage(String dbUrl, String dbUser, String dbPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void initializeDatabase() {
        try {
            createTableIfNotExists("WebUser",
                    "User_ID SERIAL PRIMARY KEY, " +
                            "UserType VARCHAR(50), " +
                            "Email VARCHAR(50), " +
                            "Phone VARCHAR(50), " +
                            "Username VARCHAR(50), " +
                            "Password VARCHAR(50)");

            createTableIfNotExists("Admin",
                    "Admin_ID INT PRIMARY KEY, " +
                            "FOREIGN KEY (Admin_ID) REFERENCES WebUser(User_ID)");

            createTableIfNotExists("Customer",
                    "Customer_ID INT PRIMARY KEY, " +
                            "FOREIGN KEY (Customer_ID) REFERENCES WebUser(User_ID)");

            createTableIfNotExists("Planner",
                    "Planner_ID INT PRIMARY KEY, " +
                            "FOREIGN KEY (Planner_ID) REFERENCES WebUser(User_ID)");

            createTableIfNotExists("EVENT_PLANNER_ASSOCIATION",
                    "Event_ID INT, " +
                            "Planner_ID INT, " +
                            "PRIMARY KEY (Event_ID, Planner_ID), " +
                            "FOREIGN KEY (Event_ID) REFERENCES Event(Event_ID), " +
                            "FOREIGN KEY (Planner_ID) REFERENCES Planner(Planner_ID)");

            createTableIfNotExists("Event",
                    "Event_ID SERIAL PRIMARY KEY, " +
                            "Planner_ID INT, " +
                            "Venue_ID INT, " +
                            "Start_Time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            "End_Time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            "FOREIGN KEY (Planner_ID) REFERENCES Planner(Planner_ID), " +
                            "FOREIGN KEY (Venue_ID) REFERENCES Venue(Venue_ID)");

            createTableIfNotExists("EVENT_PRICING",
                    "Event_ID INT, " +
                            "Section_Type VARCHAR(50), " +
                            "Price DECIMAL(10, 2), " +
                            "PRIMARY KEY (Event_ID, Section_Type), " +
                            "FOREIGN KEY (Event_ID) REFERENCES Event(Event_ID)");

            createTableIfNotExists("Venue",
                    "Venue_ID SERIAL PRIMARY KEY, " +
                            "Street VARCHAR(50), " +
                            "City VARCHAR(50), " +
                            "PostalCode VARCHAR(10), " +
                            "Section_Standing INT, " +
                            "Section_Mosh INT, " +
                            "Section_Seated INT, " +
                            "Section_VIP INT, " +
                            "Section_Other INT");

            createTableIfNotExists("Customer_Order",
                    "Order_ID SERIAL PRIMARY KEY, " +
                            "Customer_ID INT, " +
                            "Date TIMESTAMP, " +
                            "Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                            "FOREIGN KEY (Customer_ID) REFERENCES Customer(Customer_ID)");

            createTableIfNotExists("ORDER_DETAILS",
                    "Order_ID INT, " +
                            "Ticket_ID INT, " +
                            "PRIMARY KEY (Order_ID, Ticket_ID), " +
                            "FOREIGN KEY (Order_ID) REFERENCES Customer_Order(Order_ID), " +
                            "FOREIGN KEY (Ticket_ID) REFERENCES TICKET(Ticket_ID)");

            createTableIfNotExists("TICKET",
                    "Ticket_ID SERIAL PRIMARY KEY, " +
                            "Event_ID INT, " +
                            "Section_Type VARCHAR(50), " +
                            "Seat_ID VARCHAR(50), " +
                            "FOREIGN KEY (Event_ID) REFERENCES Event(Event_ID)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists(String tableName, String tableColumns) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + tableColumns + ")";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        System.out.println("Table " + tableName + " created (if not exists).");
    }

    public static String generateUUID() {
        return java.util.UUID.randomUUID().toString();
    }
}
