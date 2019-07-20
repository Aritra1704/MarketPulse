package com.example.marketpulse.webservices;

import com.example.marketpulse.modules.data.MarketNames;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {

    @GET("/data")
    Call<ArrayList<MarketNames>> getMarketDetail();
}
