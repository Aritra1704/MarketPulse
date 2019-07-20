package com.example.marketpulse.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arpaul.utilitieslib.StringUtils;
import com.example.marketpulse.R;
import com.example.marketpulse.modules.data.MarketNames;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.VariantHolder> {
    private Context context;
    private List<MarketNames> marketNames;

//    private VariantVM variantVM;

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

//        variantVM = ViewModelProviders.of((AppCompatActivity) context).get(VariantVM.class);
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
        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.tvVariantName.performLongClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return marketNames.size();
    }

    public interface selectedVariant {
        public void selected(String selected);
    }
}
