package com.noname.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void button1Click(View view) {
        String txt = "hello";
        Toast.makeText(FirstActivity.this, "开始连接Wifi", Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.textView); // 拿到页面上的id为textView的组件
        textView.setText(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 给当前活动创建菜单
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // 根据不同的菜单响应不同的事件
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "按下了add按钮！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "按下了Remove按钮！", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    public void finishActivity(View view) {
        finish();
    }

    public void switchActivity(View view) {
        Intent intent = new Intent("com.noname.activitytest.ACTION_START");
        intent.addCategory("com.noname.activitytest.MY_CATEGORY");
        startActivity(intent); // DEFAULT是一种会默认传入的category
    }
}