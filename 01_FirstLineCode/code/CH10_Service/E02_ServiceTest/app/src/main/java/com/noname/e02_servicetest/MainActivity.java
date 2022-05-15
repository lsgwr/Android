package com.noname.e02_servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 1.启动服务 */
        Button btnStartService = findViewById(R.id.start_service);
        btnStartService.setOnClickListener(v->{
            Intent startIntent = new Intent(this, MyService.class);
            startService(startIntent);
        });

        /* 2.停止服务 */
        Button btnStopService = findViewById(R.id.stop_service);
        btnStopService.setOnClickListener(v->{
            Intent stopIntent = new Intent(this, MyService.class);
            stopService(stopIntent);
        });
    }
}