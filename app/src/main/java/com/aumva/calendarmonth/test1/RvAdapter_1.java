package com.aumva.calendarmonth.test1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aumva.calendarmonth.commons.RvHolder;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Abhimuktheeswarar on 28-11-2016.
 */

public class RvAdapter_1 extends RecyclerView.Adapter<RvHolder> {


    private static final String TAG = RvAdapter_1.class.getSimpleName();
    private final List<String> strings;
    private final Calendar calendar;
    String[] dayNames = new DateFormatSymbols(Locale.getDefault()).getShortWeekdays();
    List<String> numbers;

    public RvAdapter_1(long mills) {
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        this.strings = new ArrayList<>();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //calendar.set(Calendar.MONTH,2);
        //Map<String, Integer> dn = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        //Log.d(TAG, "First day of week = " + calendar.get(Calendar.DAY_OF_WEEK));
        //Log.d(TAG, "1) First day of week = " + calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        //Log.d(TAG, "2) First day of week = " + calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        //Log.d(TAG, "3) First day of week = " + calendar.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH));
        //Log.d(TAG, "Max month = " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        //Log.d(TAG, "First day of week = "+calendar.get);

        for (int i = 1; i <= 42; i++) {
            int aDay = i - 7;
            if (i <= 7) strings.add(dayNames[i]);
            else if (aDay >= calendar.get(Calendar.DAY_OF_WEEK) && aDay < calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.DAY_OF_WEEK)) {
                strings.add(String.valueOf(i - 6 - calendar.get(Calendar.DAY_OF_WEEK)));
            } else {
                strings.add(null);
            }
        }
    }


    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RvHolder(parent);
    }

    @Override
    public void onBindViewHolder(RvHolder holder, int position) {
        if (holder.getAdapterPosition() < (calendar.get(Calendar.DAY_OF_WEEK) + 6) || strings.get(holder.getAdapterPosition()) == null)
            holder.textViews.get(1).setVisibility(View.INVISIBLE);
        else holder.textViews.get(1).setVisibility(View.VISIBLE);
        holder.textViews.get(0).setText(strings.get(holder.getAdapterPosition()));
        if (numbers != null && numbers.get(holder.getAdapterPosition()) != null)
            holder.textViews.get(1).setText(numbers.get(holder.getAdapterPosition()));

    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
}
