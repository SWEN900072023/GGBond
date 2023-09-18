package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.model.Customer;
import com.example.musiceventsystem.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            case "list":
                req.setAttribute("list", this.customerService.list());
                req.getRequestDispatcher("managecustomer.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.customerService.search(key, value));
                req.getRequestDispatcher("managecustomer.jsp").forward(req, resp);
                break;
            case "save":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String name = req.getParameter("name");
                String telephone = req.getParameter("telephone");
                this.customerService.save(new Customer(username, password, name, telephone));
                resp.sendRedirect("/customer?method=list");
                break;
            case "update":
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
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                this.customerService.delete(id);
                resp.sendRedirect("/customer?method=list");
                break;
        }
    }
}
