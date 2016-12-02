package com.aumva.calendarmonth.test1;

import android.os.Bundle;
import android.os.Handler;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Abhimuktheeswarar on 01-12-2016.
 */

public class TestFragment_1 extends Fragment {


    private static final String MILLIS = "milliseconds";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy");

    @BindView(R.id.text_month)
    TextView textView_1;

    @BindView(R.id.recycler_test_0)
    RecyclerView recyclerView_1;

    RvAdapter_1 rvAdapter_1;

    private long mills;

    private Calendar calendar;

    List<String> numbersList;


    public static TestFragment_1 newInstance(long mills) {
        TestFragment_1 testFragment_1 = new TestFragment_1();
        Bundle args = new Bundle();
        args.putLong(MILLIS, mills);
        testFragment_1.setArguments(args);
        return testFragment_1;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mills = getArguments().getLong(MILLIS, 0);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        rvAdapter_1 = new RvAdapter_1(mills);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_test_0, container, false);
        ButterKnife.bind(this, rootView);
        recyclerView_1.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        recyclerView_1.setAdapter(rvAdapter_1);
        textView_1.setText(simpleDateFormat.format(calendar.getTime()));
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                load();
            }
        }, 1500);
    }

    @OnClick(R.id.button_load)
    void load() {
        numbersList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            numbersList.add(String.valueOf(i));
        }
        rvAdapter_1.setNumbers(numbersList);

    }
}
