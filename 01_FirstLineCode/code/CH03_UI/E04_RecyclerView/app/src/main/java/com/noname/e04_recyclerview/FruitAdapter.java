package com.noname.e04_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> fruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            // 指定布局文件中的节点
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false); // 指定布局文件fruit_item.xml
        final ViewHolder holder = new ViewHolder(view);
        // 整个列表项的点击事件
        holder.fruitView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            Fruit fruit = fruitList.get(position);
            Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
        });

        // 图片点击事件
        holder.fruitImage.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            Fruit fruit = fruitList.get(position);
            Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
