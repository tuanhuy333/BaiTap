package com.example.food_order_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroupSize, radioGroupTor;

    RadioButton radioButtonM, radioButtonCorn;

    CheckBox chk_beef, chk_chicken, chk_fish, chk_cheese, chk_sea, chk_rice, chk_beans, chk_pico, chk_gua, chk_lbt, chk_soda, chk_cerveza, chk_mar, chk_teq;

    Button btn_send;

    //String s = "";
    List<CheckBox> checkBoxList, checkBoxList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        initView();

        //Fillings checkboxs
        checkBoxList = new ArrayList<>();
        checkBoxList.add(chk_beef);
        checkBoxList.add(chk_chicken);
        checkBoxList.add(chk_fish);
        checkBoxList.add(chk_cheese);
        checkBoxList.add(chk_sea);
        checkBoxList.add(chk_rice);
        checkBoxList.add(chk_beans);
        checkBoxList.add(chk_pico);
        checkBoxList.add(chk_gua);
        checkBoxList.add(chk_lbt);

        //
        checkBoxList2 = new ArrayList<>();
        checkBoxList2.add(chk_soda);
        checkBoxList2.add(chk_cerveza);
        checkBoxList2.add(chk_mar);
        checkBoxList2.add(chk_teq);

        //gui tin nhan
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String phoneNumber = "5556";

                String s0 = getSize_Tor_Radio();
                String s1 = "Fillings: " + getCheckbox(checkBoxList);
                String s2 = "Beverage: " + getCheckbox(checkBoxList2);
                String message = "I want order Taco : "+s0+s1+s2;

                Log.i("message", s0 + s1 + s2);

                send_SMS(phoneNumber,message);
            }
        });





    }

    private void send_SMS(String phoneNumber,String message){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + phoneNumber));
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
    private String getSize_Tor_Radio() {
        int id_size = radioGroupSize.getCheckedRadioButtonId();
        int id_tor = radioGroupTor.getCheckedRadioButtonId();
        RadioButton radioButtonSize = (RadioButton) findViewById(id_size);
        RadioButton radioButtonTor = (RadioButton) findViewById(id_tor);

        Log.i("a", "size " + radioButtonSize.getText());
        Log.i("a", "tor " + radioButtonTor.getText());

        return "Size : " + radioButtonSize.getText() + " Tortilla: " + radioButtonTor.getText() + " ";
    }

    private String getCheckbox(List<CheckBox> checkBoxList) {
        String s = "";
        for (CheckBox item : checkBoxList) {
            if (item.isChecked()) {
                s += item.getText() + " ";
            }else {
                return "0 ";
            }
        }
        return s;
    }


    private void initView() {
        //
        radioGroupSize = findViewById(R.id.radioGroup_Size);
        radioGroupTor = findViewById(R.id.radioGroup_Tortilla);

        //
        radioButtonM = findViewById(R.id.radioButtonM);
        radioButtonCorn = findViewById(R.id.radioButtonCorn);
        //default
        radioButtonM.setChecked(true);
        radioButtonCorn.setChecked(true);

        //
        chk_beef = findViewById(R.id.checkBoxBeef);
        chk_chicken = findViewById(R.id.checkBoxChicken);
        chk_fish = findViewById(R.id.checkBoxWFish);
        chk_cheese = findViewById(R.id.checkBoxCheese);
        chk_sea = findViewById(R.id.checkBoxSeaFood);
        chk_rice = findViewById(R.id.checkBoxRice);
        chk_beans = findViewById(R.id.checkBoxBeans);
        chk_pico = findViewById(R.id.checkBoxPico);
        chk_gua = findViewById(R.id.checkBoxGua);
        chk_lbt = findViewById(R.id.checkBoxLBT);
        chk_soda = findViewById(R.id.checkBoxSoda);
        chk_cerveza = findViewById(R.id.checkBoxCerveza);
        chk_mar = findViewById(R.id.checkBoxMarga);
        chk_teq = findViewById(R.id.checkBoxTequila);

        //
        btn_send = findViewById(R.id.button);


    }
}
