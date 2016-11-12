package com.example.smalu.policebank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.smalu.policebank.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Smalu on 2016/11/11.
 */

public class MyFragment extends Fragment{

    private ListView lv;
    private List<Map<String,Object>> list;
    private String [] text = {"密码修改","我的检查","我的消息"};
    private SimpleAdapter adapter;

    public MyFragment(){
//            this.connext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment,container,false);
//        mTextView = (TextView)view.findViewById(R.id.txt_content);
        lv = (ListView) view.findViewById(R.id.my_listview);
        list = new ArrayList<Map<String ,Object>>();
        adapter = new SimpleAdapter(getActivity(),getData(),R.layout.item_listview_my,
                new String[]{"text"},new int []{R.id.edit_my_listet});
        lv.setAdapter(adapter);
        return view;
    }

    public List<Map<String,Object>> getData(){
        for (int i = 0;i<text.length;i++){
            Map<String ,Object> map = new HashMap<String,Object>();
            map.put("text",text[i]);
            list.add(map);
        }
        return list;
    }
}
