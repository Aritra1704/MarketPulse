package com.example.marketpulse.modules.data;

import javax.inject.Inject;

public class Criteria extends BaseDO  {
    private String type;
    private String text;

    @Inject
    public Criteria(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
