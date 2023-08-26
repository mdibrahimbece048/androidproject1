package com.example.gettingpicturegallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewGallery;
    Button btnGallery;

    private final int GALLERY_REQUEST_CODE=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewGallery=findViewById(R.id.galleryImage);
        btnGallery=findViewById(R.id.btnGallery);

        btnGallery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent iGallery= new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){

            if(requestCode==GALLERY_REQUEST_CODE){

                // for gallery

                imageViewGallery.setImageURI(data.getData());

            }
        }
    }
}