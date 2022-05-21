package com.noname.ch04exampl1startfinishactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActFinishActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_finish);

        findViewById(R.id.ibBack).setOnClickListener(this);
        findViewById(R.id.btnComplete).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ibBack || id == R.id.btnComplete) {
            finish(); // 结束当前活动，回到上一级的活动
        }
    }
}