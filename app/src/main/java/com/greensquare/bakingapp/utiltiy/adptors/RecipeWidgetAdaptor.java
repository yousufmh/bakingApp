package com.greensquare.bakingapp.utiltiy.adptors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeWidgetAdaptor extends RecyclerView.Adapter<RecipeWidgetAdaptor.RecipeVH> {


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
    private final String ADAPTER_TAG = "RecipeWidgetAdaptor";

    public RecipeWidgetAdaptor(Context context, ArrayList<Recipe> recipes){
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeWidgetAdaptor.RecipeVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recipe_item,viewGroup,true);
        Log.d(ADAPTER_TAG,"in onCreatView and the size of array is "+recipes.size());

        return new RecipeVH(view);
    }
   private RecipePosition recipePosition;
    @Override
    public void onBindViewHolder(@NonNull RecipeWidgetAdaptor.RecipeVH recipeVH, int i) {

        final Recipe recipe = recipes.get(i);
        recipeVH.name.setText(recipe.getName());
        recipeVH.numOfPersons.setText(recipe.getServings());
        Log.d(ADAPTER_TAG, "Recipe Selected is "+recipe.getName());

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
                recipePosition.onClickPosistion(recipe);

            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public interface RecipePosition{
        void onClickPosistion(Recipe position);
    }

}
