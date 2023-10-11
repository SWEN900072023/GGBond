package com.example.musiceventsystem.domain;

public class Event {
    private String eventId;
    private String plannerId;
    private String venueId;
    private float standingPrice;
    private float moshPrice;
    private float seatedPrice;
    private float vipPrice;
    private float otherPrice;

    public Event(String eventId, String plannerId, String venueId, float standingPrice, float moshPrice, float seatedPrice, float vipPrice, float otherPrice) {
        this.eventId = eventId;
        this.plannerId = plannerId;
        this.venueId = venueId;
        this.standingPrice = standingPrice;
        this.moshPrice = moshPrice;
        this.seatedPrice = seatedPrice;
        this.vipPrice = vipPrice;
        this.otherPrice = otherPrice;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(String plannerId) {
        this.plannerId = plannerId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public float getStandingPrice() {
        return standingPrice;
    }

    public void setStandingPrice(float standingPrice) {
        this.standingPrice = standingPrice;
    }

    public float getMoshPrice() {
        return moshPrice;
    }

    public void setMoshPrice(float moshPrice) {
        this.moshPrice = moshPrice;
    }

    public float getSeatedPrice() {
        return seatedPrice;
    }

    public void setSeatedPrice(float seatedPrice) {
        this.seatedPrice = seatedPrice;
    }

    public float getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(float vipPrice) {
        this.vipPrice = vipPrice;
    }

    public float getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(float otherPrice) {
        this.otherPrice = otherPrice;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", plannerId='" + plannerId + '\'' +
                ", venueId='" + venueId + '\'' +
                ", standingPrice=" + standingPrice +
                ", moshPrice=" + moshPrice +
                ", seatedPrice=" + seatedPrice +
                ", vipPrice=" + vipPrice +
                ", otherPrice=" + otherPrice +
                '}';
    }
}
