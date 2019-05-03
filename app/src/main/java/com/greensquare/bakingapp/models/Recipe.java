package com.greensquare.bakingapp.models;

import java.util.ArrayList;

public class Recipe {

    private int id;
    private String name;
    private String servings;
    private String image;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Step> steps;


    public Recipe() {
        this.id = 0;
        this.name = "";
        this.servings = "";
        this.image = "";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

}
