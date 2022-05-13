package com.noname.e01_components;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建按钮响应事件
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            /* 1.修改文本标签的内容 */
            TextView textView = (TextView) findViewById(R.id.text_view);
            textView.setText("按钮被按下啦！！！");

            /* 2.获取输入框的内容 */
            EditText editText = findViewById(R.id.edit_text);
            String inputText = editText.getText().toString(); // 获取输出的内容
            Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();

            /* 3.切换图片 */
            ImageView imageView = (ImageView) findViewById(R.id.image_view);
            imageView.setImageResource(R.drawable.img_2);
        });
    }
}