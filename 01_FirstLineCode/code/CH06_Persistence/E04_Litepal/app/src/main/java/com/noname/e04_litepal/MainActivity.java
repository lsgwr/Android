package com.noname.e04_litepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 1.创建数据库 */
        Button btnCreateDb = findViewById(R.id.create_database);
        btnCreateDb.setOnClickListener(v -> {
            Connector.getDatabase();  // 自动创建数据库
        });

        Button btnAddData = findViewById(R.id.add_data);
        btnAddData.setOnClickListener(v -> {

        });

        Button btnUpdateData = findViewById(R.id.update_data);
        btnUpdateData.setOnClickListener(v -> {

        });

        Button btnDeleteData = findViewById(R.id.delete_data); // 删除数据
        btnDeleteData.setOnClickListener(v -> {

        });

        Button btnQueryData = findViewById(R.id.query_data);
        btnQueryData.setOnClickListener(v -> {

        });
    }
}