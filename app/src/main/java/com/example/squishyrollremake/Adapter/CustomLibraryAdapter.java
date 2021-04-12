package com.example.squishyrollremake.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.squishyrollremake.R;
import com.example.squishyrollremake.pojo.Anime;

import java.net.URI;
import java.util.ArrayList;

public class CustomLibraryAdapter extends RecyclerView.Adapter<CustomLibraryAdapter.CustomLibraryViewHolder> {

    private ArrayList<Anime> animes;
    private Context context;


    public CustomLibraryAdapter(ArrayList<Anime> animes, Context context) {
        this.animes = animes;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomLibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_item_view,parent,false);
        return new CustomLibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomLibraryViewHolder holder, int position) {
        Anime Anime = animes.get(position);
        holder.synopsis.setText(Anime.getSynopsis());
        holder.titles.setText(Anime.getTitles());
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    class CustomLibraryViewHolder extends RecyclerView.ViewHolder{
        protected TextView titles;
        protected TextView synopsis;

        public CustomLibraryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titles = itemView.findViewById(R.id.titles);
            this.synopsis = itemView.findViewById(R.id.synopsis);
        }
    }
}
