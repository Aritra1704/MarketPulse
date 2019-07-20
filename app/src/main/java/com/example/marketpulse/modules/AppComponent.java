package com.example.marketpulse.modules;

import com.example.marketpulse.MainActivity;
import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.webservices.RetrofitService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MarketModule.class, RetrofitModule.class})
public interface AppComponent {
    void inject(MainActivity activity);

    RetrofitService preferences();
    MarketNames vehicle();
}
