package com.example.admin.menuapp5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Admin on 8/6/2017.
 */

public class Camera extends Fragment {

    private static final int CAMERA_PIC_REQUEST = 2;
    private static final int ACTION_IMAGE_CAPTURE = 2;

    ImageView Image;
    Button picture;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        view = inflater.inflate(R.layout.fragment_menu_camera, container, false);

        Image = (ImageView) view.findViewById(R.id.Picture);
        picture = (Button) view.findViewById(R.id.TakePicture);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture(view);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(Image.getDrawable() != null) {
            BitmapDrawable draw = (BitmapDrawable) Image.getDrawable();
            Bitmap bitmap = draw.getBitmap();
            outState.putParcelable("image", bitmap);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null){
            Bitmap bitmap = savedInstanceState.getParcelable("image");
            Image.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            Bitmap bitmap = savedInstanceState.getParcelable("image");
            Image.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Camera");
    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTION_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Image.setImageBitmap(imageBitmap);
        }
    }

}
