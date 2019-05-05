package com.greensquare.bakingapp.ui;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;

public class RecipeDetailActivity extends AppCompatActivity {

    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        fm = getSupportFragmentManager();
        StepsListFragment fragment = new StepsListFragment();
        fm.beginTransaction().add(R.id.fragment,fragment).commit();
        if(Singalton.getInstance().isTablet()){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            StepFragment stepFragment = new StepFragment();
            Step step = Singalton.getInstance().getRecipe().getSteps().get(0);
            Bundle bundle = new Bundle();
            bundle.putInt("id", step.getId());
            bundle.putString("ShortDescription", step.getShortDescription());
            bundle.putString("Description", step.getDescription());
            bundle.putString("ThumbnailURL", step.getThumbnailURL());
            bundle.putString("VideoURL", step.getVideoURL());
            stepFragment.setArguments(bundle);
            fm.beginTransaction().add(R.id.step_detail,stepFragment).commit();

        }
        else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }
}
