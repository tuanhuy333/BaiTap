package com.example.temp_converter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    EditText editText_F, editText_C;
    Button btn_convert;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initView
        initView();

        if(savedInstanceState != null){
            txt_result.setText(savedInstanceState.getString("text"));
        }



        //xu ly enable edittext
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                doEnableEditable(group);
                //Toast.makeText(MainActivity.this, checkedId+"", Toast.LENGTH_SHORT).show();
            }
        });
        //set mac dinh
        radioButton1.setChecked(true);

        //xu ly onclick covert
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton1.isChecked()) {
                    double F = Double.parseDouble(editText_F.getText().toString().trim());
                    double result_C = (double) Math.round(to_C(F) * 10) / 10; //làm tròn 1 chữ số thập phân
                    editText_C.setText(result_C + "");

                    //add history in top textView
                    txt_result.setText(" F to C : " + F + " -> "+result_C+"\n" + txt_result.getText().toString());

                }
                if (radioButton2.isChecked()) {
                    double C = Double.parseDouble(editText_C.getText().toString().trim());
                    double result_F = (double) Math.round(to_F(C) * 10) / 10; //làm tròn 1 chữ số thập phân
                    editText_F.setText(result_F + "");

                    //add history in top textView
                    txt_result.setText(" C to F : " + C + " -> "+result_F+"\n" + txt_result.getText().toString());

                }

            }
        });


    }

    private void doEnableEditable(RadioGroup group) {
        int checkedRadioId = group.getCheckedRadioButtonId();

        switch (checkedRadioId) {
            case R.id.radioButton: {
                editText_C.setEnabled(false);
                editText_F.setEnabled(true);
                Toast.makeText(this, "F to C ", Toast.LENGTH_SHORT).show();

            }
            break;
            case R.id.radioButton2: {
                editText_C.setEnabled(true);
                editText_F.setEnabled(false);
                Toast.makeText(this, "C to F ", Toast.LENGTH_SHORT).show();
            }
            break;
        }

    }

    private double to_F(double C) {
        return (C * 9.0 / 5.0) + 32.0;
    }

    private double to_C(double F) {
        return (F - 32.0) * 5.0 / 9.0;
    }

    private void initView() {
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        editText_F = findViewById(R.id.editText4);
        editText_C = findViewById(R.id.editText5);
        btn_convert = findViewById(R.id.button);
        txt_result = findViewById(R.id.textView2);
    }


    //lưu text khi xoay màn hình
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",txt_result.getText().toString());
    }
}
