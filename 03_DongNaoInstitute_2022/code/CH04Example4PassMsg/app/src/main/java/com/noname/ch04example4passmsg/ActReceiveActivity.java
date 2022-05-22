package com.noname.ch04example4passmsg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActReceiveActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);
        TextView tvReceive = findViewById(R.id.tvReceive);
        Bundle bundle = getIntent().getExtras();
        String requestTime = bundle.getString("request_time");
        String requestContent = bundle.getString("request_content");
        String desc = String.format("收到请求消息：\n请求时间%s\n请求内容：%s", requestTime, requestContent);
        tvReceive.setText(desc);

        Button btnReturnMsg = findViewById(R.id.btnReturnMsg);
        btnReturnMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText etMsgReturn = findViewById(R.id.etMsgReturn);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("response_time", DateUtil.getNowTime());
        bundle.putString("response_content", etMsgReturn.getText().toString());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent); // 返回信息给上一个活动
        finish();
    }
}