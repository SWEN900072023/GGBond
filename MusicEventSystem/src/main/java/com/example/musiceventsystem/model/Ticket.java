package com.example.musiceventsystem.model;

public class Ticket{
    private Integer id;
    private Integer staN;
    private Integer mosN;
    private Integer seaN;
    private Integer vipN;
    private Integer othN;

    public Ticket(Integer staN, Integer mosN, Integer seaN, Integer vipN, Integer othN) {
        this.staN = staN;
        this.mosN = mosN;
        this.seaN = seaN;
        this.vipN = vipN;
        this.othN = othN;
    }

    public Ticket(Integer id, Integer staN, Integer mosN, Integer seaN, Integer vipN, Integer othN) {
        this.id = id;
        this.staN = staN;
        this.mosN = mosN;
        this.seaN = seaN;
        this.vipN = vipN;
        this.othN = othN;
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
