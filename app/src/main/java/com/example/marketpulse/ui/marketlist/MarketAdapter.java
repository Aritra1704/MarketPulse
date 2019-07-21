package com.example.marketpulse.ui.marketlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arpaul.utilitieslib.ColorUtils;
import com.example.marketpulse.R;
import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.ui.criteriadetail.CriteriaDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.VariantHolder> {
    private Context context;
    private List<MarketNames> marketNames;

//    private MarketVM variantVM;

    public class VariantHolder extends RecyclerView.ViewHolder {

        View myView;

        @BindView(R.id.tvMarketName)
        TextView tvMarketName;

        @BindView(R.id.tvMarketTag)
        TextView tvMarketTag;

        public VariantHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);

            myView = view;
        }
    }

    public void refresh(List<MarketNames> users) {
        this.marketNames = users;
        notifyDataSetChanged();
    }


    public MarketAdapter(Context context, List<MarketNames> users) {
        this.context = context;
        this.marketNames = users;

//        variantVM = ViewModelProviders.of((AppCompatActivity) context).get(MarketVM.class);
    }

    @Override
    public VariantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_item, parent, false);

        return new VariantHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VariantHolder holder, int position) {
        MarketNames marketName = marketNames.get(position);
        holder.tvMarketName.setText(marketName.getName());
        holder.tvMarketTag.setText(marketName.getTag());
        if(marketName.getColor().equalsIgnoreCase("green"))
            holder.tvMarketTag.setTextColor(ColorUtils.getColor(context, R.color.colorGreen));
        else if(marketName.getColor().equalsIgnoreCase("red"))
            holder.tvMarketTag.setTextColor(ColorUtils.getColor(context, R.color.colorRed));

        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CriteriaDetailActivity.class);
                intent.putExtra("Criteria", marketName);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return marketNames.size();
    }
}
