package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.auth.Authorization;
import com.example.musiceventsystem.model.Event;
import com.example.musiceventsystem.service.EventService;
import com.example.musiceventsystem.service.PlannerService;
import com.example.musiceventsystem.service.VenueService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/event")
public class EventServlet extends HttpServlet {
    private PlannerService plannerService = new PlannerService();
    private EventService eventService = new EventService();
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

        switch (method) {
            case "list":
                if (!authorization.checkPermission(userRole, "event list")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                List<Event> eventList = eventService.list();
                req.setAttribute("list", eventList);
                req.setAttribute("venueList", venueService.list());
                req.setAttribute("plannerList", plannerService.list());
                req.getRequestDispatcher("manageevent.jsp").forward(req, resp);
                break;
            case "search":
                if (!authorization.checkPermission(userRole, "event search")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                List<Event> searchResult = eventService.search(key, value);
                req.setAttribute("list", searchResult);
                req.setAttribute("venueList", venueService.list());
                req.setAttribute("plannerList", plannerService.list());
                req.getRequestDispatcher("manageevent.jsp").forward(req, resp);
                break;
            case "save":
                if (!authorization.checkPermission(userRole, "event save")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String plannerIdStr = req.getParameter("planner");
                Integer plannerId = Integer.parseInt(plannerIdStr);

                String name = req.getParameter("name");
                String venueIdStr = req.getParameter("venue");
                Integer venueId = Integer.parseInt(venueIdStr);
                String date = req.getParameter("date");
                String stapStr = req.getParameter("stap");
                Integer stap = Integer.parseInt(stapStr);
                String mospStr = req.getParameter("mosp");
                Integer mosp = Integer.parseInt(mospStr);
                String seapStr = req.getParameter("seap");
                Integer seap = Integer.parseInt(seapStr);
                String vippStr = req.getParameter("vipp");
                Integer vipp = Integer.parseInt(vippStr);
                String othpStr = req.getParameter("othp");
                Integer othp = Integer.parseInt(othpStr);

                eventService.save(new Event(name, venueId, date, stap, mosp, seap, vipp, othp), plannerId);
                resp.sendRedirect("/event?method=list");
                break;

            case "delete":
                if (!authorization.checkPermission(userRole, "event delete")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                eventService.delete(id);
                resp.sendRedirect("/event?method=list");
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
    }
}
