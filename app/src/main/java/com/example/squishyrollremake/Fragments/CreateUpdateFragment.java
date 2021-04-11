package com.example.squishyrollremake.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.squishyrollremake.Database.RatingDatabase;
import com.example.squishyrollremake.R;
import com.example.squishyrollremake.ReviewFragment;
import com.example.squishyrollremake.pojo.Rating;


public class CreateUpdateFragment extends Fragment {

    Rating Rating;

    public static final int UPDATE = 1;
    public static final int CREATE = 2;

    public static final String RATING = "Rating";
    public static final String ACTION_TYPE = "action_type";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_create_update, container, false);

        EditText name = view.findViewById(R.id.title);
        EditText review = view.findViewById(R.id.Review);
        Button submit = view.findViewById(R.id.submitButton);

        if(getArguments() != null){

            if(getArguments().getInt(ACTION_TYPE) == UPDATE) {
                Rating = getArguments().getParcelable(RATING);
                submit.setText("UPDATE");
                if(Rating != null){
                    name.setText(Rating.getName());
                    review.setText(Rating.getDescription());
                }
            }
            else{ Rating = new Rating();
                submit.setText("CREATE");

            }
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Rating.setName(name.getText().toString());
                    Rating.setDescription(review.getText().toString());

                    RatingDatabase db = new RatingDatabase(getContext());
                    if (getArguments().getInt(ACTION_TYPE) == UPDATE) {

                        db.updateRating(Rating);
                    } else if (getArguments().getInt(ACTION_TYPE) == CREATE){
                        db.addRating(Rating);
                    }
                    db.close();
                    Navigation.findNavController(view).popBackStack();
                }

            });
        }

        return view;
    }
}