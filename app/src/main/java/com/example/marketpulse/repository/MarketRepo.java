package com.example.marketpulse.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.arpaul.utilitieslib.JSONUtils;
import com.example.marketpulse.common.AppInstance;
import com.example.marketpulse.modules.AppComponent;
import com.example.marketpulse.modules.DaggerAppComponent;
import com.example.marketpulse.modules.RetrofitModule;
import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.webservices.APICall;
import com.example.marketpulse.webservices.RetrofitService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketRepo {
    private static MarketRepo repository;

    private APICall apiCalls;
    @Inject
    RetrofitService retrofitService;

    public static MarketRepo getInstance() {
        if(repository == null) {
            repository = new MarketRepo();
        }

        return repository;
    }

    public MarketRepo() {
        AppComponent appComponent = DaggerAppComponent.builder().retrofitModule(new RetrofitModule()).build();
        appComponent.inject(this);
        apiCalls = retrofitService.createService(APICall.class);
    }

    public MutableLiveData<ArrayList<MarketNames>> getMarkets() {
        final MutableLiveData<ArrayList<MarketNames>> variantData = new MutableLiveData<>();
        apiCalls.getMarketDetail().enqueue(new Callback<ArrayList<MarketNames>>() {
            @Override
            public void onResponse(Call<ArrayList<MarketNames>> call, Response<ArrayList<MarketNames>> response) {
                Log.d("onResponse", response.toString());

                try {
                    if(response.isSuccessful()) {
                        variantData.setValue(response.body());
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MarketNames>> call, Throwable t) {
                Log.d("onFailure", t.toString());
                variantData.setValue(null);
            }
        });

        return variantData;
    }
}
