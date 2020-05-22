package com.example.notepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView txt_dateUpdate, txt_title;
    EditText edt_note;

    private final String file_name = "note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();



        SharedPreferences sharedPreferences=getSharedPreferences("timeUpdated",MODE_PRIVATE);
        String time=sharedPreferences.getString("time","Never");
        txt_dateUpdate.setText("Last Updated: "+time);



    }

    @Override
    protected void onPause() {
        super.onPause();
        write_file();
    }

    @Override
    protected void onResume() {
        super.onResume();
        read_file();
    }

    private void initView() {
        txt_dateUpdate = findViewById(R.id.txt_dateUpdate);
        txt_title = findViewById(R.id.txt_title);
        edt_note = findViewById(R.id.edt_note);
    }

    //ghi file method
    private void write_file() {

        //tạo luồng ghi file


        try {
            FileOutputStream out = this.openFileOutput(file_name, MODE_PRIVATE);

            String data = edt_note.getText().toString() + "\n";


            //ghi

            out.write(data.getBytes());
            out.close();

            //save time in shared preference
            SharedPreferences sharedPreferences=getSharedPreferences("timeUpdated",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("time",getTime());
            editor.commit();



            Toast.makeText(MainActivity.this, "File đã được ghi lại", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read_file();
    }

    //read file method

    private void read_file() {

        //tạo luồng đọc file
        try {
            FileInputStream in = this.openFileInput(file_name);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));


            StringBuilder stringBuilder = new StringBuilder();
            String s = null;

            //khi đọc các dòng khác null thì vẫn làm tiếp

            while ((s = bufferedReader.readLine()) != null) {
                //build String
                stringBuilder.append(s).append("\n");

            }
            Toast.makeText(this, "File được đọc", Toast.LENGTH_SHORT).show();
            edt_note.setText(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd,HH:mm:ss");
        Date date = new Date();
        String time = simpleDateFormat.format(date);
        return time;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("time","");
    }
}