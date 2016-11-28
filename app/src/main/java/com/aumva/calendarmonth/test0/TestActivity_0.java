package com.aumva.calendarmonth.test0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aumva.calendarmonth.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity_0 extends AppCompatActivity {


    @BindView(R.id.recycler_test_0)
    RecyclerView recyclerView_0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_0);
        ButterKnife.bind(this);
        recyclerView_0.setLayoutManager(new GridLayoutManager(this, 7));
        recyclerView_0.setAdapter(new RvAdapter_0());
        //recyclerView_0.addItemDecoration(new GridDividerDecoration(this));
        //recyclerView_0.addItemDecoration(new DividerItemDecoration(this,0 ));
    }
}
