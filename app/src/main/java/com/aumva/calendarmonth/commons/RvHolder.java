package com.aumva.calendarmonth.commons;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aumva.calendarmonth.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by Abhimuktheeswarar on 28-11-2016.
 */

public class RvHolder extends RecyclerView.ViewHolder {

    @BindViews({R.id.text_day_0,R.id.text_count})
    public List<TextView> textViews;


    public RvHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_0, parent, false));
        ButterKnife.bind(this, itemView);
    }
}
