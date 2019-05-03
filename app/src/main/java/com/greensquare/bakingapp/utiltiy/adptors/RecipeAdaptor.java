package com.greensquare.bakingapp.utiltiy.adptors;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Recipe;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.ui.RecipeDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeAdaptor extends RecyclerView.Adapter<RecipeAdaptor.RecipeVH> {


    public class RecipeVH extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name, numOfPersons;

        public RecipeVH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            numOfPersons = itemView.findViewById(R.id.num_person);
        }
    }

    private Context context;
    private ArrayList<Recipe> recipes;

    public RecipeAdaptor(Context context, ArrayList<Recipe> recipes){
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeAdaptor.RecipeVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recipe_item,viewGroup,false);

        return new RecipeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdaptor.RecipeVH recipeVH, int i) {

        final Recipe recipe = recipes.get(i);
        final Singalton data = Singalton.getInstance();
        recipeVH.name.setText(recipe.getName());
        recipeVH.numOfPersons.setText(recipe.getServings());

        if(!recipe.getImage().equals("")) {
            Picasso.get()
                    .load(recipe.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(recipeVH.image);
        }else{
            recipeVH.image.setVisibility(View.GONE);
        }

        recipeVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setRecipe(recipe);
                data.setSteps(recipe.getSteps());
                context.startActivity(new Intent(context, RecipeDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
