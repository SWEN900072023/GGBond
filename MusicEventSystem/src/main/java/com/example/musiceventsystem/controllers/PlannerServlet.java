package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.model.Planner;
import com.example.musiceventsystem.service.PlannerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/planner")
public class PlannerServlet extends HttpServlet {

    private PlannerService plannerService = new PlannerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        String contextPath = req.getContextPath();
        switch (method){
            case "list":
                req.setAttribute("list", this.plannerService.list());
                req.getRequestDispatcher("manageplanner.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.plannerService.search(key, value));
                req.getRequestDispatcher("manageplanner.jsp").forward(req, resp);
                break;
            case "save":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String name = req.getParameter("name");
                String telephone = req.getParameter("telephone");
                this.plannerService.save(new Planner(username, password, name, telephone));
                resp.sendRedirect(contextPath + "/planner?method=list");
                break;
            case "update":
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                username = req.getParameter("username");
                password = req.getParameter("password");
                name = req.getParameter("name");
                telephone = req.getParameter("telephone");
                this.plannerService.update(new Planner(id, username, password, name, telephone));
                resp.sendRedirect(contextPath + "/planner?method=list");
                break;
            case "delete":
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                this.plannerService.delete(id);
                resp.sendRedirect(contextPath + "/planner?method=list");
                break;
        }
    }
}
