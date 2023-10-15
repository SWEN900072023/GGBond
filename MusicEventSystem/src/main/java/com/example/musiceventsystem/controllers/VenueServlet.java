package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.auth.Authorization;
import com.example.musiceventsystem.model.Planner;
import com.example.musiceventsystem.model.Venue;
import com.example.musiceventsystem.service.VenueService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/venue")
public class VenueServlet extends HttpServlet {
    private VenueService venueService = new VenueService();
    private Authorization authorization = new Authorization();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("roleType");
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            case "list":
                if (!authorization.checkPermission(userRole, "venue list")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                req.setAttribute("list", this.venueService.list());
                req.getRequestDispatcher("managevenue.jsp").forward(req, resp);
                break;
            case "search":
                if (!authorization.checkPermission(userRole, "venue search")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String value = req.getParameter("value");
                req.setAttribute("list", this.venueService.search(value));
                req.getRequestDispatcher("managevenue.jsp").forward(req, resp);
                break;
            case "save":
                if (!authorization.checkPermission(userRole, "venue save")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String name = req.getParameter("venuename");
                String stanStr = req.getParameter("stan");
                Integer stan = Integer.parseInt(stanStr);
                String mosnStr = req.getParameter("mosn");
                Integer mosn = Integer.parseInt(mosnStr);
                String seanStr = req.getParameter("sean");
                Integer sean = Integer.parseInt(seanStr);
                String vipnStr = req.getParameter("vipn");
                Integer vipn = Integer.parseInt(vipnStr);
                String othnStr = req.getParameter("othn");
                Integer othn = Integer.parseInt(othnStr);
                this.venueService.save(new Venue(name, stan, mosn, sean,vipn,othn));
                resp.sendRedirect("/venue?method=list");
                break;
            case "update":
                if (!authorization.checkPermission(userRole, "venue update")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                name = req.getParameter("venuename");
                stanStr = req.getParameter("stan");
                stan = Integer.parseInt(stanStr);
                mosnStr = req.getParameter("mosn");
                mosn = Integer.parseInt(mosnStr);
                seanStr = req.getParameter("sean");
                sean = Integer.parseInt(seanStr);
                vipnStr = req.getParameter("vipn");
                vipn = Integer.parseInt(vipnStr);
                othnStr = req.getParameter("othn");
                othn = Integer.parseInt(othnStr);
                this.venueService.update(new Venue(id, name, stan, mosn, sean,vipn,othn));
                resp.sendRedirect("/venue?method=list");
                break;
            case "delete":
                if (!authorization.checkPermission(userRole, "venue delete")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                this.venueService.delete(id);
                resp.sendRedirect("/venue?method=list");
                break;

        }
    }
}
