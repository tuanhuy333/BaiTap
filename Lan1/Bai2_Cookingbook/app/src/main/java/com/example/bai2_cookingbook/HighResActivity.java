package com.example.bai2_cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class HighResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_res);
        int src_img=0;
        Intent intent = getIntent();
        if (intent != null){
            src_img=intent.getIntExtra("src_img",R.drawable.ic_image_black_24dp);
        }
        ImageView imageView = findViewById(R.id.mHighRes);
        imageView.setImageResource(src_img);
    }
}
