package com.noname.e02_servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

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

        /* 3.绑定服务 */
        Button btnBindService = findViewById(R.id.bind_service);
        btnBindService.setOnClickListener(v->{
            Intent bindIntent = new Intent(this, MyService.class);
            bindService(bindIntent, connection, BIND_AUTO_CREATE);
        });

        /* 4.解绑服务 */
        Button btnUnbindService = findViewById(R.id.unbind_service);
        btnUnbindService.setOnClickListener(v->{
            unbindService(connection);
        });
    }
}