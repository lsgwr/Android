package com.noname.ch04example2startmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JumpSecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_second);

        Button btnSecond = findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnSecond) { // 跳转到活动Second
            Intent intent = new Intent(this, JumpFirstActivity.class);
            // 当栈中存在待跳转的活动实例时，则重新创建该活动的实例，并清除原实例上方的所有实例
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}