package com.example.squishyrollremake.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.squishyrollremake.Database.AnimeDatabase;
import com.example.squishyrollremake.R;
import com.example.squishyrollremake.pojo.Anime;


public class SearchFragment extends Fragment {

    Anime anime;
    public static final int UPDATE = 1;
    public static final int CREATE = 2;

    public static final String ANIME = "Anime";
    public static final String ACTION_TYPE = "action_type";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        EditText name = view.findViewById(R.id.AnimeName );
        Button search = view.findViewById(R.id.searchButton);

        //if we have a bundle
        if(getArguments() != null) {
            if (getArguments().getInt(ACTION_TYPE) == UPDATE) {
                anime = getArguments().getParcelable(ANIME);
                if (anime != null) {
                    //populate the current locations values into the respective fields
                    name.setText(anime.getTitles());

                }
            } else {
                anime = new Anime();
                search.setText("Search");
            }
            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    anime.setTitles(name.getText().toString());

                    AnimeDatabase db = new AnimeDatabase(getContext());
                    if (getArguments().getInt(ACTION_TYPE) == UPDATE) {
                        db.updateAnime(anime);
                    } else if (getArguments().getInt(ACTION_TYPE) == CREATE) {
                        db.addAnime(anime);
                    }
                    db.close();
                    Navigation.findNavController(view).popBackStack();
                }
            });

        }

        return view;
    }
}