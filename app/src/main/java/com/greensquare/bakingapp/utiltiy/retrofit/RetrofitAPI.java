package com.greensquare.bakingapp.utiltiy.retrofit;

import com.greensquare.bakingapp.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("baking.json")
    Call<List<Recipe>> getRecipe();

}
