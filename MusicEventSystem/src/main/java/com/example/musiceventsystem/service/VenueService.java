package com.example.musiceventsystem.service;

import java.util.List;
import com.example.musiceventsystem.datasource.VenueMapper;
import com.example.musiceventsystem.model.Venue;

public class VenueService {
    private VenueMapper venueMapper = new VenueMapper();

    public List<Venue> list() {
        return this.venueMapper.list();
    }

    public List<Venue> search(String value) {
        if (value.equals("")) return this.venueMapper.list();
        return this.venueMapper.search(value);
    }

    public void save(Venue venue) {
        Integer save = this.venueMapper.save(venue);
        if(save != 1) throw new RuntimeException("Venue creation failure!");
    }

    public void update(Venue venue) {
        Integer save = this.venueMapper.update(venue);
        if(save != 1) throw new RuntimeException("Venue creation failure!");
    }

    public void delete(Integer id) {
        Integer delete = this.venueMapper.delete(id);
        if(delete != 1) throw new RuntimeException("Venue deletion failure!");
    }
}
