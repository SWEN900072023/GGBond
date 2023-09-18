package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.service.VenueService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/venue")
public class VenueServlet extends HttpServlet {
    private VenueService venueService = new VenueService();

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
                req.setAttribute("list", this.venueService.list());
                req.getRequestDispatcher("managevenue.jsp").forward(req, resp);
                break;
            case "search":
                String value = req.getParameter("value");
                req.setAttribute("list", this.venueService.search(value));
                req.getRequestDispatcher("managevenue.jsp").forward(req, resp);
                break;
            case "save":
                break;
        }
    }
}
