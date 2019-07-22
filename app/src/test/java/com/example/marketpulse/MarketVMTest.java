package com.example.marketpulse;

import com.example.marketpulse.modules.data.Criteria;
import com.example.marketpulse.modules.data.Values;
import com.example.marketpulse.modules.data.Variable;
import com.example.marketpulse.viewmodel.MarketVM;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.marketpulse.modules.data.Values.TYPE_VALUE;
import static org.junit.Assert.assertEquals;

public class MarketVMTest {
    MarketVM marketVm = new MarketVM();

    @Test
    public void modifyStringTest() {
        String input = "Max of last 5 days close \\u003e Max of last 120 days close by $1 %";
        ArrayList<String> actual = marketVm.modifyString(input);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("$1");

        assertEquals(expected, actual);
    }

    @Test
    public void removeSpecialCharsTest() {

        ArrayList<String> replaceable = new ArrayList<>();
        replaceable.add("$1");
        Criteria criteria = new Criteria();
        criteria.setText("Max of last 5 days close \\u003e Max of last 120 days close by $1 %");
        Variable variable = new Variable();
        Values values = new Values();
        ArrayList<Float> val = new ArrayList<>();
        val.add(2f);
        val.add(1f);
        val.add(3f);
        val.add(5f);
        values.setValues(val);
        values.setType(TYPE_VALUE);
        variable.set$1(values);
        criteria.setVariable(variable);


        String expected = "Max of last 5 days close \\u003e Max of last 120 days close by 2.0 %";
        String actual = marketVm.removeSpecialChars(criteria, replaceable);
        assertEquals(expected, actual);
    }
}
