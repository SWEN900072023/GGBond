package com.example.musiceventsystem.model;

public class Ticket {
    private Integer id;
    private Integer eventId;
    private String eventName;
    private Integer venueId;
    private String venueName;
    private Integer staN;
    private Integer mosN;
    private Integer seaN;
    private Integer vipN;
    private Integer othN;
    private Integer staP;
    private Integer mosP;
    private Integer seaP;
    private Integer vipP;
    private Integer othP;

    public Ticket(Integer eventId, String eventName, Integer venueId, String venueName, Integer staN, Integer mosN, Integer seaN, Integer vipN, Integer othN, Integer staP, Integer mosP, Integer seaP, Integer vipP, Integer othP) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.venueId = venueId;
        this.venueName = venueName;
        this.staN = staN;
        this.mosN = mosN;
        this.seaN = seaN;
        this.vipN = vipN;
        this.othN = othN;
        this.staP = staP;
        this.mosP = mosP;
        this.seaP = seaP;
        this.vipP = vipP;
        this.othP = othP;
    }

    public Ticket(Integer id, Integer eventId, String eventName, Integer venueId, String venueName, Integer staN, Integer mosN, Integer seaN, Integer vipN, Integer othN, Integer staP, Integer mosP, Integer seaP, Integer vipP, Integer othP) {
        this.id = id;
        this.eventId = eventId;
        this.eventName = eventName;
        this.venueId = venueId;
        this.venueName = venueName;
        this.staN = staN;
        this.mosN = mosN;
        this.seaN = seaN;
        this.vipN = vipN;
        this.othN = othN;
        this.staP = staP;
        this.mosP = mosP;
        this.seaP = seaP;
        this.vipP = vipP;
        this.othP = othP;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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

    public Integer getVipP() {
        return vipP;
    }

    public void setVipP(Integer vipP) {
        this.vipP = vipP;
    }

    public Integer getOthP() {
        return othP;
    }

    public void setOthP(Integer othP) {
        this.othP = othP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaN() {
        return staN;
    }

    public void setStaN(Integer staN) {
        this.staN = staN;
    }

    public Integer getMosN() {
        return mosN;
    }

    public void setMosN(Integer mosN) {
        this.mosN = mosN;
    }

    public Integer getSeaN() {
        return seaN;
    }

    public void setSeaN(Integer seaN) {
        this.seaN = seaN;
    }

    public Integer getVipN() {
        return vipN;
    }

    public void setVipN(Integer vipN) {
        this.vipN = vipN;
    }

    public Integer getOthN() {
        return othN;
    }

    public void setOthN(Integer othN) {
        this.othN = othN;
    }
}
