package com.noname.e04_litepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
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

        /* 2.添加数据 */
        Button btnAddData = findViewById(R.id.add_data);
        btnAddData.setOnClickListener(v -> {
            Book book1 = new Book("红高粱", "莫言", "清华出版社", 16.96, 454);
            book1.save();
            Book book2 = new Book("The Lost Symbol", "Dan Brown", "Unknown", 19.95, 510);
            book2.save();
        });

        /* 3.更新数据 */
        Button btnUpdateData = findViewById(R.id.update_data);
        btnUpdateData.setOnClickListener(v -> {
            Book book = new Book();
            book.setPrice(14.95);
            book.setPress("Anchor");
            book.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");
        });

        /* 4.删除数据 */
        Button btnDeleteData = findViewById(R.id.delete_data); // 删除数据
        btnDeleteData.setOnClickListener(v -> { // 删除价格小于15的书籍
            LitePal.deleteAll(Book.class, "price < ?", "15");
        });

        Button btnQueryData = findViewById(R.id.query_data);
        btnQueryData.setOnClickListener(v -> {

        });
    }
}