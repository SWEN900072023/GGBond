package com.example.musiceventsystem.domain;

public class Venue {
    private String venueId;
    private String location;
    private int sectionStanding;
    private int sectionMosh;
    private int sectionSeated;
    private int sectionVIP;
    private int sectionOther;

    public Venue(String venueId, String location, int sectionStanding, int sectionMosh, int sectionSeated, int sectionVIP, int sectionOther) {
        this.venueId = venueId;
        this.location = location;
        this.sectionStanding = sectionStanding;
        this.sectionMosh = sectionMosh;
        this.sectionSeated = sectionSeated;
        this.sectionVIP = sectionVIP;
        this.sectionOther = sectionOther;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSectionStanding() {
        return sectionStanding;
    }

    public void setSectionStanding(int sectionStanding) {
        this.sectionStanding = sectionStanding;
    }

    public int getSectionMosh() {
        return sectionMosh;
    }

    public void setSectionMosh(int sectionMosh) {
        this.sectionMosh = sectionMosh;
    }

    public int getSectionSeated() {
        return sectionSeated;
    }

    public void setSectionSeated(int sectionSeated) {
        this.sectionSeated = sectionSeated;
    }

    public int getSectionVIP() {
        return sectionVIP;
    }

    public void setSectionVIP(int sectionVIP) {
        this.sectionVIP = sectionVIP;
    }

    public int getSectionOther() {
        return sectionOther;
    }

    public void setSectionOther(int sectionOther) {
        this.sectionOther = sectionOther;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId='" + venueId + '\'' +
                ", location='" + location + '\'' +
                ", sectionStanding=" + sectionStanding +
                ", sectionMosh=" + sectionMosh +
                ", sectionSeated=" + sectionSeated +
                ", sectionVIP=" + sectionVIP +
                ", sectionOther=" + sectionOther +
                '}';
    }
}
