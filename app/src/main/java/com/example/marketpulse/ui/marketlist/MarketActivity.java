package com.example.marketpulse.ui.marketlist;

import android.os.Bundle;

import com.arpaul.utilitieslib.NetworkUtility;
import com.example.marketpulse.R;
import com.example.marketpulse.modules.AppComponent;
import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.ui.BaseActivity;
import com.example.marketpulse.viewmodel.MarketVM;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketActivity extends BaseActivity {

    private View vMarketActivity;

    @BindView(R.id.tvNoData)
    protected TextView tvNoData;

    @BindView(R.id.rvMarket)
    protected RecyclerView rvMarket;

    private AppComponent component;

    private MarketVM variantVM;
    private ArrayList<MarketNames> listMarket;
    private MarketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vMarketActivity = inflaterBase.inflate(R.layout.content_main, null);
        llBase.addView(vMarketActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if(!NetworkUtility.isConnectionAvailable(this)) {
            tvNoData.setText("No Internet");
            rvMarket.setVisibility(View.GONE);
            tvNoData.setVisibility(View.VISIBLE);
        } else {
            tvNoData.setVisibility(View.GONE);
            rvMarket.setVisibility(View.VISIBLE);

            showLoader(false, "");
            initializeVM();
        }


    }

    void initializeVM() {
        variantVM = ViewModelProviders.of(this).get(MarketVM.class);
        variantVM.init();
        variantVM.getMarketNames().observe(this, markets -> {
            hideLoader();
            if(markets != null) {
                listMarket = markets;
                Log.d("getMarketNames", listMarket.size() + "");

                if(listMarket != null && listMarket.size() > 0) {
                    adapter.refresh(listMarket);
                }
            }
        });

        setAdapter();
    }

    private void setAdapter() {
        adapter = new MarketAdapter(this, new ArrayList<MarketNames>());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvMarket.setLayoutManager(mLayoutManager);
        rvMarket.setItemAnimator(new DefaultItemAnimator());
        rvMarket.setAdapter(adapter);
    }
}
