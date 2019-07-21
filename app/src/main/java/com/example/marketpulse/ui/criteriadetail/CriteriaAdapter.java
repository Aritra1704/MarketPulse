package com.example.marketpulse.ui.criteriadetail;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.marketpulse.R;
import com.example.marketpulse.modules.data.Criteria;
import com.example.marketpulse.modules.data.Values;
import com.example.marketpulse.modules.data.Variable;

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
        Criteria criterianame = criterias.get(position);
        holder.tvCriteriaName.setText(criterianame.getText());
        if((position + 1) != criterias.size())
            holder.tvCriteriaTag.setText("and");
        else
            holder.tvCriteriaTag.setVisibility(View.GONE);

        ArrayList<String> replaceable = modifyString(criterianame.getText());
        if(replaceable != null && replaceable.size() > 0) {
            String criteria = criterianame.getText();
            for (String replace : replaceable) {
                if(!TextUtils.isEmpty(replace) && criterianame.getVariable() != null) {
                    Values select = null;
                    switch (replace) {
                        case "$1" :
                            select = criterianame.getVariable().get$1();
                            break;
                        case "$2" :
                            select = criterianame.getVariable().get$2();
                            break;
                        case "$3" :
                            select = criterianame.getVariable().get$3();
                            break;
                        case "$4" :
                            select = criterianame.getVariable().get$4();
                            break;
                    }
                    if(select != null ) {
                        if(select.getType().equalsIgnoreCase(TYPE_VALUE) && select.getValues() != null && select.getValues().size() > 0) {
                            criteria = criteria.replace(replace, select.getValues().get(0) + "");
                        } else if(select.getType().equalsIgnoreCase(TYPE_INDICATOR)) {
                            criteria = criteria.replace(replace, select.getDefault_value() + "");
                        }
                        holder.tvCriteriaName.setText(criteria);
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return criterias.size();
    }

    private ArrayList<String> modifyString(String input) {
        ArrayList<String> result = new ArrayList<>();

        String regex = "[$][1-9]";
        Pattern namePtrn = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = namePtrn.matcher(input);

        while (matcher.find()) {
            String find = matcher.group(0);
            result.add(find);
        }
        return result;
    }
}
