package com.greensquare.bakingapp.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.utiltiy.adptors.StepPagerAdapter;

public class StepDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);
        Singalton data = Singalton.getInstance();

        ViewPager pager = findViewById(R.id.view_pager);
        StepPagerAdapter adapter = new StepPagerAdapter(getSupportFragmentManager(),data.getSteps());
        pager.setAdapter(adapter);

    }
}
