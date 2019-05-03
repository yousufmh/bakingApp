package com.greensquare.bakingapp.utiltiy.adptors;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Recipe;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;
import com.greensquare.bakingapp.ui.RecipeDetailActivity;
import com.greensquare.bakingapp.ui.StepDetailActivity;
import com.greensquare.bakingapp.ui.StepFragment;
import com.greensquare.bakingapp.ui.StepsListFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StepAdaptor extends RecyclerView.Adapter<StepAdaptor.StepVH> {


    public class StepVH extends RecyclerView.ViewHolder {


        private TextView name;

        public StepVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }

    private Context context;
    private ArrayList<Step> steps;

    public StepAdaptor(Context context, ArrayList<Step> steps){
        this.context = context;
        this.steps = steps;
    }

    @NonNull
    @Override
    public StepAdaptor.StepVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.step_item,viewGroup,false);

        return new StepVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepAdaptor.StepVH recipeVH, int i) {

        final Step step = steps.get(i);
        final Singalton data = Singalton.getInstance();
        recipeVH.name.setText(step.getShortDescription());

        recipeVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setStep(step);
                context.startActivity(new Intent(context, StepDetailActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }
}
