package com.example.dclassic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class storepagesadapter extends RecyclerView.Adapter<storepagesadapter.ViewHolder> {

    List<Integer> images;
    List<String> names;
    List<String> locations;

    public storepagesadapter(List<Integer> images, List<String> names, List<String> locations) {
        this.images = images;
        this.names = names;
        this.locations = locations;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img.setImageResource(images.get(position));
        holder.name.setText(names.get(position));
        holder.location.setText(locations.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, location;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgStore);
            name = itemView.findViewById(R.id.txtName);
            location = itemView.findViewById(R.id.txtLocation);
        }
    }
}