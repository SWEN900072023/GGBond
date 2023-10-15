package com.example.musiceventsystem.util;

import java.sql.*;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.SQLException;


public class JDBCUtil {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        Logger logger = LogManager.getLogger(JDBCUtil.class);
        Properties properties = new Properties();
        // Load properties from a file or environment, for example:
        // properties.load(new FileInputStream("db.properties"));
        // String url = properties.getProperty("jdbc.url");
        // String user = properties.getProperty("jdbc.user");
        // String pw = properties.getProperty("jdbc.password");
//        String url = "jdbc:postgresql://dpg-cjir130cfp5c73a5p6k0-a.singapore-postgres.render.com:5432/musicevents";
//        String user = "dbuser";
//        String pw = "eSR5cyX4zzWGw4hMUBZJKtrOUdWu2lSj";
        String url = "jdbc:postgresql://52.65.13.88:5432/musicevents";
        String user = "dbuser";
        String pw = "123456";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            logger.error("Failed to get database connection", e);
            //throw new RuntimeException(e);
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}