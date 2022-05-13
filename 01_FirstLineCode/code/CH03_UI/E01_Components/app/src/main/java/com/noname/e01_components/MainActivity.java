package com.noname.e01_components;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建按钮响应事件
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            TextView textView = (TextView) findViewById(R.id.text_view);
            textView.setText("按钮被按下啦！！！");
        });
    }
}