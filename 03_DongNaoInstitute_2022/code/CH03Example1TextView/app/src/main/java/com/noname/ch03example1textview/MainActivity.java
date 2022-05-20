package com.noname.ch03example1textview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hello字符串
        TextView tvHello = findViewById(R.id.tv_hello);
        tvHello.setText("由Java代码设置的文本框内容"); // Java代码设置文本框
        tvHello.setText(R.string.hello_content2); // 引用字符串变量表中的变量
        tvHello.setTextSize(30); // 设置文字的大小，默认单位是sp
        tvHello.setTextColor(Color.GREEN); // 设置文本颜色

        // 设置为透明色
        TextView tvPx = findViewById(R.id.tv_px);
        tvPx.setTextColor(0x00ff00);

        // 设置为绿色
        TextView tvDp = findViewById(R.id.tv_dp);
        tvDp.setTextColor(0xff00ff00);
        tvDp.setBackgroundResource(R.color.purple_200); // 从资源文件中加载颜色

        // 设置背景色
        TextView tvSp = findViewById(R.id.tv_sp);
        tvSp.setBackgroundColor(Color.BLUE);
    }
}