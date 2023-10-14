package com.example.musiceventsystem.service;

import com.example.musiceventsystem.datasource.OrderMapper;
import com.example.musiceventsystem.datasource.TicketsMapper;
import com.example.musiceventsystem.model.Order;
import com.example.musiceventsystem.model.Ticket;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class OrderService {
    private OrderMapper orderMapper = new OrderMapper();
    private TicketsMapper ticketsMapper = new TicketsMapper();

    public List<Order> list() {
        return orderMapper.list();
    }

    public List<Order> search(String key, String value) {
        if (value == null || value.isEmpty()) {
            return orderMapper.list();
        }
        return orderMapper.search(key, value);
    }

    public void save(Order order) {
        String value = UUID.randomUUID().toString();
        Jedis jedis = new Jedis("13.236.134.190",6379);
        String lua = "if redis.call(\"get\",KEYS[1])==ARGV[1] then\n" +
                "return redis.call(\"del\",KEYS[1])\n" +
                "else\n" +
                "return 0\n" +
                "end";
        String scriptLoad = jedis.scriptLoad(lua);
        int l = ((int) jedis.setnx("ticketlock", value));
        if (l == 1) {
            Integer result = orderMapper.save(order);
            if (result != 1) {
                throw new RuntimeException("Order creation failure!");
            }
            System.out.println(order.getTicketId());
            Ticket ticket = ticketsMapper.search(order.getTicketId());
            ticket.setStaN(ticket.getStaN() - order.getNum());
            Integer ticketResult = ticketsMapper.update(ticket);
            if (ticketResult != 1) {
                throw new RuntimeException("Order creation failure!");
            }
            Object evalsha = jedis.evalsha(scriptLoad, Collections.singletonList("ticketlock"), Collections.singletonList(value));
            System.out.println(evalsha);
        } else {
            System.out.println("Occupied by another thread, please try again later!");
        }
    }

    public void update(Order order) {
        Integer result = orderMapper.update(order);
        if (result != 1) {
            throw new RuntimeException("Order update failure!");
        }
    }

    public void delete(Integer id) {
        Integer result = orderMapper.delete(id);
        if (result != 1) {
            throw new RuntimeException("Order deletion failure!");
        }
    }
}
