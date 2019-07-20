package com.example.marketpulse.modules.data;

import javax.inject.Inject;

public class Criteria {
    private int rpm = 10;

    @Inject
    public Criteria(){
        this.rpm = 10;
    }

    public int getRpm(){
        return rpm;
    }

    public void accelerate(int value){
        rpm = rpm + value;
    }

    public void brake(){
        rpm = 0;
    }
}
