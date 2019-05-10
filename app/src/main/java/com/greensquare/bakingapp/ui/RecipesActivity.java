package com.greensquare.bakingapp.ui;

import android.Manifest;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Recipe;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.utiltiy.adptors.RecipeAdaptor;
import com.greensquare.bakingapp.utiltiy.retrofit.RetrofitConnection;
import com.greensquare.bakingapp.utiltiy.widgetUtility.WidgetUtilityClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private Singalton data;
    private RecyclerView rv;
    private RecipeAdaptor adaptor;
    private ArrayList<Recipe> recipesArray;
    private Parcelable savedLayout = null;
    private RetrofitConnection connect;
    RecyclerView.LayoutManager layoutManager;


    private final String LAYOUT_POSTION = "POSITION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        if(savedInstanceState!=null) {
            if (savedInstanceState.containsKey(LAYOUT_POSTION)) {
                savedLayout = savedInstanceState.getParcelable(LAYOUT_POSTION);
            }
        }
            data = Singalton.getInstance();
        rv = findViewById(R.id.recipe_rv);
        recipesArray = new ArrayList<>();
        adaptor = new RecipeAdaptor(this, recipesArray);
        if(findViewById(R.id.tablet_mood)!=null){
            int count = columnsNumber();
            data.setTablet(true);
            layoutManager = new GridLayoutManager(getApplicationContext(), count);
        }else {
            data.setTablet(false);
            layoutManager = new LinearLayoutManager(this);
        }
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adaptor);
        connect = new RetrofitConnection(rv);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int mAppWidgetId ;

        if (extras != null) {

            mAppWidgetId = (int)extras.get("WidegtID");
            Log.d("RecipeActivity","Widget ID is "+mAppWidgetId);
            data.setWidgetId(mAppWidgetId);
        }else{
            data.setWidgetId(AppWidgetManager.INVALID_APPWIDGET_ID);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        retofitFetch();
    }

    private void retofitFetch() {

        connect.getRecipe((recipes, successful) -> {

            if (successful){
                recipesArray.clear();
                recipesArray.addAll(recipes);
                adaptor.notifyDataSetChanged();
                WidgetUtilityClass.saveRecipesLocally(getApplicationContext(),recipesArray);
                if(savedLayout!=null){
                    rv.getLayoutManager().onRestoreInstanceState(savedLayout);
                }
            }else{
                Snackbar.make(rv,
                        getResources().getString(R.string.error_internet),
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction(getResources().getString(R.string.retry),
                                view -> retofitFetch())
                        .show();
            }

        });
    }

    private int columnsNumber(){
        DisplayMetrics display = getResources().getDisplayMetrics();
        int columnsCount =(int)(display.widthPixels /display.density)/200 ;

        if(columnsCount<2){
            columnsCount = 2;
        }

        return columnsCount;


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(LAYOUT_POSTION, rv.getLayoutManager().onSaveInstanceState());
    }
}
