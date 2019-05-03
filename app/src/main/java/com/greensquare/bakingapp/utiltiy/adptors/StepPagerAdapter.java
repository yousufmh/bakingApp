package com.greensquare.bakingapp.utiltiy.adptors;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;
import com.greensquare.bakingapp.ui.StepFragment;

import java.util.ArrayList;

public class StepPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Step> steps;
    public StepPagerAdapter(FragmentManager fm,ArrayList<Step> steps) {

        super(fm);
        this.steps = steps;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int i) {
        Step step = steps.get(i);
        Singalton.getInstance().setStep(step);
        Log.d("StepPager Adapter","Current Step is "+step.getShortDescription());
        return new StepFragment();
    }

    @Override
    public int getCount() {
        return steps.size();
    }
}
