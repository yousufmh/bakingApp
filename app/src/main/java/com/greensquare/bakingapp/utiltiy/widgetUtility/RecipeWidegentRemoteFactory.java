package com.greensquare.bakingapp.utiltiy.widgetUtility;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Ingredient;
import com.greensquare.bakingapp.models.Recipe;

import java.util.ArrayList;

public class RecipeWidegentRemoteFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context context;
    private ArrayList<Ingredient> ingredients;
    private Recipe recipe;
    private int widgetID;


    public RecipeWidegentRemoteFactory(Context applicationContext, Intent intent) {

        context = applicationContext;
        Bundle extras = intent.getExtras();

        if (extras != null) {

            widgetID = (int)extras.get(AppWidgetManager.EXTRA_APPWIDGET_ID);
            Log.d("RecipeWidegentRemoteFactory","Widget ID is "+widgetID);
        }else{
            widgetID = AppWidgetManager.INVALID_APPWIDGET_ID;
        }

    }

    @Override
    public void onCreate() {

       int recipeID =  WidgetUtilityClass.loadRecipeID(context,widgetID);
       if(recipeID!=-1) {
           recipe = WidgetUtilityClass.loadRecipe(context, recipeID);
           if(recipe!=null) {
               ingredients = new ArrayList<>();
               ingredients.addAll(recipe.getIngredients());
           }
       }
    }

    @Override
    public void onDataSetChanged() {

        ingredients.clear();

        int recipeID =  WidgetUtilityClass.loadRecipeID(context,widgetID);
        if(recipeID!=-1) {
            recipe = WidgetUtilityClass.loadRecipe(context, recipeID);
            if(recipe!=null) {
                ingredients = new ArrayList<>();
                ingredients.addAll(recipe.getIngredients());
            }
        }


    }

    @Override
    public void onDestroy() {
        ingredients.clear();
    }

    @Override
    public int getCount() {
        return ingredients.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_list_item);

        Ingredient ingredient = ingredients.get(i);

        views.setTextViewText(R.id.ingredent_name,ingredient.getIngredient());
        views.setTextViewText(R.id.quantity,ingredient.getQuantity()+"");
        views.setTextViewText(R.id.measure,ingredient.getMeasure());

        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


}
