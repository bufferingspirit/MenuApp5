package com.example.admin.menuapp5;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 8/6/2017.
 */

public class Music extends android.support.v4.app.Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu_music, container, false);
        openMusic(view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Music");
    }

    public void openMusic(View view){
        if(android.os.Build.VERSION.SDK_INT>=15){
            Intent intent=Intent.makeMainSelectorActivity(Intent.ACTION_MAIN,
                    Intent.CATEGORY_APP_MUSIC);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//Min SDK 15
            startActivity(intent);
        }else{
            Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");//Min SDK 8
            startActivity(intent);
        }
    }
}
