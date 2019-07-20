package com.example.marketpulse.ui;

import android.os.Bundle;

import com.example.marketpulse.R;
import com.example.marketpulse.common.AppInstance;
import com.example.marketpulse.modules.AppComponent;
import com.example.marketpulse.ui.BaseActivity;
import com.example.marketpulse.webservices.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketActivity extends BaseActivity {

    private View vMarketActivity;

    @BindView(R.id.rvMarket)
    protected RecyclerView rvMarket;

    private AppComponent component;

    @Inject
    RetrofitService apiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vMarketActivity = inflaterBase.inflate(R.layout.content_main, null);
        llBase.addView(vMarketActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ((AppInstance) getApplicationContext()).getComponent().inject(this);

    }

}
