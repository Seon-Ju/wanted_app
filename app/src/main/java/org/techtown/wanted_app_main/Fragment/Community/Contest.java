package org.techtown.wanted_app_main.Fragment.Community;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.techtown.wanted_app_main.R;

import java.util.ArrayList;


public class Contest extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_contest, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.postre);

        recyclerView.setLayoutManager(layoutManager);
        PostAdapter adapter = new PostAdapter();
        adapter.clearItem();
        adapter.addItem(new Post("dd","원티드 해커톤","개발자 구합니다"));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClicklistener(new PostAdapter.OnPostItemClickListener() {
            @Override
            public void onItemClick(PostAdapter.ViewHolder holder, View view, ArrayList<Post> items, int position) {

            }
        });



        return root;
    }
}