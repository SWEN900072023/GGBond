package com.example.musiceventsystem.service;
import  com.example.musiceventsystem.datasource.TicketsMapper;
import com.example.musiceventsystem.model.Ticket;

import java.util.List;

public class TicketService {
    private TicketsMapper ticketsMapper = new TicketsMapper();

    public List<Ticket> list() {
        return this.ticketsMapper.list();
    }
}
