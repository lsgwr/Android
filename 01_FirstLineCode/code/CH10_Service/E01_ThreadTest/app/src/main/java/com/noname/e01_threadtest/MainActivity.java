package com.noname.e01_threadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        Button btnChangeText = findViewById(R.id.change_text);
        btnChangeText.setOnClickListener(v -> {
            new Thread(() -> {
                text.setText("子线程中修改UI");
            }).start();
        });
    }
}