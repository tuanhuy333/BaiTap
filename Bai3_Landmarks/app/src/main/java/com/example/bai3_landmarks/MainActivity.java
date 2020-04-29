package com.example.bai3_landmarks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    Adapter_landmarks adapter_landmarks;
    List<Landmark> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Landmarks App");

        //
        initView();

        mData = new ArrayList<>();
        mData.add(new Landmark(1, "Trường Đại Học Sài Gòn", "273 An Dương Vương, Phường 3, Quận 5, Hồ Chí Minh", "https://sgu.edu.vn/"));
        mData.add(new Landmark(2, "Bảo tàng Thành phố Hồ Chí Minh", "65 Lý Tự Trọng, Bến Nghé, Quận 1, Hồ Chí Minh", "http://www.hcmc-museum.edu.vn/vi-vn/trang-chu.aspx"));
        mData.add(new Landmark(3, "Trường Đại học Tôn Đức Thắng", "19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh", "https://www.tdtu.edu.vn/"));
        mData.add(new Landmark(4, "Tòa nhà Bitexco Financial", "Tòa nhà tài chính Bitexco, 7, 2 Hải Triều, Bến Nghé, Quận 1, Hồ Chí Minh", "http://www.bitexcofinancialtower.com/"));
        mData.add(new Landmark(5, "Lotte Cinema Nowzone", "TTTM Nowzone, 235 Đường Nguyễn Văn Cừ, Phường Nguyễn Cư Trinh, Quận 1, Hồ Chí Minh", "http://www.lottecinemavn.com/LCHS/index.aspx"));

        adapter_landmarks = new Adapter_landmarks(this, R.layout.item, mData);

        mListView.setAdapter(adapter_landmarks);

        //click
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Landmark landmark = mData.get(position);
                Bundle b = new Bundle();
                b.putString("name", landmark.getName());
                b.putString("address", landmark.getAddress());
                b.putString("url", landmark.getUrl());

                Intent i = new Intent(MainActivity.this, Main2Activity.class).putExtra("info_place", b);
                startActivity(i);
            }
        });

    }



    private void initView() {
        mListView = findViewById(R.id.mListView);
    }
}
