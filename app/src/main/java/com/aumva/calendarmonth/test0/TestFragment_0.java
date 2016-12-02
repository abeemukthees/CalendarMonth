package com.aumva.calendarmonth.test0;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aumva.calendarmonth.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhimuktheeswarar on 01-12-2016.
 */

public class TestFragment_0 extends Fragment {


    private static final String MILLIS = "milliseconds";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy");

    @BindView(R.id.text_month)
    TextView textView_0;

    @BindView(R.id.recycler_test_0)
    RecyclerView recyclerView_0;


    private long mills;

    private Calendar calendar;


    public static TestFragment_0 newInstance(long mills) {
        TestFragment_0 testFragment_0 = new TestFragment_0();
        Bundle args = new Bundle();
        args.putLong(MILLIS, mills);
        testFragment_0.setArguments(args);
        return testFragment_0;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mills = getArguments().getLong(MILLIS, 0);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_test_0, container, false);
        ButterKnife.bind(this, rootView);
        recyclerView_0.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        recyclerView_0.setAdapter(new RvAdapter_0(mills));
        textView_0.setText(simpleDateFormat.format(calendar.getTime()));
        return rootView;
    }
}
