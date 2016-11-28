package com.aumva.calendarmonth.test0;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Abhimuktheeswarar on 28-11-2016.
 */

public class RvAdapter_0 extends RecyclerView.Adapter<RvHolder_0> {


    private static final String TAG = RvAdapter_0.class.getSimpleName();
    private final List<String> strings;
    private final Calendar calendar;
    String[] dayNames = new DateFormatSymbols(Locale.getDefault()).getShortWeekdays();

    public RvAdapter_0() {
        calendar = Calendar.getInstance();
        //Map<String, Integer> dn = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        //Log.d(TAG, dn);
        this.strings = new ArrayList<>();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        for (int i = calendar.get(Calendar.DAY_OF_MONTH); i <= 42; i++) {
            if (i <= 7) strings.add(dayNames[i]);
            else strings.add(String.valueOf(i-7));
        }
    }


    @Override
    public RvHolder_0 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RvHolder_0(parent);
    }

    @Override
    public void onBindViewHolder(RvHolder_0 holder, int position) {
        holder.textView_0.setText(strings.get(holder.getAdapterPosition()));

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
}
