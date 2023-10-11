package com.example.musiceventsystem.domain;

public class Tickets {
    private String ticketId;
    private String eventId;
    private String sectionType;
    private int soldNum;
    private String seatId;

    public Tickets(String ticketId, String eventId, String sectionType, int soldNum, String seatId) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.sectionType = sectionType;
        this.soldNum = soldNum;
        this.seatId = seatId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public int getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(int soldNum) {
        this.soldNum = soldNum;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId='" + ticketId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", sectionType='" + sectionType + '\'' +
                ", soldNum=" + soldNum +
                ", seatId='" + seatId + '\'' +
                '}';
    }
}
