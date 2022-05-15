package com.noname.e03_sqlite;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 版本号增加才能创建新的表
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button btnCreateDb = findViewById(R.id.create_database);
        btnCreateDb.setOnClickListener(v -> {
            dbHelper.getWritableDatabase();
        });

        Button btnAddData = findViewById(R.id.add_data);
        btnAddData.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase(); // 获取数据库对象
            ContentValues values = new ContentValues();
            values.put("name", "The Da Vinci Code");
            values.put("author", "Dan Brown");
            values.put("pages", 454);
            values.put("price", 16.96);
            db.insert("Book", null, values); // 插入第一条数据
            values.clear();
            values.put("name", "红高粱");
            values.put("author", "莫言");
            values.put("pages", 510);
            values.put("price", 19.95);
            db.insert("Book", null, values); // 插入第2条数据
        });

        Button btnUpdateData = findViewById(R.id.update_data);
        btnUpdateData.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price", 10.99);
            db.update("Book", values, "name = ?", new String[]{"红高粱"});
        });

        Button btnDeleteData = findViewById(R.id.delete_data); // 删除数据
        btnDeleteData.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("Book", "pages > ?", new String[]{"500"});
        });

        Button btnQueryData = findViewById(R.id.query_data);
        btnQueryData.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            // 查询Book表中的所有数据
            Cursor cursor = db.query("Book", null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    // 遍历Cursor对象，取出数据并打印
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex("author"));
                    @SuppressLint("Range") int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                    @SuppressLint("Range") double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    Log.d(TAG, "onCreate: book name is " + name);
                    Log.d(TAG, "onCreate: book author is " + author);
                    Log.d(TAG, "onCreate: book pages is " + pages);
                    Log.d(TAG, "onCreate: book price is " + price);
                } while (cursor.moveToNext());
            }
            cursor.close(); // 一定记得最后关闭数据库
        });
    }
}