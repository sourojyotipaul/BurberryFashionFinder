package com.paul.burberry;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageRecognition extends AppCompatActivity {

    ImageView r_imageView;
    Image image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_recognition);

        //get data from intent
        Bitmap bitmap = (Bitmap) this.getIntent().getParcelableExtra("BitmapImage");

        //Action Bar
        ActionBar actionBar = getSupportActionBar();
        //set title
        actionBar.setTitle("Burberry Fashion Finder");
        r_imageView = (ImageView)findViewById(R.id.r_imageView);
        r_imageView.setImageBitmap(bitmap);

    }
}
