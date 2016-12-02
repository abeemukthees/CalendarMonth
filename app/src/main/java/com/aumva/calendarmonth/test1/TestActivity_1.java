package com.aumva.calendarmonth.test1;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aumva.calendarmonth.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity_1 extends AppCompatActivity {


    @BindView(R.id.viewPager_test_0)
    ViewPager viewPager_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_0);
        ButterKnife.bind(this);
        viewPager_1.setAdapter(new VpAdapter_1(getSupportFragmentManager()));
        //recyclerView_1.setAdapter(new RvAdapter_0());
        //recyclerView_1.addItemDecoration(new GridDividerDecoration(this));
        //recyclerView_1.addItemDecoration(new DividerItemDecoration(this,0 ));
    }
}
