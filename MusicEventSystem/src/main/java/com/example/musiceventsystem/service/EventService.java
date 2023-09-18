package com.example.musiceventsystem.service;

import com.example.musiceventsystem.datasource.TicketsMapper;
import com.example.musiceventsystem.datasource.VenueMapper;
import com.example.musiceventsystem.datasource.EventPlannerMapper;
import com.example.musiceventsystem.datasource.EventMapper;
import com.example.musiceventsystem.model.Ticket;
import com.example.musiceventsystem.model.Event;


import java.util.List;

public class EventService {
    private TicketsMapper ticketsMapper = new TicketsMapper();
    private VenueMapper venueMapper = new VenueMapper();

    private EventPlannerMapper eventPlannerMapper = new EventPlannerMapper();

    private EventMapper eventMapper = new EventMapper();

    public List<Event> list() {
        return this.eventMapper.list();
    }

    public void save(Event event, Integer plannerId) {
        Integer eventId = eventMapper.save(event);
        if(eventId < 0){
            throw new RuntimeException("Event creation failure!");
        };
        if(eventPlannerMapper.save(eventId, plannerId) != 1){
            throw new RuntimeException("Event associate with planner failure!");
        }
        Ticket ticket = venueMapper.generateTicket(event.getVenue_id());
        ticket.setId(eventId);
        if(ticketsMapper.save(ticket) != 1){
            throw new RuntimeException("Ticket creation failure!");
        }
    }

    public void delete(Integer id) {
        if (this.eventMapper.delete(id) != 1) {
            throw new RuntimeException("Planner deletion failure!");
        }
    }
}
