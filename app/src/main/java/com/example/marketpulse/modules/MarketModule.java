package com.example.marketpulse.modules;

import com.example.marketpulse.modules.data.Criteria;
import com.example.marketpulse.modules.data.MarketNames;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class MarketModule {

    @Provides
    ArrayList<Criteria> provideCriterias() {
        return new ArrayList<>();
    }

    @Provides
    MarketNames provideVehicle() {
        return new MarketNames(new Criteria());
    }
}
