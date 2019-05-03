package com.greensquare.bakingapp.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.greensquare.bakingapp.R;

public class RecipeDetailActivity extends AppCompatActivity {

    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        fm = getSupportFragmentManager();
        StepsListFragment fragment = new StepsListFragment();
        fm.beginTransaction().add(R.id.fragment,fragment).commit();

    }
}
