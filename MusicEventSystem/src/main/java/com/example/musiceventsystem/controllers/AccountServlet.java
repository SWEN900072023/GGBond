package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.dto.AdminDto;
import com.example.musiceventsystem.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        String contextPath = req.getContextPath();
        switch (method){
            case "login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                AdminDto adminDto = this.adminService.login(username, password);
                switch (adminDto.getCode()) {
                    case -1:
                        req.setAttribute("usernameError", "The username does not exist!");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                        break;
                    case -2:
                        req.setAttribute("passwordError", "Wrong password!");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                        break;
                    case 0:
                        HttpSession session = req.getSession();
                        session.setAttribute("admin", adminDto.getAdmin());
                        resp.sendRedirect(contextPath + "/admin.jsp");
                        break;
                }
                break;
            case "logout":
                req.getSession().invalidate();
                resp.sendRedirect("/login.jsp");
                break;
        }
    }
}
