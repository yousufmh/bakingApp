package com.greensquare.bakingapp.utiltiy.adptors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;
import com.greensquare.bakingapp.ui.StepFragment;

import java.util.ArrayList;

public class StepPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Step> steps;

    public StepPagerAdapter(FragmentManager fm,ArrayList<Step> steps) {

        super(fm);
        this.steps = steps;
    }



    @Override
    public Fragment getItem(int i) {
        Step step = steps.get(i);


        StepFragment fragment = new StepFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", step.getId());
        bundle.putString("ShortDescription", step.getShortDescription());
        bundle.putString("Description", step.getDescription());
        bundle.putString("ThumbnailURL", step.getThumbnailURL());
        bundle.putString("VideoURL", step.getVideoURL());

        fragment.setArguments(bundle);
        Log.d("StepPager Adapter","Current Step Position "+i);
        Log.d("StepPager Adapter","Current Step is "+step.getShortDescription());
        Log.d("StepPager Adapter","Current Step Thumbnail is "+step.getThumbnailURL());
        Log.d("StepPager Adapter","Current Step Video is "+step.getVideoURL());

        return fragment;
    }

    @Override
    public int getCount() {
        return steps.size();
    }
}
