package com.example.castro_week3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    Context context;
    ArrayList<PlanetModel> planetModelArrayList;
    RecyclerViewInterface recyclerViewInterface;

    public RecyclerViewAdapter(RecyclerViewInterface recyclerViewInterface, ArrayList<PlanetModel> planetModelArrayList, Context context) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.planetModelArrayList = planetModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.text.setText(planetModelArrayList.get(position).getPlanet_name());
        holder.img.setImageResource(planetModelArrayList.get(position).getPlanet_img());
    }

    @Override
    public int getItemCount() {
        return planetModelArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView text;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            img = itemView.findViewById(R.id.planetImage);
            text = itemView.findViewById(R.id.planetNametxt);
            itemView.setClickable(true);  // Make sure the entire item is clickable
            itemView.setOnClickListener(view -> {
                if(recyclerViewInterface != null){
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);

                    }
                }
            });
        }
    }
}
