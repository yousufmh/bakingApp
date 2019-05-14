package com.greensquare.bakingapp.ui;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;
import com.greensquare.bakingapp.utiltiy.adptors.StepAdaptor;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepsListFragment extends Fragment {


    public StepsListFragment() {
    }

    private StepAdaptor adaptor;
    private RecyclerView.LayoutManager layout;
    private RecyclerView rv;
    private ArrayList<Step> steps;
    private Singalton data;
    private Parcelable savedLayout = null;
    private final String LAYOUT_POSTION = "POSITION";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if(savedInstanceState!=null) {
            if (savedInstanceState.containsKey(LAYOUT_POSTION)) {
                savedLayout = savedInstanceState.getParcelable(LAYOUT_POSTION);
            }
        }

        View view = inflater.inflate(R.layout.fragment_steps_list, container, false);
        data = Singalton.getInstance();
        steps= new ArrayList<>();
        steps.addAll(data.getSteps());
        rv = view.findViewById(R.id.steps_rv);
        layout = new LinearLayoutManager(this.getActivity());
        adaptor = new StepAdaptor(this.getActivity(),steps);
        rv.setAdapter(adaptor);
        rv.setLayoutManager(layout);
        if(savedLayout!=null){
            rv.getLayoutManager().onRestoreInstanceState(savedLayout);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(LAYOUT_POSTION, rv.getLayoutManager().onSaveInstanceState());

    }


}
