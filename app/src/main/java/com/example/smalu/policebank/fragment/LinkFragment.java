package com.example.smalu.policebank.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.linkAdapter;
import com.example.smalu.policebank.bean.Document;
import com.example.smalu.policebank.utils.CONST;
import com.example.smalu.policebank.utils.ResponseObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONArray;
import org.json.JSONObject;

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
    private linkAdapter adapter;
    private RequestQueue mRequestQueue;
    private List<Document> result;
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
//        data = getData();
        mRequestQueue =  Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                CONST.HOST+CONST.Document , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("TAG", response.toString());
                Gson gosn = new GsonBuilder().create();
                result = gosn.fromJson(
                        response.toString(),
                        new TypeToken<List<Document>>() {
                        }.getType());
                for(int i=0;i<response.length();i++){
                        result.get(i).getId();
                    Log.d("id",result.get(i).getId());
                }
//                Toast.makeText(context,result.get(0).getId(),Toast.LENGTH_SHORT).show();
                adapter = new linkAdapter(context,result);
                listView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("发生了一个错误！");
                error.printStackTrace();
            }

        });
        mRequestQueue.add(jsonArrayRequest);

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
