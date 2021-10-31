package org.techtown.wanted_app_main.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import org.techtown.wanted_app_main.R;

public class MainFragment extends Fragment {

    private static NavController navController;
    private static String spinnerString = "학교친구";
    private static String[] friendsCategoryList;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        friendsCategoryList = getResources().getStringArray(R.array.friends_array);

        // 스피너 값 값 가져오기
        Spinner friends_category = view.findViewById(R.id.main_spinner_category);
        ArrayAdapter<String> friendsAdapter = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_item, friendsCategoryList); // resource 데이터 넣기

        friendsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 드롭다운 클릭시 선택창 방식
        friends_category.setAdapter(friendsAdapter);

        // 스피너 이벤트 반응
        friends_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerString = friends_category.getSelectedItem().toString();
                System.out.println("친구 선택됨" + spinnerString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerString = "학교친구";
                System.out.println("아무것도 선택안됨");
            }
        });

        // 버튼클릭시 친구리스트 조회
        Button btnGoFriend = view.findViewById(R.id.main_btn_goFriend);

        btnGoFriend.setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putString("friendsCategory", spinnerString);
            navController.navigate(R.id.action_mainFragment_to_showFriendsFragment, bundle);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }
}