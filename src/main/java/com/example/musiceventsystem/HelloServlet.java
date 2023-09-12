package com.example.musiceventsystem;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.sql.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private static final String PROPERTY_JDBC_URI = "jdbc.uri";
    private static final String PROPERTY_JDBC_USERNAME = "jdbc.username";
    private static final String PROPERTY_JDBC_PASSWORD = "jdbc.password";

    @Override
    public void init() {
        // Load database driver during initialization
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        // Get database connection information from system properties
        String url = System.getProperty(PROPERTY_JDBC_URI);
        String user = System.getProperty(PROPERTY_JDBC_USERNAME);
        String pw = System.getProperty(PROPERTY_JDBC_PASSWORD);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.addHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");


        try (Connection conn = DriverManager.getConnection(url, user, pw)) {
            String sql = "INSERT INTO customers VALUES (?, ?);";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
