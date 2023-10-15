package com.example.musiceventsystem.model;

public class Event {
    private Integer id;
    private String name;
    private Integer venue_id;
    private String venue;
    private String date;
    private Integer staP;
    private Integer mosP;
    private Integer seaP;
    private Integer vipP;
    private Integer othP;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    private Integer version;



    public Event(String name, Integer venue_id, String date, Integer staP, Integer mosP, Integer seaP, Integer vipP, Integer othP) {
        this.name = name;
        this.venue_id = venue_id;
        this.date = date;
        this.staP = staP;
        this.mosP = mosP;
        this.seaP = seaP;
        this.vipP = vipP;
        this.othP = othP;
    }

    public Event(Integer id, String name, Integer venue_id, String venue, String date, Integer staP, Integer mosP, Integer seaP, Integer vipP, Integer othP, Integer version) {
        this.id = id;
        this.name = name;
        this.venue_id = venue_id;
        this.venue = venue;
        this.date = date;
        this.staP = staP;
        this.mosP = mosP;
        this.seaP = seaP;
        this.vipP = vipP;
        this.othP = othP;
        this.version = version;
    }

    public Event(Integer id, String name, Integer venue_id, String date, Integer staP, Integer mosP, Integer seaP, Integer vipP, Integer othP, Integer version) {
        this.id = id;
        this.name = name;
        this.venue_id = venue_id;
        this.date = date;
        this.staP = staP;
        this.mosP = mosP;
        this.seaP = seaP;
        this.vipP = vipP;
        this.othP = othP;
        this.version = version;
    }

    public Integer getVipP() {
        return vipP;
    }

    public void setVipP(Integer vipP) {
        this.vipP = vipP;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Integer venue_id) {
        this.venue_id = venue_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStaP() {
        return staP;
    }

    public void setStaP(Integer staP) {
        this.staP = staP;
    }

    public Integer getMosP() {
        return mosP;
    }

    public void setMosP(Integer mosP) {
        this.mosP = mosP;
    }

    public Integer getSeaP() {
        return seaP;
    }

    public void setSeaP(Integer seaP) {
        this.seaP = seaP;
    }

    public Integer getOthP() {
        return othP;
    }

    public void setOthP(Integer othP) {
        this.othP = othP;
    }
}
