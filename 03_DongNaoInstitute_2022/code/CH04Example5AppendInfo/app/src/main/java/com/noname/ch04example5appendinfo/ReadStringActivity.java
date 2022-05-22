package com.noname.ch04example5appendinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReadStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_string);
        showStringResource();
    }

    private void showStringResource() {
        String val = getString(R.string.weather_str);
        TextView tvResource = findViewById(R.id.tvResource);
        tvResource.setText("来自字符串资源：今天的天气是" + val);
    }
}