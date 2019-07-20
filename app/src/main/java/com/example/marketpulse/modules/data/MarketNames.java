package com.example.marketpulse.modules.data;

import javax.inject.Inject;

public class MarketNames {
    private Criteria motor;

    @Inject
    public MarketNames(Criteria motor){
        this.motor = motor;
    }

    public void increaseSpeed(int value){
        motor.accelerate(value);
    }

    public void stop(){
        motor.brake();
    }

    public int getSpeed(){
        return motor.getRpm();
    }
}
