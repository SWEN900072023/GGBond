package com.example.musiceventsystem.service;

import java.util.List;
import com.example.musiceventsystem.model.Planner;
import com.example.musiceventsystem.datasource.PlannerMapper;


public class PlannerService {
    private PlannerMapper plannerMapper = new PlannerMapper();

    public List<Planner> list() {
        return this.plannerMapper.list();
    }

    public List<Planner> search(String key, String value) {
        if(value.equals(""))return this.plannerMapper.list();
        return this.plannerMapper.search(key, value);
    }

    public void save(Planner planner) {
        Integer save = this.plannerMapper.save(planner);
        if(save != 1) throw new RuntimeException("Planner creation failure!");
    }

    public void update(Planner planner) {
        Integer update = this.plannerMapper.update(planner);
        if(update != 1) throw new RuntimeException("Planner edit failure!");
    }

    public void delete(Integer id) {
        Integer delete = this.plannerMapper.delete(id);
        if(delete != 1) throw new RuntimeException("Planner deletion failure!");
    }
}
