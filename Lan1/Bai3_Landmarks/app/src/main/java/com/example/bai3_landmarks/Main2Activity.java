package com.example.bai3_landmarks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button btn_mapit, btn_more;

    String name = "";
    String address = "";
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();


        Intent i = getIntent();
        Bundle b = i.getBundleExtra("info_place");
        if (b != null) {
            name = b.getString("name");
            address = b.getString("address");
            url = b.getString("url");
        }

        //set title with name place
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(name);

        //show map it

        btn_mapit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch_map(address);
            }
        });

        //show web url
        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch_web(url);
            }
        });

    }

    private void initView() {
        btn_mapit = findViewById(R.id.button);
        btn_more = findViewById(R.id.button2);
    }


    //map info
    private void launch_web(String url) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    //map it
    private void launch_map(String address) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
