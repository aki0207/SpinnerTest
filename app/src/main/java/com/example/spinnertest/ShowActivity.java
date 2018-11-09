package com.example.spinnertest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by orisa on 2017/06/06.
 */

public class ShowActivity extends AppCompatActivity {

    //部品の変数
    TextView showTv;
    Button backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        //部品を取得
        showTv = (TextView)findViewById(R.id.showTv);
        backBtn = (Button)findViewById(R.id.backBtn);

        //intentを受け取る
        Intent intent = getIntent();
        String data_show = intent.getStringExtra("TIME_STRING");
        showTv.setText(data_show);

        //backBtnにリスナーをつける
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intentの終了
                finish();
            }
        });

    }
}