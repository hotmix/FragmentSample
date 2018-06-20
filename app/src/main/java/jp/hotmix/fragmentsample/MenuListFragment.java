package jp.hotmix.fragmentsample;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuListFragment extends Fragment {

    private Activity _parentActivity;


    public MenuListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        ListView lvMenu = view.findViewById(R.id.lvMenu);
        List<Map<String, String>> menuList = createTeishokuList();

        String[] from = {"name", "price"};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(_parentActivity, menuList, android.R.layout.simple_list_item_2, from, to);

        lvMenu.setAdapter(adapter);

        return view;
    }

    private List<Map<String, String>> createTeishokuList(){
        List<Map<String, String>> menuList = new ArrayList<>();

        Map<String, String> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", "800");
        menu.put("desc", "若鶏の唐揚げにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "850");
        menu.put("desc", "ハンバーグにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", "850");
        menu.put("desc", "生姜焼きにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", "1000");
        menu.put("desc", "ステーキにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", "750");
        menu.put("desc", "野菜炒めにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", "900");
        menu.put("desc", "とんかつにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチカツ定食");
        menu.put("price", "850");
        menu.put("desc", "ミンチカツにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", "900");
        menu.put("desc", "チキンカツにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", "850");
        menu.put("desc", "コロッケにサラダ、ご飯とお味噌汁がつきます");
        menuList.add(menu);

        return menuList;
    }


}
