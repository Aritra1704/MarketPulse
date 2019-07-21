package com.example.marketpulse.modules.data;

import androidx.annotation.Nullable;

import javax.inject.Inject;

public class Criteria extends BaseDO  {
    private String type;
    private String text;

    @Nullable
    private Variable variable;

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

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", variable=" + variable +
                '}';
    }
}
