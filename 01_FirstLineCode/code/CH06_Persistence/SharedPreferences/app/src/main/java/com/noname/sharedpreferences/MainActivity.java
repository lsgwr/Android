package com.noname.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editAge, editMarried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editAge = findViewById(R.id.edit_age);
        editMarried = findViewById(R.id.edit_married);

        /* 保存数据 */
        Button btnSaveData = findViewById(R.id.save_data);
        btnSaveData.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
            editor.putString("name", String.valueOf(editName.getText()));
            editor.putString("age", editAge.getText().toString());
            editor.putString("married", editMarried.getText().toString());
            editor.apply();
        });

        /* 恢复数据 */
        Button btnRestoreData = findViewById(R.id.restore_data);
        btnRestoreData.setOnClickListener(v -> {
            SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
            String name = pref.getString("name", "");
            String age = pref.getString("age", "0");
            String married = pref.getString("married", "");
            editName.setText(name);
            editAge.setText(age);
            editMarried.setText(married);
        });
    }
}