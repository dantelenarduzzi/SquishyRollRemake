package com.example.squishyrollremake;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.squishyrollremake.Database.AnimeDatabase;
import com.example.squishyrollremake.pojo.Anime;

import java.util.ArrayList;

import static com.example.squishyrollremake.MainActivity.fab;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LibraryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LibraryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LibraryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LibraryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LibraryFragment newInstance(String param1, String param2) {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extra = new Bundle();
                Navigation.findNavController(view)
                        .navigate(R.id.searchFragment, extra);
            }

        });


        ArrayList<Anime> animes = new ArrayList<>();
        AnimeDatabase db = new AnimeDatabase(getContext());
        db.addAnime(new Anime("Cowboy Bepop","","In the year 2071, humanity has colonoized several of the planets and moons...\n"));
        db.close();
        return view;
    }
}