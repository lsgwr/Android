package com.noname.e03_listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    private void initFruits() {
        fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
        fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
        fruitList.add(new Fruit("Orange", R.drawable.orange_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Pear", R.drawable.pear_pic));
        fruitList.add(new Fruit("Grape", R.drawable.grape_pic));
        fruitList.add(new Fruit("Pineapple", R.drawable.pineapple_pic));
        fruitList.add(new Fruit("Strawberry", R.drawable.strawberry_pic));
        fruitList.add(new Fruit("Cherry", R.drawable.cherry_pic));
        fruitList.add(new Fruit("Mango", R.drawable.mango_pic));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList); // 自定义样式文件和数据
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}