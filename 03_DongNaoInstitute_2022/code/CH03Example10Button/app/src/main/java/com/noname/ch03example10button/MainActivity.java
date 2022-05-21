package com.noname.ch03example10button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClickTest2 = findViewById(R.id.btnClickTest2);
        btnClickTest2.setOnClickListener(v -> { // 这里的v就是按钮对象View
            String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(), ((Button) v).getText());
            TextView tvHello = findViewById(R.id.tvHello);
            tvHello.setText(desc);
        });
    }

    public void doClick(View view) {
        String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(), ((Button) view).getText());
        TextView tvHello = findViewById(R.id.tvHello);
        tvHello.setText(desc);
    }
}