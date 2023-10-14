package com.example.musiceventsystem.controllers;

import com.example.musiceventsystem.model.Order;
import com.example.musiceventsystem.service.OrderService;
import com.example.musiceventsystem.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {

    private TicketService ticketService = new TicketService();
    private OrderService orderService = new OrderService();


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
                req.setAttribute("list", this.ticketService.list());
                req.getRequestDispatcher("purchase.jsp").forward(req, resp);
                break;
            case "save":
                String customerIdStr = req.getParameter("customerid");
                Integer customerId = Integer.parseInt(customerIdStr);
                String ticketIdStr = req.getParameter("ticketid");
                Integer ticketId = Integer.parseInt(ticketIdStr);
                String eventIdStr = req.getParameter("eventid");
                Integer eventId = Integer.parseInt(eventIdStr);
                String eventName = req.getParameter("eventname");
                String section = req.getParameter("section");
//                List<String> sec = Collections.singletonList(req.getParameter("section"));
//                String section = sec.get(0);
//                String priceStr = sec.get(1);
                String priceStr = req.getParameter("price");
                Integer price = Integer.parseInt(priceStr);
//                Integer price = 1;
                String numStr = req.getParameter("number");
                Integer num = Integer.parseInt(numStr);
                Integer res = this.orderService.save(new Order(customerId, ticketId, eventId, eventName,section,price,num));
                switch (res){
                    case 1:
                        resp.sendRedirect("/purchase?method=list");
                        break;
                    case 0:
                        resp.sendRedirect("/serverbusy.jsp");
                        break;
                    case -1:
                        resp.sendRedirect("/insufficientstock.jsp");
                        break;
                }
                break;
        }
    }
}
