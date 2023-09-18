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
        if (value.isEmpty()) return this.venueMapper.list();
        return this.venueMapper.search(value);
    }
}
