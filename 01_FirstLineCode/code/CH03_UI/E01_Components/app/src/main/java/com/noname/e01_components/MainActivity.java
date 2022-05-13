package com.noname.e01_components;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

            /* 4.切换进度条显示状态 */
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
            if (progressBar.getVisibility() == View.GONE) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }

            /* 5.弹出警告框，会屏蔽其他所有操作*/
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("This is Dialog").setMessage("Something important.").setCancelable(false)
                    .setPositiveButton("OK", (dialog1, which) -> {
                        // 确认按钮
                    })
                    .setNegativeButton("Cancel", (dialog12, which) -> {
                        // 取消按钮
                    })
                    .show(); // 显示这个警告框
            ;
        });
    }
}