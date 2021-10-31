package org.techtown.wanted_app_main.Fragment;
//
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import org.techtown.wanted_app_main.Fragment.Community.Club;
import org.techtown.wanted_app_main.Fragment.Community.Contest;
import org.techtown.wanted_app_main.Fragment.Community.FragmentAdapter;
import org.techtown.wanted_app_main.Fragment.Community.Outdoor_activities;
import org.techtown.wanted_app_main.Fragment.Community.Study;
import org.techtown.wanted_app_main.R;

public class CommunityFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter adapter;

    private static NavController navController;

    public CommunityFragment() {
        // Required empty public constructor
    }

    public static CommunityFragment newInstance(String param1, String param2) {
        CommunityFragment fragment = new CommunityFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root =inflater.inflate(R.layout.fragment_community, container, false);


        tabLayout=root.findViewById(R.id.tabs);
        viewPager=root.findViewById(R.id.view_pager);
        adapter=new FragmentAdapter(getActivity().getSupportFragmentManager(),1);

        adapter.addFragment(new Contest());
        adapter.addFragment(new Outdoor_activities());
        adapter.addFragment(new Club());
        adapter.addFragment(new Study());

        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("공모전");
        tabLayout.getTabAt(1).setText("대외활동");
        tabLayout.getTabAt(2).setText("동아리");
        tabLayout.getTabAt(3).setText("스터디");

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }
}