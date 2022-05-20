package com.noname.ch03example1textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvHello = findViewById(R.id.tv_hello);
        tvHello.setText("由Java代码设置的文本框内容"); // Java代码设置文本框
        tvHello.setText(R.string.hello_content2); // 引用字符串变量表中的变量
        tvHello.setTextSize(30); // 设置文字的大小，默认单位是sp
    }
}