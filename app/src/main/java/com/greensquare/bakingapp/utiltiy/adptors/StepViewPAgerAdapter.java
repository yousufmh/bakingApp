package com.greensquare.bakingapp.utiltiy.adptors;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.greensquare.bakingapp.models.Step;

import java.util.ArrayList;

public class StepViewPAgerAdapter extends PagerAdapter {

    private ArrayList<Step> steps;

   public StepViewPAgerAdapter(ArrayList<Step> steps){

       this.steps = steps;
   }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
