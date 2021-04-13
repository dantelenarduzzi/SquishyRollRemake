package com.example.squishyrollremake;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.squishyrollremake.Adapter.CustomLibraryAdapter;
import com.example.squishyrollremake.Database.AnimeDatabase;
import com.example.squishyrollremake.pojo.Anime;
import com.example.squishyrollremake.pojo.Rating;

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

        AnimeDatabase db = new AnimeDatabase(getContext());
        ArrayList<Anime> animes = db.getAllAnime();
       // animes.add(new Anime("Attack on titan","Greatest TV show of all time, the manga is incredible and I can’t wait for Season 4. Eren Yeager is probably one of the greatest characters in all of anime. Isayama took a big risk with Eren’s character and it paid off. What a better way to improve upon an already flawed protagonist by pitting him against his friends. I don’t want to call Eren an antagonist either, his motives are very understandable and he is so well written"));
        //  Ratings.add(new Rating("Attack on titan","Greatest TV show of all time, the manga is incredible and I can’t wait for Season 4. Eren Yeager is probably one of the greatest characters in all of anime. Isayama took a big risk with Eren’s character and it paid off. What a better way to improve upon an already flawed protagonist by pitting him against his friends. I don’t want to call Eren an antagonist either, his motives are very understandable and he is so well written."));

        db.close();

        RecyclerView recyclerView = view.findViewById(R.id.libraryList);
        CustomLibraryAdapter adapter = new CustomLibraryAdapter(animes,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}