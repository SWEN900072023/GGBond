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
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String pw = "1331";
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, pw);
//            Statement stmt = conn.createStatement();

            // 执行查询语句
            String sql = "INSERT INTO customers VALUES (?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery(sql, USING u,p);
            stmt.setString(1, u);
            stmt.setString(2, p);
            stmt.executeUpdate();
            // 处理查询结果
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");

            // 关闭 ResultSet、Statement 和 Connection 对象
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
