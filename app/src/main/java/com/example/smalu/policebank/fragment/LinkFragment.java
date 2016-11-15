package com.example.smalu.policebank.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.linkAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Smalu on 2016/11/11.
 */

public class LinkFragment extends Fragment{

    private ListView listView;
    private List<Map<String, Object>> data;
    private Context context;
    public LinkFragment(){}

    public LinkFragment(Context context){
            this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.link_fragment,container,false);
        listView = (ListView)view.findViewById(R.id.link_listview);
        //获取将要绑定的数据设置到data中
        data = getData();
        linkAdapter adapter;
        adapter = new linkAdapter(context,data);
        listView.setAdapter(adapter);
        return view;
    }

    //创建数据
    private List<Map<String, Object>> getData()
    {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for(int i=0;i<20;i++)
        {
            map = new HashMap<String, Object>();
            map.put("link_num", "1");
            map.put("link_content", "相关文件");
            map.put("link_time", "2016-11-11");
            list.add(map);
        }
        return list;
    }

}
