package com.noname.passdata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void button1Click(View view) {
        String data = "Hello From First Activity!";
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("extra_data", data);
        // startActivity(intent);
        startActivityForResult(intent, 1); // 要求下一个活动销毁时返回数据给上一个活动
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    assert data != null;
                    String resData = data.getStringExtra("data_return");
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(resData);
                    textView.setTextSize(16);
                }
                break;
            default:
                break;
        }
    }



}