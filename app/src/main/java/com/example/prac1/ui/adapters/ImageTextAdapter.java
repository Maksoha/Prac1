package com.example.prac1.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac1.R;
import com.example.prac1.data.model.ImageTextModel;

import java.util.ArrayList;
import java.util.List;

public class ImageTextAdapter extends RecyclerView.Adapter<ImageTextAdapter.ImageTextViewHolder> {

    private ArrayList<ImageTextModel> data = new ArrayList<>();

    @NonNull
    @Override
    public ImageTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ImageTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageTextViewHolder holder, int position) {
        holder.imageView.setImageResource(data.get(position).getImageId());
        holder.textView.setText(data.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateList(List<ImageTextModel> list) {
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    public static class ImageTextViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ImageTextViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
