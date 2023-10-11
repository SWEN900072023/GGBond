package com.example.musiceventsystem;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.sql.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String u = request.getParameter("username");
        String p = request.getParameter("password");
        try {
            String url = "jdbc:postgresql://dpg-cjir130cfp5c73a5p6k0-a.singapore-postgres.render.com:5432/musicevents";
            String user = "dbuser";
            String pw = "eSR5cyX4zzWGw4hMUBZJKtrOUdWu2lSj";
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, pw);
//            Statement stmt = conn.createStatement();

            // execute query
            String sql = "INSERT INTO customer VALUES (?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery(sql, USING u,p);
            stmt.setString(1, u);
            stmt.setString(2, p);
            stmt.executeUpdate();
            // handle result
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");

            // close the object of ResultSet、Statement and Connection
//            rs.close();
//            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + rs + "</h1>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }
}