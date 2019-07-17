package com.greensquare.bakingapp.ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
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
    private PlayerView playerUI;
    private Step step;
    private SimpleExoPlayer exoPlayer;
    private Singalton data;
    private boolean visibleToUser =true;
    private ImageView image ;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(exoPlayer!=null){
            exoPlayer.setPlayWhenReady(false);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        step = new Step();
        data = Singalton.getInstance();
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
        image = view.findViewById(R.id.thumbnail);
        playerUI = view.findViewById(R.id.player);

        Log.d(TAG, "Step Thumbnail"+step.getThumbnailURL());
        Log.d(TAG, "Step Video"+step.getVideoURL());


        boolean thumpnailEmpty = step.getThumbnailURL()==null||step.getThumbnailURL().equals("");
        boolean videoEmpty = step.getVideoURL()==null||step.getVideoURL().equals("");

        name.setText(step.getShortDescription());
        stepDescription.setText(step.getDescription());

        if(!thumpnailEmpty){
            Log.wtf(TAG, "Image Exist");
            playerUI.setVisibility(View.INVISIBLE);
            Picasso.get()
                    .load(step.getThumbnailURL())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.error)
                    .into(image);

        }
        if(!videoEmpty){

            Log.wtf(TAG, "Video Exist");
            playerUI.setVisibility(View.VISIBLE);
            image.setVisibility(View.INVISIBLE);
            cratePlayer();
        }
        if(videoEmpty&&thumpnailEmpty){
            Log.wtf(TAG, "Both doesn't Exist");
            image.setVisibility(View.INVISIBLE);
            playerUI.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    public void cratePlayer() {
        exoPlayer =ExoPlayerFactory.newSimpleInstance(getActivity(),
                new DefaultRenderersFactory(getActivity()),
                new DefaultTrackSelector(),new DefaultLoadControl());




        playerUI.setPlayer(exoPlayer);
        exoPlayer.setPlayWhenReady(false);

        Uri videoUri = Uri.parse(step.getVideoURL());
        MediaSource source = new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("BakingApp")).createMediaSource(videoUri);

        exoPlayer.prepare(source);

       // data.setExoPlayer(exoPlayer);
    }





    @Override
    public void onStart() {
        super.onStart();
        if(exoPlayer==null){
            cratePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        if(exoPlayer==null){
//            cratePlayer();
//        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"Inside onPause");
        if(exoPlayer!=null) {
            exoPlayer.setPlayWhenReady(false);
            exoPlayer.stop();
            exoPlayer.release();
            exoPlayer = null;
           // data.setExoPlayer(exoPlayer);
            Log.d(TAG,"Inside onPause and Exo is null");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"Inside onStop");

        if(exoPlayer!=null){
            exoPlayer.release();
            exoPlayer.stop();
            exoPlayer=null;
          //  data.setExoPlayer(exoPlayer);
            Log.d(TAG,"Inside onStop and Exo is null");

        }
    }
}
