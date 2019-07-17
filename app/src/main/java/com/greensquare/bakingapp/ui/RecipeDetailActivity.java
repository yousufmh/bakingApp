package com.greensquare.bakingapp.ui;

import android.Manifest;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Recipe;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;
import com.greensquare.bakingapp.utiltiy.widgetUtility.RecipeWidgetService;
import com.greensquare.bakingapp.utiltiy.widgetUtility.WidgetUtilityClass;

public class RecipeDetailActivity extends AppCompatActivity {

    private FragmentManager fm;
    private final String RECIPE_ID= "RECIPE_ID";
    int mAppWidgetId ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Singalton data = Singalton.getInstance();
        Recipe recipe = data.getRecipe();
        fm = getSupportFragmentManager();
        StepsListFragment fragment = new StepsListFragment();
        fm.beginTransaction().add(R.id.fragment,fragment).commit();
        if(Singalton.getInstance().isTablet()){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            StepFragment stepFragment = new StepFragment();
            Step step = recipe.getSteps().get(0);
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

        Button ingredentBtn = findViewById(R.id.ingredient);

        ingredentBtn.setOnClickListener(view -> {

//            if (ActivityCompat.checkSelfPermission(getApplicationContext()
//                    , Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//
//                ActivityCompat.requestPermissions(RecipeDetailActivity.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100 );
//
//                return;
////            }
            mAppWidgetId = data.getWidgetId();
            if (data.getWidgetId() == AppWidgetManager.INVALID_APPWIDGET_ID) {
                Toast.makeText(getApplicationContext(),"No Widget Found", Toast.LENGTH_LONG).show();
                finishAffinity();
            }
            Intent widgetIntent = new Intent(this, RecipeWidget.class);
            widgetIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            int[] ids = AppWidgetManager.
                    getInstance(getApplication())
                    .getAppWidgetIds(new ComponentName(getApplication()
                            , RecipeWidget.class));
            AppWidgetManager appWidgetManager1 = AppWidgetManager.getInstance(getApplicationContext());
            RecipeWidget.updateAppWidget(getApplicationContext(), appWidgetManager1, mAppWidgetId);
            widgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids);
            widgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            WidgetUtilityClass.saveRecipeID(getApplicationContext(),recipe.getId(),mAppWidgetId);
            appWidgetManager1.notifyAppWidgetViewDataChanged(mAppWidgetId,R.id.ingerdent_list);
            sendBroadcast(widgetIntent);

            finishAffinity();
            Log.d("RecipeDetiles","The widget ID is "+mAppWidgetId);
            // If this activity was started with an intent without an app widget ID, finish with an error.



        });

    }


}
