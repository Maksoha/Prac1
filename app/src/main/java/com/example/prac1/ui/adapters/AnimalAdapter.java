package com.example.prac1.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.prac1.R;
import com.example.prac1.data.model.AnimalEntity;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalEntityViewHolder> {

    private List<AnimalEntity> animals;

    public void setAnimalEntities(List<AnimalEntity> animalEntities) {
        animals = animalEntities;
        notifyDataSetChanged();
    }

    @Override
    public AnimalEntityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new AnimalEntityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalEntityViewHolder holder, int position) {
        if (animals != null) {
            AnimalEntity currentEntity = animals.get(position);
            holder.textViewName.setText(currentEntity.getName());
        } else {
            holder.textViewName.setText("No AnimalEntity");
        }
    }

    @Override
    public int getItemCount() {
        return animals != null ? animals.size() : 0;
    }

    static class AnimalEntityViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        public AnimalEntityViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text);
        }
    }
}
