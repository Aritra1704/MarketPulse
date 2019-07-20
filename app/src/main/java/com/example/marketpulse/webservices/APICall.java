package com.example.marketpulse.webservices;

import com.example.marketpulse.modules.data.MarketNames;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {

    @GET
    Call<MarketNames> getTrackDevice();
}
