package com.noname.ch05example2selectbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // startActivity(new Intent(this, CheckboxActivity.class)); // 复选框
        startActivity(new Intent(this, SwitchActivity.class)); // 开关
    }
}