package com.aumva.calendarmonth.test1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.joda.time.DateTime;

/**
 * Created by Abhimuktheeswarar on 01-12-2016.
 */

public class VpAdapter_1 extends FragmentStatePagerAdapter {


    private final DateTime pagerdate;

    public VpAdapter_1(FragmentManager fm) {
        super(fm);
        pagerdate = DateTime.now();
    }

    @Override
    public Fragment getItem(int position) {
        DateTime months = pagerdate.plusMonths(position);
        return TestFragment_1.newInstance(months.getMillis());
    }

    @Override
    public int getCount() {
        return 10000;
    }
}
