package com.greensquare.bakingapp.ui;

import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Recipe;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.utiltiy.adptors.RecipeAdaptor;
import com.greensquare.bakingapp.utiltiy.retrofit.RetrofitConnection;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity {

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

    }

    @Override
    protected void onStart() {
        super.onStart();
        retofitFetch();
    }

    private void retofitFetch() {

        connect.getRecipe(new RetrofitConnection.GetRecipeCallBack() {
            @Override
            public void getRecipe(ArrayList<Recipe> recipes, boolean successful) {

                if (successful){
                    recipesArray.clear();
                    recipesArray.addAll(recipes);
                    adaptor.notifyDataSetChanged();
                    if(savedLayout!=null){
                        rv.getLayoutManager().onRestoreInstanceState(savedLayout);
                    }
                }else{
                    Snackbar.make(rv,
                            getResources().getString(R.string.error_internet),
                            Snackbar.LENGTH_INDEFINITE)
                            .setAction(getResources().getString(R.string.retry),
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            retofitFetch();
                                        }
                                    })
                            .show();
                }

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
