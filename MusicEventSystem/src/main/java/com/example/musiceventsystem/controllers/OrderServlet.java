package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.auth.Authorization;
import com.example.musiceventsystem.model.Order;
import com.example.musiceventsystem.service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.time.Instant;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
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
        Instant currentInstant = Instant.now();

        switch (method) {
            case "list":
                if (!authorization.checkPermission(userRole, "order list")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                HttpSession customerSession = req.getSession();
                Integer uid = (Integer) customerSession.getAttribute("id");
                String suid = uid.toString();
                req.setAttribute("list", this.orderService.search("customer_id", suid));
                req.getRequestDispatcher("manageorder.jsp").forward(req, resp);
                break;
            case "search":
                if (!authorization.checkPermission(userRole, "order search")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                List<Order> searchResult = orderService.search(key, value);
                req.setAttribute("list", searchResult);
                req.getRequestDispatcher("manageorder.jsp").forward(req, resp);
                break;
            case "save":
                if (!authorization.checkPermission(userRole, "order save")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String customerIdStr = req.getParameter("customerid");
                Integer customerId = Integer.parseInt(customerIdStr);
                String ticketIdStr = req.getParameter("ticketid");
                Integer ticketId = Integer.parseInt(ticketIdStr);
                String eventIdStr = req.getParameter("eventid");
                Integer eventId = Integer.parseInt(eventIdStr);
                String eventName = req.getParameter("eventname");
                String section = req.getParameter("section");
                String priceStr = req.getParameter("price");
                Integer price = Integer.parseInt(priceStr);
                String numStr = req.getParameter("num");
                Integer num = Integer.parseInt(numStr);
                orderService.save(new Order(customerId, ticketId, eventId, eventName, section, price, num));
                resp.sendRedirect("/order?method=list");
                break;
            case "update":
                if (!authorization.checkPermission(userRole, "order update")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String orderIdStr = req.getParameter("id");
                Integer orderId = Integer.parseInt(orderIdStr);
                customerIdStr = req.getParameter("customerid");
                customerId = Integer.parseInt(customerIdStr);
                ticketIdStr = req.getParameter("ticketid");
                ticketId = Integer.parseInt(ticketIdStr);
                eventIdStr = req.getParameter("eventid");
                eventId = Integer.parseInt(eventIdStr);
                eventName = req.getParameter("eventname");
                section = req.getParameter("section");
                priceStr = req.getParameter("price");
                price = Integer.parseInt(priceStr);
                numStr = req.getParameter("num");
                num = Integer.parseInt(numStr);
                Timestamp currentTimestamp = Timestamp.from(currentInstant);
                orderService.update(new Order(orderId, customerId, ticketId, eventId, eventName, section, price, num, currentTimestamp));
                resp.sendRedirect("/order?method=list");
                break;
            case "delete":
                if (!authorization.checkPermission(userRole, "order delete")) {
                    resp.sendRedirect("/accessdenied.jsp");
                    return;
                }
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                orderService.delete(id);
                resp.sendRedirect("/order?method=list");
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
    }
}
