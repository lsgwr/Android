package com.noname.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnStartNormalClick(View view) {
        Intent intent = new Intent(MainActivity.this, NormalActivity.class);
        startActivity(intent);
    }

    public void btnStartDialogClick(View view) {
        Intent intent = new Intent(MainActivity.this, DialogActivity.class);
        startActivity(intent);
    }
}