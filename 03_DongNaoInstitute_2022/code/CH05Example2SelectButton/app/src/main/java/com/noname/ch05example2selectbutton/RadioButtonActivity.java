package com.noname.ch05example2selectbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButtonActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView tvSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        tvSex = findViewById(R.id.tvSex);
        RadioGroup rgSex = findViewById(R.id.rgSex);
        rgSex.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbMale) {
            tvSex.setText("哇哦，你是个帅气的男孩");
        } else if (checkedId == R.id.rbFemale) {
            tvSex.setText("不错，你是个漂亮的女孩");
        }
    }
}