package com.example.squishyrollremake.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.squishyrollremake.Database.RatingDatabase;
import com.example.squishyrollremake.R;
import com.example.squishyrollremake.pojo.Rating;

import java.util.ArrayList;

public class CustomReviewAdapter extends RecyclerView.Adapter<CustomReviewAdapter.CustomViewHolder>{

    private ArrayList<Rating> ratings;
    private Context context;

    public CustomReviewAdapter(ArrayList<Rating> ratings, Context context) {
        this.ratings = ratings;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item_view,
                parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Rating Rating = ratings.get(position);
        holder.name.setText(Rating.getName());
        holder.description.setText(Rating.getDescription());

    }

    @Override
    public int getItemCount() {
        return ratings.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        protected TextView name;
        protected TextView description;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.description);

        }

        public boolean onLongClick(View v) {
            new AlertDialog.Builder(context)
                    .setTitle("Delete")
                    .setMessage("Are you sure you want to delete" +
                            ratings.get(getLayoutPosition()).getName() + " ?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            RatingDatabase db = new RatingDatabase(context);
                            db.deleteRating(ratings.get(getLayoutPosition()).getId());
                            ratings.remove(getLayoutPosition());
                            notifyItemRemoved(getAdapterPosition());
                            db.close();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
            return false;
        }
    }
}
