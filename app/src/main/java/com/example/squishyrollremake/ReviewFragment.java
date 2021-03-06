package com.example.squishyrollremake;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.squishyrollremake.Adapter.CustomReviewAdapter;
import com.example.squishyrollremake.Database.AnimeDatabase;
import com.example.squishyrollremake.Database.RatingDatabase;
import com.example.squishyrollremake.Fragments.CreateUpdateFragment;
import com.example.squishyrollremake.pojo.Anime;
import com.example.squishyrollremake.pojo.Rating;

import static com.example.squishyrollremake.MainActivity.fab;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
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
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_review, container, false);

        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extra = new Bundle();
                extra.putInt(CreateUpdateFragment.ACTION_TYPE,
                        CreateUpdateFragment.CREATE);
                Navigation.findNavController(view)
                        .navigate(R.id.createUpdateFragment, extra);
            }

        });

        RatingDatabase db = new RatingDatabase(getContext());
        ArrayList<Rating> Ratings = db.getAllRating();
        db.close();


      //  Ratings.add(new Rating("Attack on titan","Greatest TV show of all time, the manga is incredible and I can???t wait for Season 4. Eren Yeager is probably one of the greatest characters in all of anime. Isayama took a big risk with Eren???s character and it paid off. What a better way to improve upon an already flawed protagonist by pitting him against his friends. I don???t want to call Eren an antagonist either, his motives are very understandable and he is so well written."));

        RecyclerView recyclerView = view.findViewById(R.id.reviewList);
        CustomReviewAdapter adapter = new CustomReviewAdapter(Ratings,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }
}