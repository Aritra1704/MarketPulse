package com.example.marketpulse.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.repository.MarketRepo;

import java.util.ArrayList;

public class MarketVM extends ViewModel {
    private MarketRepo mRepository;
    private LiveData<ArrayList<MarketNames>> marketsLiveData;

    public MarketVM() {}

    public void init() {
        if(marketsLiveData != null)
            return;

        mRepository = MarketRepo.getInstance();
        getData();
    }

    public LiveData<ArrayList<MarketNames>> getMarketNames() { return marketsLiveData; }

    public void getData() {
        marketsLiveData = mRepository.getMarkets();
    }

}
