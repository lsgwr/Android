package com.noname.ch03example2view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noname.ch03example2view.util.Cal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvCode = findViewById(R.id.tv_code);
        ViewGroup.LayoutParams params = tvCode.getLayoutParams(); // 获取布局参数
        params.width = Cal.dip2px(this, 300); // 转换dp值为px值
        tvCode.setLayoutParams(params); // 设置布局参数
    }
}