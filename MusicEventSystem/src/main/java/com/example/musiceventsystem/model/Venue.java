package com.example.musiceventsystem.model;

public class Venue {
    private Integer id;
    private String name;
    private Integer sectionSta;
    private Integer sectionMos;
    private Integer sectionSea;
    private Integer sectionVip;
    private Integer sectionOth;

    public Venue(String name, Integer sectionSta, Integer sectionMos, Integer sectionSea, Integer sectionVip, Integer sectionOth) {
        this.name = name;
        this.sectionSta = sectionSta;
        this.sectionMos = sectionMos;
        this.sectionSea = sectionSea;
        this.sectionVip = sectionVip;
        this.sectionOth = sectionOth;
    }

    public Venue(Integer id, String name, Integer sectionSta, Integer sectionMos, Integer sectionSea, Integer sectionVip, Integer sectionOth) {
        this.id = id;
        this.name = name;
        this.sectionSta = sectionSta;
        this.sectionMos = sectionMos;
        this.sectionSea = sectionSea;
        this.sectionVip = sectionVip;
        this.sectionOth = sectionOth;
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

    public Integer getSectionSta() {
        return sectionSta;
    }

    public void setSectionSta(Integer sectionSta) {
        this.sectionSta = sectionSta;
    }

    public Integer getSectionMos() {
        return sectionMos;
    }

    public void setSectionMos(Integer sectionMos) {
        this.sectionMos = sectionMos;
    }

    public Integer getSectionSea() {
        return sectionSea;
    }

    public void setSectionSea(Integer sectionSea) {
        this.sectionSea = sectionSea;
    }

    public Integer getSectionVip() {
        return sectionVip;
    }

    public void setSectionVip(Integer sectionVip) {
        this.sectionVip = sectionVip;
    }

    public Integer getSectionOth() {
        return sectionOth;
    }

    public void setSectionOth(Integer sectionOth) {
        this.sectionOth = sectionOth;
    }
}
