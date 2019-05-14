package com.greensquare.bakingapp.ui;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Recipe;
import com.greensquare.bakingapp.utiltiy.retrofit.RetrofitConnection;
import com.greensquare.bakingapp.utiltiy.widgetUtility.RecipeWidgetService;
import com.greensquare.bakingapp.utiltiy.widgetUtility.WidgetUtilityClass;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Implementation of App Widget functionality.
 */
public class RecipeWidget extends AppWidgetProvider {

    private Recipe recipe;
    private final static String TAG = "RecipeWidget";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Intent intent = new Intent(context, RecipeWidgetService.class);
        Recipe recipe = new Recipe();
        int recipeID = WidgetUtilityClass.loadRecipeID(context,appWidgetId);
        boolean empty = recipeID==-1;
       // Log.d(TAG, "The Recipe ID is "+recipeID);
        if(!empty){
            Recipe temp = WidgetUtilityClass.loadRecipe(context,recipeID);
            if(temp!=null){
                recipe = temp;
               // Log.d(TAG, "The Recipe name is "+recipe.getName());
            }else{
                recipe.setName(context.getResources().getString(R.string.empty_recip));
            }
        }else{
            recipe.setName(context.getResources().getString(R.string.empty_recip));
        }

        Intent actvityIntent = new Intent(context,RecipesActivity.class);


        actvityIntent.putExtra("WidegtID", appWidgetId);
        actvityIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        //Log.d(TAG,"WidgetID is "+appWidgetId);
        PendingIntent pending = PendingIntent.getActivity(context,0,actvityIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.recipe_widget);
        views.setTextViewText(R.id.ingredent_widget,recipe.getName());
        if(!empty) {
            views.setViewVisibility(R.id.empty_list, View.INVISIBLE);
            views.setRemoteAdapter(R.id.ingerdent_list, intent);
        }
        else {
            views.setTextViewText(R.id.empty_list, context.getResources().getString(R.string.empty_list));
            views.setViewVisibility(R.id.empty_list, View.VISIBLE);
        }
        views.setOnClickPendingIntent(R.id.ingredent_widget,pending);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context,appWidgetManager,appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {

        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        WidgetUtilityClass.deleteRecipe(context);
    }
}

