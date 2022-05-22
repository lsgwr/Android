package com.noname.ch05example1shape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View vContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vContent = findViewById(R.id.vContent);
        findViewById(R.id.btnRect).setOnClickListener(this);
        findViewById(R.id.btnOval).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnRect) {
            vContent.setBackgroundResource(R.drawable.shape_rect_gold);
        }
        if (id == R.id.btnOval) {
            vContent.setBackgroundResource(R.drawable.shape_oval_rose);
        }
    }
}