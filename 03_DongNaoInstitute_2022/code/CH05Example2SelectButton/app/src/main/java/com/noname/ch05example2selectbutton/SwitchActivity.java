package com.noname.ch05example2selectbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SwitchActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String desc = String.format("您%s了LED1", isChecked ? "打开" : "关闭");
        TextView tvSwitchStatus = findViewById(R.id.tvSwitchStatus);
        tvSwitchStatus.setText(desc);
    }
}