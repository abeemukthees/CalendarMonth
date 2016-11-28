package com.aumva.calendarmonth.test0;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        this.strings = new ArrayList<>();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //Map<String, Integer> dn = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        Log.d(TAG, "First day of week = " + calendar.get(Calendar.DAY_OF_WEEK));
        Log.d(TAG, "1) First day of week = " + calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        Log.d(TAG, "2) First day of week = " + calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Log.d(TAG, "3) First day of week = " + calendar.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH));
        Log.d(TAG, "Max month = " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        //Log.d(TAG, "First day of week = "+calendar.get);

        for (int i = 1; i <= 42; i++) {
            int aDay = i - 7;
            if (i <= 7) strings.add(dayNames[i]);
            /*else if (aDay>=calendar.get(Calendar.DAY_OF_WEEK)){

                if (aDay<=calendar.getActualMaximum(Calendar.DAY_OF_MONTH))  strings.add(String.valueOf(i - 6 - calendar.get(Calendar.DAY_OF_WEEK)));
                else strings.add(null);

            }else strings.add(null);*/

            else if (aDay >= calendar.get(Calendar.DAY_OF_WEEK) && aDay < calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.DAY_OF_WEEK)) {
                strings.add(String.valueOf(i - 6 - calendar.get(Calendar.DAY_OF_WEEK)));
            } else {
                strings.add(null);
            }
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
