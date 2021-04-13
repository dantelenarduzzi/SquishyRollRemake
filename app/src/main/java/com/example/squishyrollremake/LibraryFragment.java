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
        animes.add(new Anime("Attack on titan","Centuries ago, mankind was slaughtered to near extinction by monstrous humanoid creatures called titans, forcing humans to hide in fear behind enormous concentric walls. What makes these giants truly terrifying is that their taste for human flesh is not born out of hunger but what appears to be out of pleasure. To ensure their survival, the remnants of humanity began living within defensive barriers, resulting in one hundred years without a single titan encounter. However, that fragile calm is soon shattered when a colossal titan manages to breach the supposedly impregnable outer wall, reigniting the fight for survival against\n" +
                "        the man-eating abominations. After witnessing a horrific personal loss at the hands of the invading creatures, Eren Yeager dedicates his life to their eradication by enlisting into the Survey Corps, an elite military unit that combats the merciless humanoids outside the protection of the walls. Based on Hajime Isayamas award-winning manga, Shingeki no Kyojin follows Eren, along with his adopted sister Mikasa Ackerman\n" +
                "        and his childhood friend Armin Arlert, as they join the brutal war against the titans and race to discover a way of defeating them before the last walls are breached"));
        animes.add(new Anime("Dr.Stone", "Several thousand years after a mysterious phenomenon that turns all of humanity to stone, " +
                "the extraordinarily intelligent, science-driven boy, Senku Ishigami, awakens. Facing a world of stone and the total collapse" +
                " of civilization, Senku makes up his mind to use science to rebuild the world. Starting with his super strong childhood friend Taiju Oki," +
                " who awakened at the same time, they will begin to rebuild civilization from nothing..Depicting two million years of scientific" +
                " history from the Stone Age to present day, the unprecedented crafting adventure story is about to begin!\"," +
                ""));
        animes.add(new Anime("Naruto", "\"Moments prior to Naruto Uzumaki's birth, a huge demon known as the Kyuubi, " +
                "the Nine-Tailed Fox, attacked Konohagakure, the Hidden Leaf Village, and wreaked havoc. In order to put an end to the Kyuubi's" +
                " rampage, the leader of the village, the Fourth Hokage, sacrificed his life and sealed the monstrous beast inside the newborn Naruto.Now," +
                " Naruto is a hyperactive and knuckle-headed ninja still living in Konohagakure. Shunned because of the Kyuubi inside him, Naruto struggles to " +
                "find his place in the village, while his burning desire to become the Hokage of Konohagakure leads him not only to some great new friends, but also " +
                "some deadly foes."));
        //  Ratings.add(new Rating("Attack on titan","Greatest TV show of all time, the manga is incredible and I can’t wait for Season 4. Eren Yeager is probably one of the
        //  greatest characters in all of anime. Isayama took a big risk with Eren’s character and it paid off. What a better way to improve upon an already
        //  flawed protagonist by pitting him against his friends. I don’t want to call Eren an antagonist either, his motives are very understandable and he
        //  is so well written."));

        db.close();

        RecyclerView recyclerView = view.findViewById(R.id.libraryList);
        CustomLibraryAdapter adapter = new CustomLibraryAdapter(animes,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}