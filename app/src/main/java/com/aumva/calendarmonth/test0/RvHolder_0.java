package com.aumva.calendarmonth.test0;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aumva.calendarmonth.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhimuktheeswarar on 28-11-2016.
 */

public class RvHolder_0 extends RecyclerView.ViewHolder {

    @BindView(R.id.text_day_0)
    TextView textView_0;


    public RvHolder_0(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_0, parent, false));
        ButterKnife.bind(this, itemView);
    }
}
