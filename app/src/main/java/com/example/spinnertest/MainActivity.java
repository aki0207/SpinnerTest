package com.example.spinnertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //部品の変数
    Spinner spinner;
    Spinner spinner2;
    Button showBtn;

    //spinner用の変数
    String[] items = {"----","あほ", "天才","変態","紳士"};
    String time = "empty time";

    //自作の方
    String[] array = {"----","ジョニー","まっつ","どんこに市"};
    String tome = "Hello World";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //部品を取得
        spinner = (Spinner)findViewById(R.id.spinner);

       showBtn = (Button)findViewById(R.id.button);

        //Spinnerの設定
        //ArrayAdapterの設定
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinnerにadapterをセット
        spinner.setAdapter(adapter);
        //リスナーをつける
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = (String)parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //dummy
            }
        });




        //showBtnにリスナーを設定
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ShowActivity.class);
                //intentにデータを入れる
                intent.putExtra("TIME_STRING", time);
                //activityの開始
                startActivity(intent);
            }
        });

    }
}