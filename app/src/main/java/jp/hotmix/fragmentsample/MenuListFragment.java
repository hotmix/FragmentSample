package jp.hotmix.fragmentsample;


import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private final static String TAG = "MenuFragment";
    private boolean _isLayoutXLarge = true;


    public MenuListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _parentActivity = getActivity();
        Log.i(TAG, "onCreate: called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG, "onCreateView: called");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        ListView lvMenu = view.findViewById(R.id.lvMenu);
        List<Map<String, String>> menuList = createTeishokuList();

        String[] from = {"name", "price"};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(_parentActivity, menuList, android.R.layout.simple_list_item_2, from, to);

        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ListItemClickListener());

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: called");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "onActivityCreated: called");

        View menuThanksFrame = _parentActivity.findViewById(R.id.menuThanksFrame);
        if (menuThanksFrame == null){
            _isLayoutXLarge = false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: called");
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

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>)parent.getItemAtPosition(position);

            String menuName = item.get("name");
            String menuPrice = item.get("price");

            Bundle bundle = new Bundle();
            bundle.putString("menuName", menuName);
            bundle.putString("menuPrice", menuPrice);

            if (_isLayoutXLarge) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                MenuThanksFragment menuThanksFragment = new MenuThanksFragment();
                menuThanksFragment.setArguments(bundle);
                transaction.replace(R.id.menuThanksFrame, menuThanksFragment);
                transaction.commit();
            } else {
                Intent intent = new Intent(_parentActivity, MenuThanksActivity.class);

                intent.putExtra("menuName", menuName);
                intent.putExtra("menuPrice", menuPrice);

                startActivity(intent);
            }
        }
    }


}
