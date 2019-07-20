package com.example.marketpulse.modules;


import com.example.marketpulse.webservices.RetrofitService;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitModule {

    @Provides
    RetrofitService provideRetrofitService() {
        return new RetrofitService();//RetrofitService.createService(APICall.class);//new RetrofitService();
    }
}
