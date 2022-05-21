package com.noname.ch03example10button;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvHello;
    private Button btnClickTest6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tvHello);

        Button btnClickTest2 = findViewById(R.id.btnClickTest2);
        btnClickTest2.setOnClickListener(v -> { // 这里的v就是按钮对象View
            String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(), ((Button) v).getText());
            tvHello.setText(desc);
        });

        // 指定按钮事件在当前类中的onClick方法中执行
        Button btn3 = findViewById(R.id.btnClickTest3);
        btn3.setOnClickListener(this);
        Button btn4 = findViewById(R.id.btnClickTest4);
        btn4.setOnClickListener(this);
        Button btn5 = findViewById(R.id.btnClickTest5);
        btn5.setOnClickListener(this);
        Button btnEnable = findViewById(R.id.btnEnable);
        btnEnable.setOnClickListener(this);
        Button btnDisable = findViewById(R.id.btnDisable);
        btnDisable.setOnClickListener(this);
        btnClickTest6 = findViewById(R.id.btnClickTest6);
    }

    public void doClick(View view) {
        String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(), ((Button) view).getText());
        tvHello.setText(desc);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnClickTest3) {
            tvHello.setText("您点击了按钮3！");
        } else if (id == R.id.btnClickTest4) {
            tvHello.setText("您点击了按钮4！");
        } else if (id == R.id.btnClickTest5) {
            tvHello.setText("您点击了按钮5！");
        } else if (id == R.id.btnEnable) { // 使能测试按钮
            btnClickTest6.setEnabled(true);
        } else if (id == R.id.btnDisable) { // 禁用测试按钮
            btnClickTest6.setEnabled(false);
        }
    }
}