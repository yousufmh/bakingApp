package com.greensquare.bakingapp.models;

public class Ingredient {

    private double quantity;
    private String measure;
    private String ingredient;

    public Ingredient() {
        this.quantity = 0;
        this.measure = "";
        this.ingredient = "";
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
