package com.greensquare.bakingapp.utiltiy.retrofit;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.greensquare.bakingapp.models.Recipe;
import com.greensquare.bakingapp.models.Singalton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitConnection {


    private Singalton data;
    private Retrofit retrofit;
    private RetrofitAPI api;
    private ArrayList<Recipe> recipes;
    private View view;
    private final static String TAG = "RetrofitConnection:";

    public RetrofitConnection(View view){

        data = Singalton.getInstance();
        retrofit = data.getRetrofit();
        api = retrofit.create(RetrofitAPI.class);
        recipes = new ArrayList<>();
        this.view = view;
    }


    public void getRecipe(final GetRecipeCallBack callBack){

        api.getRecipe().enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if(response.isSuccessful()){

                    recipes = (ArrayList<Recipe>)response.body();
                    Log.d(TAG,"Resopnse is succesful");
                    callBack.getRecipe(recipes, true);
                }else{
                    try {
                        Log.d(TAG,"Resopnse is not succesful: " +response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    callBack.getRecipe(null, false);

                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.d(TAG,"OnFailure: ",t);
                callBack.getRecipe(null, false);
            }


        });


    }

  public interface GetRecipeCallBack{
        void getRecipe(ArrayList<Recipe> recipes, boolean successful);
    }

}
