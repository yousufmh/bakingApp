package com.greensquare.bakingapp.models;

import android.content.Context;


import com.google.android.exoplayer2.SimpleExoPlayer;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singalton {

    private static Singalton instance;

    private Retrofit retrofit;
    private Recipe recipe;
    private ArrayList<Recipe> recipes;
    private Ingredient ingredient;
    private ArrayList<Ingredient> ingredients;
    private Step step;
    private ArrayList<Step> steps;
    private SimpleExoPlayer exoPlayer;
    private boolean isTablet;


    private Singalton(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        recipe = new Recipe();
        recipes = new ArrayList<>();
        ingredient = new Ingredient();
        ingredients = new ArrayList<>();
        step = new Step();
        steps = new ArrayList<>();
        isTablet = false;

    }

    public static synchronized Singalton getInstance (){

        if(instance ==null){
            instance = new Singalton();
        }
        return instance;
    }

    public SimpleExoPlayer getExoPlayer() {
        return exoPlayer;
    }

    public void setExoPlayer(SimpleExoPlayer exoPlayer) {
        this.exoPlayer = exoPlayer;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public boolean isTablet() {
        return isTablet;
    }

    public void setTablet(boolean tablet) {
        isTablet = tablet;
    }
}
