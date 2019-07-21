package com.example.marketpulse.viewmodel;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.marketpulse.modules.data.Criteria;
import com.example.marketpulse.modules.data.MarketNames;
import com.example.marketpulse.modules.data.Values;
import com.example.marketpulse.repository.MarketRepo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.marketpulse.modules.data.Values.TYPE_INDICATOR;
import static com.example.marketpulse.modules.data.Values.TYPE_VALUE;

public class MarketVM extends ViewModel {
    private MarketRepo mRepository;
    private LiveData<ArrayList<MarketNames>> marketsLiveData;

    public MarketVM() {}

    public void init() {
        if(marketsLiveData != null)
            return;

        mRepository = MarketRepo.getInstance();
        getData();
    }

    public LiveData<ArrayList<MarketNames>> getMarketNames() { return marketsLiveData; }

    public void getData() {
        marketsLiveData = mRepository.getMarkets();
    }

    public ArrayList<String> modifyString(String input) {
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

    public String removeSpecialChars(Criteria criterianame, ArrayList<String> replaceable) {
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

                }
            }
        }
        return criteria;
    }
}
