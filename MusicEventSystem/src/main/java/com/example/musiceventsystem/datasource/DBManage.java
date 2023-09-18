package com.example.musiceventsystem.datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManage {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb"; // MySQL数据库URL
    private static final String DB_USER = "root"; // 数据库用户名
    private static final String DB_PASSWORD = "password"; // 数据库密码

    private Connection connection;

    public DBManage() {
        this(DB_URL, DB_USER, DB_PASSWORD);
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
            createTableIfNotExists("CUSTOMER",
                    "Customer_ID VARCHAR(50) PRIMARY KEY, " +
                            "Email VARCHAR(50), " +
                            "Phone VARCHAR(50), " +
                            "Username VARCHAR(50), " +
                            "Password VARCHAR(50)");

            createTableIfNotExists("EVENTPLANNER",
                    "Planner_ID VARCHAR(50) PRIMARY KEY, " +
                            "Email VARCHAR(50), " +
                            "Phone VARCHAR(50), " +
                            "Username VARCHAR(50), " +
                            "Password VARCHAR(50)");

            createTableIfNotExists("VENUE",
                    "Venue_ID CHAR(36) PRIMARY KEY, " +
                            "Location VARCHAR(50), " +
                            "Section_Standing INT, " +
                            "Section_Mosh INT, " +
                            "Section_Seated INT, " +
                            "Section_VIP INT, " +
                            "Section_Other INT)");

            createTableIfNotExists("EVENT",
                    "Event_ID VARCHAR(50) PRIMARY KEY, " +
                            "Planner_ID VARCHAR(50), " +
                            "Venue_ID CHAR(36), " +
                            "Section_Standing_Price FLOAT, " +
                            "Section_Mosh_Price FLOAT, " +
                            "Section_Seated_Price FLOAT, " +
                            "Section_VIP_Price FLOAT, " +
                            "Section_Other_Price FLOAT)");

            createTableIfNotExists("ORDER",
                    "Order_ID VARCHAR(50) PRIMARY KEY, " +
                            "Customer_ID VARCHAR(50), " +
                            "Ticket_ID VARCHAR(50), " +
                            "Date DATE)");

            createTableIfNotExists("TICKETS",
                    "Ticket_ID VARCHAR(50) PRIMARY KEY, " +
                            "Event_ID VARCHAR(50), " +
                            "Section_Type VARCHAR(50), " +
                            "Sold_Num INT, " +
                            "Seat_ID VARCHAR(50))");
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
