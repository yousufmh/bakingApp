package com.greensquare.bakingapp.ui;


import android.os.Bundle;
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
        // Required empty public constructor
    }

    private StepAdaptor adaptor;
    private RecyclerView.LayoutManager layout;
    private ArrayList<Step> steps;
    private Singalton data;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_steps_list, container, false);
        data = Singalton.getInstance();
        steps= new ArrayList<>();
        steps.addAll(data.getSteps());
        RecyclerView rv = view.findViewById(R.id.steps_rv);
        layout = new LinearLayoutManager(this.getActivity());
        adaptor = new StepAdaptor(this.getActivity(),steps);
        rv.setAdapter(adaptor);
        rv.setLayoutManager(layout);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
