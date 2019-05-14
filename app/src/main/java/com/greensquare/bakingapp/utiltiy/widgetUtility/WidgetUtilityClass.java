package com.greensquare.bakingapp.utiltiy.widgetUtility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greensquare.bakingapp.models.Recipe;

import java.util.ArrayList;
import java.util.Arrays;

public class WidgetUtilityClass {

    private static final String PREFS_NAME = "com.greensquare.bakingapp.ui.RecipeWidget";
    private static final String RCEIPE_ID = "RCEIPE_ID";
    private static final String RCEIPE_LIST = "RCEIPE_LIST";
    private static final String CLASS_TAG = "WIDGET_CONFIGURATION";


       public static void saveRecipeID(Context context,  int recipeID,int widgetID) {

           SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor prefs = sharedPreferences.edit();
        prefs.putInt(RCEIPE_ID + widgetID, recipeID);
        prefs.apply();
    }

    public static void saveRecipesLocally(Context context, ArrayList<Recipe> recipesArray){

            Gson gson = new GsonBuilder().create();
            String recipeArray = gson.toJson(recipesArray).trim();
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor prefs = sharedPreferences.edit();
            prefs.putString(RCEIPE_LIST ,recipeArray);
            prefs.apply();
            Log.d("Recipes_Activity","Inside Writing finished");

    }



   public static int loadRecipeID(Context context, int widgetId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        int recipeID = prefs.getInt(RCEIPE_ID + widgetId, -1);
        if (recipeID != -1) {
            return recipeID;
        } else {
            return -1;
        }
    }

    public static Recipe loadRecipe(Context context,int recipeID)  {



            Gson gson = new GsonBuilder().create();

        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        String recipeArray = prefs.getString(RCEIPE_LIST , null);


        if(recipeArray==null)
            return null;
            Recipe[] recipesArray = gson.fromJson(recipeArray,Recipe[].class);

            Log.d(CLASS_TAG, "Recipe Array extracted and recipe ID is "+recipesArray[0].getId());
            ArrayList<Recipe> recipes = new ArrayList<>(Arrays.asList(recipesArray));
            for (Recipe temp:recipes) {
                if (temp.getId()==recipeID){
                    Log.d(CLASS_TAG, "Recipe Found and recipe ID is "+temp.getId());

                    return temp;
                }
            }


        return null;
    }

    public static void deleteRecipe(Context context) {
        SharedPreferences.Editor prefs = context.getSharedPreferences(PREFS_NAME, 0).edit();
        prefs.remove(RCEIPE_ID);
        prefs.apply();

    }


}
