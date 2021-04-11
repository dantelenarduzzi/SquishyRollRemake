package com.example.squishyrollremake;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.squishyrollremake.Database.AnimeDatabase;
import com.example.squishyrollremake.pojo.Anime;


public class SearchFragment extends Fragment {

    Anime anime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        EditText name = view.findViewById(R.id.AnimeName );
        Button submit = view.findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anime.setTitles(name.getText().toString());

                AnimeDatabase db = new AnimeDatabase(getContext());
            }
        });
        return view;
    }
}