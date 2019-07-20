package com.example.marketpulse.ui.criteriadetail;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketpulse.R;
import com.example.marketpulse.modules.data.Criteria;
import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.ui.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CriteriaDetailActivity extends BaseActivity {

    private View vCriteriaDetailActivity;
    private MarketNames marketName;

    @BindView(R.id.rvCriteria)
    protected RecyclerView rvCriteria;

    private CriteriaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vCriteriaDetailActivity = inflaterBase.inflate(R.layout.activity_criteria_detail, null);
        llBase.addView(vCriteriaDetailActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);

        if(getIntent().hasExtra("Criteria")) {
            marketName = (MarketNames) getIntent().getExtras().get("Criteria");
        }

        setAdapter();
        adapter.refresh(marketName.getCriteria());
    }

    private void setAdapter() {
        adapter = new CriteriaAdapter(this, new ArrayList<Criteria>());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvCriteria.setLayoutManager(mLayoutManager);
        rvCriteria.setItemAnimator(new DefaultItemAnimator());
        rvCriteria.setAdapter(adapter);
    }
}
