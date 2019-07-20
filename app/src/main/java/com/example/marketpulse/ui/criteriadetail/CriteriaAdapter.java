package com.example.marketpulse.ui.criteriadetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.marketpulse.R;
import com.example.marketpulse.modules.data.Criteria;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CriteriaAdapter extends RecyclerView.Adapter<CriteriaAdapter.CriteriaHolder> {
    private Context context;
    private List<Criteria> criterias;

    public class CriteriaHolder extends RecyclerView.ViewHolder {

        View myView;

        @BindView(R.id.tvCriteriaName)
        TextView tvCriteriaName;

        @BindView(R.id.tvCriteriaTag)
        TextView tvCriteriaTag;

        public CriteriaHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);

            myView = view;
        }
    }

    public void refresh(List<Criteria> users) {
        this.criterias = users;
        notifyDataSetChanged();
    }


    public CriteriaAdapter(Context context, List<Criteria> users) {
        this.context = context;
        this.criterias = users;
    }

    @Override
    public CriteriaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.criteria_item, parent, false);

        return new CriteriaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CriteriaHolder holder, int position) {
        Criteria marketName = criterias.get(position);
        holder.tvCriteriaName.setText(marketName.getText());
        holder.tvCriteriaTag.setText(marketName.getType());
        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return criterias.size();
    }
}
