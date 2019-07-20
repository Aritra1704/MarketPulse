package com.example.marketpulse.modules.data;

import java.util.ArrayList;

import javax.inject.Inject;

public class MarketNames {
    private int id;
    private String name;
    private String tag;
    private String color;
    private ArrayList<Criteria> criterias;

    @Inject
    public MarketNames(ArrayList<Criteria> criterias){
        this.criterias = criterias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Criteria> getCriterias() {
        return criterias;
    }

    public void setCriterias(ArrayList<Criteria> criterias) {
        this.criterias = criterias;
    }

    @Override
    public String toString() {
        return "MarketNames{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", color='" + color + '\'' +
                ", criterias=" + criterias +
                '}';
    }
}
