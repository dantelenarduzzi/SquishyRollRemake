package com.example.squishyrollremake;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import static com.example.squishyrollremake.MainActivity.fab;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    ViewPager2 listViewPager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        fab.hide();
        listViewPager = view.findViewById(R.id.listViewPager2);
        listViewPager.setAdapter(new CustomViewPager2Adapter(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, listViewPager, (tab, position) ->
                tab.setText("Anime " + (position +1))).attach();
    }


    private class CustomViewPager2Adapter extends FragmentStateAdapter {

        public CustomViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return WatchedFragment.newInstance("Attack On Titan", "Centuries ago, mankind was slaughtered to near extinction by monstrous humanoid creatures called titans, forcing humans to hide in fear behind enormous concentric walls. What makes these giants truly terrifying is that their taste for human flesh is not born out of hunger but what appears to be out of pleasure. To ensure their survival, the remnants of humanity began living within defensive barriers, resulting in one hundred years without a single titan encounter. However, that fragile calm is soon shattered when a colossal titan manages to breach the supposedly impregnable outer wall, reigniting the fight for survival against\n" +
                            "        the man-eating abominations.\\n\\n After witnessing a horrific personal loss at the hands of the invading creatures, Eren Yeager dedicates his life to their eradication by enlisting into the Survey Corps, an elite military unit that combats the merciless humanoids outside the protection of the walls. Based on Hajime Isayamas award-winning manga, Shingeki no Kyojin follows Eren, along with his adopted sister Mikasa Ackerman\n" +
                            "        and his childhood friend Armin Arlert, as they join the brutal war against the titans and race to discover a way of defeating them before the last walls are breached");
                case 1:
                    return WatchedFragment.newInstance("Dr.Stone", "Several thousand years after a mysterious phenomenon that turns all of humanity to stone, " +
                            "the extraordinarily intelligent, science-driven boy, Senku Ishigami, awakens.\\n\\nFacing a world of stone and the total collapse" +
                            " of civilization, Senku makes up his mind to use science to rebuild the world. Starting with his super strong childhood friend Taiju Oki," +
                            " who awakened at the same time, they will begin to rebuild civilization from nothing...\\n\\nDepicting two million years of scientific" +
                            " history from the Stone Age to present day, the unprecedented crafting adventure story is about to begin!\\n\\n(Source: Crunchyroll)\"," +
                            "\"description\":\"Several thousand years after a mysterious phenomenon that turns all of humanity to stone, the extraordinarily intelligent, science-driven boy, Senku Ishigami, awakens.\\n\\nFacing a world of stone and the total collapse of civilization," +
                            " Senku makes up his mind to use science to rebuild the world.");
                case 2:
                    return WatchedFragment.newInstance("Naruto", "\"Moments prior to Naruto Uzumaki's birth, a huge demon known as the Kyuubi, " +
                            "the Nine-Tailed Fox, attacked Konohagakure, the Hidden Leaf Village, and wreaked havoc. In order to put an end to the Kyuubi's" +
                            " rampage, the leader of the village, the Fourth Hokage, sacrificed his life and sealed the monstrous beast inside the newborn Naruto.\\nNow," +
                            " Naruto is a hyperactive and knuckle-headed ninja still living in Konohagakure. Shunned because of the Kyuubi inside him, Naruto struggles to " +
                            "find his place in the village, while his burning desire to become the Hokage of Konohagakure leads him not only to some great new friends, but also " +
                            "some deadly foes.\\n[Written by MAL Rewrite]\",\"description\":\"Moments prior to Naruto Uzumaki's birth, a huge demon known as the Kyuubi, the Nine-Tailed Fox, attacked Konohagakure, the Hidden Leaf Village, " +
                            "and wreaked havoc. In order to put an end to the Kyuubi's rampage, the leader of the village, the Fourth Hokage, sacrificed his life and sealed the" +
                            " monstrous beast inside the newborn Naruto.\\nNow, Naruto is a hyperactive and knuckle-headed ninja still living in Konohagakure. Shunned because of the" +
                            " Kyuubi inside him, Naruto struggles to find his place in the village, while his burning desire to become the Hokage of Konohagakure leads him not only " +
                            "to some great new friends, but also some deadly foes.");
                case 3:
                    return WatchedFragment.newInstance("Demon Slayer", "\"Onigiri thrusts its players into mystical Japan, a land " +
                            "filled with mythical creatures of Japanese legend. Starting as a lone Oni, players fight against the malevolent influence of " +
                            "the Kamikui as their miasma spreads over the land. 8 NPCs, each with their own distinct personality and skills, ally themselves with " +
                            "the player to help build a legend, and quell the evil that has arisen. As you grow stronger together, so do the bonds binding you to each other." +
                            "\\n(Source: ANN)\",\"description\":\"Onigiri thrusts its players into mystical Japan, a land filled with mythical creatures of Japanese legend." +
                            " Starting as a lone Oni, players fight against the malevolent influence of the Kamikui as their miasma spreads over the land. 8 NPCs, each with " +
                            "their own distinct personality and skills, ally themselves with the player to help build a legend, and quell the evil that has arisen. As you " +
                            "grow stronger together, so do the bonds binding you to each other.");
                default:
                    return WatchedFragment.newInstance("Sample", "Sample");
            }

        }

        @Override
        public int getItemCount() {
            return 4;
        }

    }
}