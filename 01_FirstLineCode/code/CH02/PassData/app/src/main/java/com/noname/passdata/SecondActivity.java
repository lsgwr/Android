package com.noname.passdata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        TextView textView = findViewById(R.id.textView1);
        textView.setText(data);
        textView.setTextSize(20);
        Log.d("Second Activity", data);
    }

    public void button2Click(View view) {
        Intent intent = new Intent();
        intent.putExtra("data_return", "return From Second Activity!");
        setResult(RESULT_OK, intent);
        finish(); // 结束当前活动，返回上一个活动
    }
}