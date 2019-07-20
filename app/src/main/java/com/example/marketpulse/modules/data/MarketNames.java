package com.example.marketpulse.modules.data;

import java.util.ArrayList;

import javax.inject.Inject;

public class MarketNames extends BaseDO {
    private int id;
    private String name;
    private String tag;
    private String color;
    private ArrayList<Criteria> criteria;

    @Inject
    public MarketNames(ArrayList<Criteria> criterias){
        this.criteria = criterias;
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

    public ArrayList<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criteria> criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "MarketNames{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", color='" + color + '\'' +
                ", criteria=" + criteria +
                '}';
    }
}
