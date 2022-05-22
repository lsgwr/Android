package com.noname.ch04example5appendinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MetaDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta_data);
        showMetaData();
    }

    private void showMetaData() {
        PackageManager pm = getPackageManager();
        ActivityInfo act = null;
        try {
            act = pm.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Bundle bundle = act.metaData;
        String val = bundle.getString("weather");
        TextView tvMeta = findViewById(R.id.tvMeta);
        tvMeta.setText("来自元数据信息：今天的天气是" + val);
    }
}