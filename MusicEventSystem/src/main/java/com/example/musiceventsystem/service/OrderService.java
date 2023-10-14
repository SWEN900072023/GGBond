package com.example.musiceventsystem.service;

import com.example.musiceventsystem.datasource.OrderMapper;
import com.example.musiceventsystem.datasource.TicketsMapper;
import com.example.musiceventsystem.model.Order;
import com.example.musiceventsystem.model.Ticket;
import com.example.musiceventsystem.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

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

    public Integer save(Order order) {
        int res = -1;
        String value = UUID.randomUUID().toString();
        JedisPool jedisPool = JedisPoolUtil.getInstance();
        Jedis jedis = jedisPool.getResource();
        String lua = "if redis.call(\"get\",KEYS[1])==ARGV[1] then\n" +
                "return redis.call(\"del\",KEYS[1])\n" +
                "else\n" +
                "return 0\n" +
                "end";
        String scriptLoad = jedis.scriptLoad(lua);
        int l = ((int) jedis.setnx("ticketlock", value));
        jedis.expire("ticketlock", 30);
        if (l == 1) {
            System.out.println(order.getTicketId());
            Ticket ticket = ticketsMapper.search(order.getTicketId());
            res = ticket.getStaN() - order.getNum();
            if (res < 0) {
                jedis.evalsha(scriptLoad, Collections.singletonList("ticketlock"), Collections.singletonList(value));
                return -1;
            }
            ticket.setStaN(res);
            Integer ticketResult = ticketsMapper.update(ticket);
            if (ticketResult != 1) {
                throw new RuntimeException("Order creation failure!");
            }
            Integer result = orderMapper.save(order);
            if (result != 1) {
                throw new RuntimeException("Order creation failure!");
            }
            jedis.evalsha(scriptLoad, Collections.singletonList("ticketlock"), Collections.singletonList(value));
        } else {
            return 0;
        }
        return 1;
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
