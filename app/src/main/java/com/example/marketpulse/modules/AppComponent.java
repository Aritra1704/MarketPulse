package com.example.marketpulse.modules;

import com.example.marketpulse.repository.MarketRepo;
import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.webservices.RetrofitService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MarketModule.class, RetrofitModule.class})
public interface AppComponent {
    void inject(MarketRepo activity);

    RetrofitService provideRetroFit();
    MarketNames vehicle();
}
