package com.example.marketpulse.ui.criteriadetail;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketpulse.R;
import com.example.marketpulse.modules.data.Criteria;
import com.example.marketpulse.modules.data.Values;
import com.example.marketpulse.modules.data.Variable;
import com.example.marketpulse.viewmodel.MarketVM;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.marketpulse.modules.data.Values.TYPE_INDICATOR;
import static com.example.marketpulse.modules.data.Values.TYPE_VALUE;

public class CriteriaAdapter extends RecyclerView.Adapter<CriteriaAdapter.CriteriaHolder> {
    private final String TAG = CriteriaAdapter.class.getSimpleName().toString();
    private Context context;
    private List<Criteria> criterias;
    private MarketVM marketVM;

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

        marketVM = ViewModelProviders.of((AppCompatActivity) context).get(MarketVM.class);
    }

    @Override
    public CriteriaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.criteria_item, parent, false);

        return new CriteriaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CriteriaHolder holder, int position) {
        Criteria criterianame = criterias.get(position);
        holder.tvCriteriaName.setText(criterianame.getText());
        ArrayList<String> replaceable = marketVM.modifyString(criterianame.getText());
        if(replaceable != null && replaceable.size() > 0) {
            holder.tvCriteriaName.setText(marketVM.removeSpecialChars(criterianame, replaceable));
        }
    }

    @Override
    public int getItemCount() {
        return criterias.size();
    }


}
