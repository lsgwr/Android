package com.noname.e02_okhttptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 1.点击按钮请求 */
        Button btnRequestGet = findViewById(R.id.get_button);
        btnRequestGet.setOnClickListener(v -> {
            String url = "http://www.baidu.com";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().get().url(url).build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.d("OkHttp Failed", "onFailure: " + e.getMessage());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    Log.d("OkHttp Succeed", "onResponse: " + response.code());
                    if (response.code() == 200) {
                        String res = Objects.requireNonNull(response.body()).string();
                        Log.d("OkHttp Succeed", "onResponse: " + res);
                    }
                }
            });
        });
    }
}