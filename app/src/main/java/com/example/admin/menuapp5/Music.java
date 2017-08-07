package com.example.admin.menuapp5;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Admin on 8/6/2017.
 */

public class Music extends android.support.v4.app.Fragment {
    View view;
    MediaPlayer mediaPlayer;
    Button Play,Pause;
    int timeStamp = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu_music, container, false);
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.soundhelix);
        Play = view.findViewById(R.id.btnPlay);
        Pause = view.findViewById(R.id.btnPause);
        //openMusic(view);
        return view;
    }

    public void Pause(){
        mediaPlayer.pause();
        timeStamp = mediaPlayer.getCurrentPosition();
    }
    public void Play(){
        mediaPlayer.seekTo(timeStamp);
        mediaPlayer.start();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Music");

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Play();
            }
        });

        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pause();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

    /*public void openMusic(View view){
        if(android.os.Build.VERSION.SDK_INT>=15){
            Intent intent=Intent.makeMainSelectorActivity(Intent.ACTION_MAIN,
                    Intent.CATEGORY_APP_MUSIC);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//Min SDK 15
            startActivity(intent);
        }else{
            Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");//Min SDK 8
            startActivity(intent);
        }
    }*/
}
