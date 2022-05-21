package com.noname.ch03example11imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivScale = findViewById(R.id.ivScale);
        ivScale.setImageResource(R.drawable.apple); // 代码设置图片源
        ivScale.setScaleType(ImageView.ScaleType.FIT_CENTER); // 代码设置图片居中方式
    }
}