package com.paul.burberry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class CameraFragment extends Fragment {

    Button button_capture;
    Button button_proceed;
    ImageView imageView;
    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_camera, container, false);

        button_capture = (Button) v.findViewById(R.id.button_capture);
        button_proceed = (Button) v.findViewById(R.id.button_proceed);
        imageView      = (ImageView) v.findViewById(R.id.imageView);

        button_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        button_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginNextActivity();
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
        imageView.setBackground(null);
    }

    public void beginNextActivity(){
        Intent intent = new Intent(getActivity(), ImageRecognition.class);
        intent.putExtra("BitmapImage", bitmap);
        startActivity(intent);
    }
}
