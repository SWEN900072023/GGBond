package com.example.musiceventsystem.service;
import com.example.musiceventsystem.model.Customer;
import com.example.musiceventsystem.datasource.CustomerMapper;
import com.example.musiceventsystem.datasource.UnitOfWork;
import com.example.musiceventsystem.model.Event;

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
        UnitOfWork.newCurrent();
        try {
            UnitOfWork.getCurrent().registerNew(customer);
            UnitOfWork.getCurrent().commit();
        } catch (Exception e) {
            throw new RuntimeException("Transaction failed", e);
        } finally {
            // Reset or remove the UnitOfWork from the current thread
            UnitOfWork.setCurrent(null);
        }
    }

    public void update(Customer customer) {
        UnitOfWork.newCurrent();
        try {
            UnitOfWork.getCurrent().registerDirty(customer);
            UnitOfWork.getCurrent().commit();
        } catch (Exception e) {
            throw new RuntimeException("Transaction failed", e);
        }
    }

    public void delete(Integer id) {
        UnitOfWork.newCurrent();
        try {
            Customer customerToDelete = customerMapper.findById(id);
            UnitOfWork.getCurrent().registerDeleted(customerToDelete);
            UnitOfWork.getCurrent().commit();
        } catch (Exception e) {
            throw new RuntimeException("Transaction failed", e);
        }
    }
}
