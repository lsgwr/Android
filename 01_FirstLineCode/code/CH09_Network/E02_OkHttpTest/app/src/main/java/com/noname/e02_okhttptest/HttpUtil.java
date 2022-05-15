package com.noname.e02_okhttptest;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    /**
     * get 同步Get同求
     *
     * @param url url
     * @return
     */
    public static String syncGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * get 异步Get同求
     *
     * @param url url
     * @return
     */
    public static void nonSyncGet(String url, Callback responseCallback) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(responseCallback);
    }

    /**
     * get 同步Post同求
     *
     * @param url url
     * @return
     */
    public static String syncPost(String url) {
        String result = null;
        String json = "test";
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * get 异步Post同求
     *
     * @param url url
     * @return
     */
    public static void nonSyncPost(String url, Callback responseCallback) {
        String json = "test";
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            client.newCall(request).enqueue(responseCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 拦截器的简单使用
     *
     * @param url url
     * @return
     */
    public static void okInterceptor(String url, Callback responseCallback) {
        String json = "test";
        OkHttpClient client = new OkHttpClient();
        //测试添加拦截器
        client.newBuilder().addInterceptor(new TestInterceptor());

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            client.newCall(request).enqueue(responseCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class TestInterceptor implements Interceptor {
        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            Log.i("ok", String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            Log.i("ok", String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        }
    }
}
