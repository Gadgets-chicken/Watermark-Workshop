package com.example.watermark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.doEdit).setOnClickListener(this);
    }
    //ボタンが押された時の処理
    public void onClick(View view){

        //画面遷移
        Intent intent = new Intent(this, EditActivity.class);  //インテントの作成
        startActivity(intent);                                 //画面遷移
    }
}