package com.noname.ch04example4passmsg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendMsg = findViewById(R.id.btnSendMsg);
        btnSendMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnSendMsg) {
            Intent intent = new Intent(this, ActReceiveActivity.class);
            Bundle bundle = new Bundle(); // 创建包裹，用于传递消息
            bundle.putString("request_time", DateUtil.getNowTime());
            EditText etMsg = findViewById(R.id.etMsg);
            bundle.putString("request_content", etMsg.getText().toString());
            intent.putExtras(bundle);
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 接收返回数据
        if (data != null && requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String requestTime = bundle.getString("response_time");
            String requestContent = bundle.getString("response_content");
            String desc = String.format("收到返回消息：\n应答时间%s\n应答内容：%s", requestTime, requestContent);
            TextView tvReturn = findViewById(R.id.tvReturn);
            tvReturn.setText(desc);
        }
    }
}