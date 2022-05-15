package com.noname.e01_threadtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int UPDATE_TEXT = 1;

    private TextView text;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    text.setText("子线程中修改UI");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        Button btnChangeText = findViewById(R.id.change_text);
        btnChangeText.setOnClickListener(v -> {
            new Thread(() -> {
                Message message = new Message();
                message.what = UPDATE_TEXT;
                handler.sendMessage(message); // 发送消息来更新UI
            }).start();
        });
    }
}