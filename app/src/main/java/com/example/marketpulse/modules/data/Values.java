package com.example.marketpulse.modules.data;

import java.util.ArrayList;

import javax.inject.Inject;

public class Values extends BaseDO  {

    private String type;
    private String study_type;
    private String parameter_name;
    private float min_value;
    private float max_value;
    private float default_value;

    private ArrayList<Float> values;

    @Inject
    public Values(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Float> getValues() {
        return values;
    }

    public void setValues(ArrayList<Float> values) {
        this.values = values;
    }

    public String getStudy_type() {
        return study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }

    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public float getMin_value() {
        return min_value;
    }

    public void setMin_value(float min_value) {
        this.min_value = min_value;
    }

    public float getMax_value() {
        return max_value;
    }

    public void setMax_value(float max_value) {
        this.max_value = max_value;
    }

    public float getDefault_value() {
        return default_value;
    }

    public void setDefault_value(float default_value) {
        this.default_value = default_value;
    }

    @Override
    public String toString() {
        return "Values{" +
                "type='" + type + '\'' +
                ", study_type='" + study_type + '\'' +
                ", parameter_name='" + parameter_name + '\'' +
                ", min_value=" + min_value +
                ", max_value=" + max_value +
                ", default_value=" + default_value +
                ", values=" + values +
                '}';
    }

    public static final String TYPE_INDICATOR = "indicator";
    public static final String TYPE_VALUE = "value";
}
