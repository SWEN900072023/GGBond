package com.example.musiceventsystem.service;

import com.example.musiceventsystem.datasource.OrderMapper;
import com.example.musiceventsystem.model.Order;

import java.util.List;

public class OrderService {
    private OrderMapper orderMapper = new OrderMapper();

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
        Integer result = orderMapper.save(order);
        if (result != 1) {
            throw new RuntimeException("Order creation failure!");
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
