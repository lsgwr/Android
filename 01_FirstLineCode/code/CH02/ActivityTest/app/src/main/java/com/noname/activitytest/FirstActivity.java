package com.noname.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void button1Click(View view) {
        String txt = "hello";
        Toast.makeText(FirstActivity.this, "开始连接Wifi", Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.textView); // 拿到页面上的id位textView的组件
        textView.setText(txt);
    }
}