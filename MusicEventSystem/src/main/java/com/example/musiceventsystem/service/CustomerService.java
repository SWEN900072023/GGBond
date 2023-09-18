package com.example.musiceventsystem.service;
import com.example.musiceventsystem.model.Customer;
import com.example.musiceventsystem.datasource.CustomerMapper;

import java.util.List;


public class CustomerService {

    private CustomerMapper customerMapper = new CustomerMapper();

    public List<Customer> list() {
        return  this.customerMapper.list();
    }

    public List<Customer> search(String key, String value) {
        if(value.isEmpty())return this.customerMapper.list();
        return this.customerMapper.search(key, value);
    }

    public void save(Customer customer) {
        Integer save = this.customerMapper.save(customer);
        if(save != 1) throw new RuntimeException("Customer creation failure!");
    }

    public void update(Customer customer) {
        Integer update = this.customerMapper.update(customer);
        if(update != 1) throw new RuntimeException("Customer edit failure!");
    }

    public void delete(Integer id) {
        Integer delete = this.customerMapper.delete(id);
        if(delete != 1) throw new RuntimeException("Customer deletion failure!");
    }





}
