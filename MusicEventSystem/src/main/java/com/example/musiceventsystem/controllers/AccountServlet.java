package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.auth.Authentication;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private Authentication authentication = new Authentication();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String loginType = req.getParameter("loginType");

                int id = authentication.setRoleType(loginType,username, password);
                int roleType = authentication.getRoleType();
                String str = username + password + loginType;
                switch (roleType) {
                    case -1:
                        //req.setAttribute("ussernameError", str);
                        req.setAttribute("usernameError", "The username does not exist!");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                        break;
                    case -2:
                        req.setAttribute("passwordError", "Wrong password!");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                        break;
                    case 1: // Admin
                        HttpSession adminSession = req.getSession();
                        adminSession.setAttribute("roleType", "admin");
                        adminSession.setAttribute("id", id);
                        resp.sendRedirect("/dashboard.jsp");
                        break;
                    case 2: // Planner
                        HttpSession plannerSession = req.getSession();
                        plannerSession.setAttribute("roleType", "planner");
                        plannerSession.setAttribute("id", id);
                        resp.sendRedirect("/dashboard.jsp");
                        break;
                    case 3: // Customer
                        HttpSession customerSession = req.getSession();
                        customerSession.setAttribute("roleType", "customer");
                        customerSession.setAttribute("id", id);
                        resp.sendRedirect("/dashboard.jsp");
                        break;
                    default:
                        req.setAttribute("roleError", "Unknown role!");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
                break;
            case "logout":
                req.getSession().invalidate();
                resp.sendRedirect("/login.jsp");
                break;
        }
    }
}
