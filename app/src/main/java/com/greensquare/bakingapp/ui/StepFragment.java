package com.greensquare.bakingapp.ui;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.models.Singalton;
import com.greensquare.bakingapp.models.Step;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepFragment extends Fragment {


    public StepFragment() {

    }

    private final String TAG = "Step_Fragment";
    private PlayerView player;
    private Step step;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        step = new Step();
        if(getArguments()!=null){
            Bundle bundle = getArguments();
            step.setId(bundle.getInt("id"));
            step.setShortDescription(bundle.getString("ShortDescription"));
            step.setDescription(bundle.getString("Description"));
            step.setThumbnailURL(bundle.getString("ThumbnailURL"));
            step.setVideoURL(bundle.getString("VideoURL"));
        }

        View view = inflater.inflate(R.layout.fragment_step, container, false);
        Singalton data = Singalton.getInstance();
        TextView name = view.findViewById(R.id.name);
        TextView stepDescription = view.findViewById(R.id.step_descrption);
        ImageView image = view.findViewById(R.id.thumbnail);
        player = view.findViewById(R.id.player);

        Log.d(TAG, "Step Thumbnail"+step.getThumbnailURL());
        Log.d(TAG, "Step Video"+step.getVideoURL());


        boolean thumpnailEmpty = step.getThumbnailURL()==null||step.getThumbnailURL().equals("");
        boolean videoEmpty = step.getVideoURL()==null||step.getVideoURL().equals("");

        name.setText(step.getShortDescription());
        stepDescription.setText(step.getDescription());

        if(!thumpnailEmpty){
            Log.wtf(TAG, "Image Exist");
            player.setVisibility(View.GONE);
            Picasso.get()
                    .load(step.getThumbnailURL())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.error)
                    .into(image);

        }
        if(!videoEmpty){
            Log.wtf(TAG, "Video Exist");
            player.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
        }
        if(videoEmpty&&thumpnailEmpty){
            Log.wtf(TAG, "Both doesn't Exist");
            image.setImageResource(R.drawable.error);
        }





        return view;
    }

}
