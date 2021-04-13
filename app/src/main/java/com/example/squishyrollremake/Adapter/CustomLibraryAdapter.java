package com.example.squishyrollremake.Adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.squishyrollremake.API.AnimeSingleton;
import com.example.squishyrollremake.Database.AnimeDatabase;
import com.example.squishyrollremake.R;
import com.example.squishyrollremake.pojo.Anime;

import org.json.JSONException;
import org.json.JSONObject;

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


        String nameFiltered = holder.titles.getText().toString();
        String filteredURL = nameFiltered.replace(" ", "%20");
        String url = "https://kitsu.io/api/edge/anime?filter[text]=" + filteredURL;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject attributesObject = response.getJSONObject("attributes");
                            Anime.setTitles(attributesObject.getString("slug"));
                            Anime.setSynopsis(attributesObject.getString("synopsis"));
                            AnimeDatabase db = new AnimeDatabase(context);
                            db.updateAnime(Anime);
                            Log.d("UPDATE", Anime.getTitles() + " ANIME UPDATED");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            // if there is an error in searching display it in logcat
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEY_ERROR",error.getLocalizedMessage());
            }
        });

        AnimeSingleton.getInstance(context).getRequestQueue().add(request);

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
