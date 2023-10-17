package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.auth.Authorization;
import com.example.musiceventsystem.model.Customer;
import com.example.musiceventsystem.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();
    private Authorization authorization = new Authorization();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("roleType");
        if (userRole == null || userRole.trim().isEmpty()) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            case "list":
                if (!authorization.checkPermission(userRole, "customer list")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                req.setAttribute("list", this.customerService.list());
                req.getRequestDispatcher("managecustomer.jsp").forward(req, resp);
                break;
            case "search":
                if (!authorization.checkPermission(userRole, "customer search")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.customerService.search(key, value));
                req.getRequestDispatcher("managecustomer.jsp").forward(req, resp);
                break;
            case "save":
                if (!authorization.checkPermission(userRole, "customer save")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String name = req.getParameter("name");
                String telephone = req.getParameter("telephone");
                this.customerService.save(new Customer(username, password, name, telephone));
                resp.sendRedirect("/customer?method=list");
                break;
            case "update":
                if (!authorization.checkPermission(userRole, "customer update")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                username = req.getParameter("username");
                password = req.getParameter("password");
                name = req.getParameter("name");
                telephone = req.getParameter("telephone");
                this.customerService.update(new Customer(id, username, password, name, telephone));
                resp.sendRedirect("/customer?method=list");
                break;
            case "delete":
                if (!authorization.checkPermission(userRole, "customer delete")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                this.customerService.delete(id);
                resp.sendRedirect("/customer?method=list");
                break;
        }
    }
}
