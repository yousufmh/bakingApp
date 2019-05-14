package com.greensquare.bakingapp.ui;

import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.utiltiy.adptors.StepPagerAdapter;

public class StepDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);
        Singalton data = Singalton.getInstance();

        //int position = data.getSteps().indexOf(data.getStep());

        ViewPager pager = findViewById(R.id.view_pager);
        StepPagerAdapter adapter = new StepPagerAdapter(getSupportFragmentManager(),data.getSteps());
        pager.setAdapter(adapter);
        int position = data.getSteps().indexOf(data.getStep());
        pager.setCurrentItem(position);

    }
}
