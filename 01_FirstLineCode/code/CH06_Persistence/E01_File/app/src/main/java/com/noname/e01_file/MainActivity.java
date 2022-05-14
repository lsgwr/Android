package com.noname.e01_file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
    }

    public void button1Click(View view) {
        String inputText = edit.getText().toString();
        // 可以直接在Device Manager处的模拟器里对应设备的文件夹图标点开看到
        // 文件路径：/data/data/com.noname.e01_file/files/data.txt
        save(inputText);
    }

    public void save(String inputText) {
        FileOutputStream out;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data.txt", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}