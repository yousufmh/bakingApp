package com.greensquare.bakingapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepFragment extends Fragment {


    public StepFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step, container, false);
        Singalton data = Singalton.getInstance();
        Step step = data.getStep();
        TextView name = view.findViewById(R.id.name);
        name.setText(step.getShortDescription());

        return view;
    }

}
