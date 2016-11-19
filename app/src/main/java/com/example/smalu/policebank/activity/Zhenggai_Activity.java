package com.example.smalu.policebank.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.ZhenggaiAdapter;
import com.example.smalu.policebank.bean.Document;
import com.example.smalu.policebank.utils.CONST;
import com.example.smalu.policebank.utils.Theone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Zhenggai_Activity extends AppCompatActivity {
    private List<Theone>list=new ArrayList<Theone>();
    private RequestQueue mRequestQueue;
    private List<Document> result;
    private  String url="http://100.73.96.65:8080/bank/Document";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhenggai_activity);
        ListView listView= (ListView) findViewById(R.id.listview);
        ImageView back =(ImageView)findViewById(R.id.bback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        mRequestQueue =  Volley.newRequestQueue(this);
        init();
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
//                CONST.HOST+CONST.CheckQuery , new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.d("TAG", response.toString());
//                Gson gosn = new GsonBuilder().create();
//                result = gosn.fromJson(
//                        response.toString(),
//                        new TypeToken<List<Document>>() {
//                        }.getType());
////                for(int i=0;i<response.length();i++){
////                        result.get(i).getId();
////                    Log.d("id",result.get(i).getId());
////                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("发生了一个错误！");
//                error.printStackTrace();
//            }
//
//        });
//        mRequestQueue.add(jsonArrayRequest);
        ZhenggaiAdapter adapter=new ZhenggaiAdapter(Zhenggai_Activity.this,list);
        listView.setAdapter(adapter);
////        setListViewHeightBasedOnChildren(listView);

    }




    private void init() {

//        String jsonUrArrUrl = "http://152.123.55.102:8080/index.php";
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://152.123.55.102:8080/index.php", null,
//                new Response.Listener<JSONArray>(){
//            @Override
//            public void onResponse(JSONArray response) {
//                System.out.println("json data===" + response);
//            }
//        }, new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("发生了一个错误！");
//                error.printStackTrace();
//            }
//        });
//        mRequestQueue.add(jsonArrayRequest);

        Theone one=new Theone("上饶启舰有限责任公司","2016 ","11","14","广丰区大队","张三","15870032052","你单位存在严重的污染现象",
                "全部整改","2016","12","12");
        Theone two=new Theone("上饶启舰有限责任公司","2016 ","11","14","广丰区大队","张三","15870032052","你单位存在严重的污染现象",
                "全部整改","2016","12","12");
        list.add(one);
        list.add(two);
    }
//    public void setListViewHeightBasedOnChildren(ListView listView) {
//        ListAdapter listAdapter = listView.getAdapter();
//        if (listAdapter == null) {
//            return;
//        }
//        int totalHeight = 0;
//        for (int i = 0; i < listAdapter.getCount(); i++) {
//            View listItem = listAdapter.getView(i, null, listView);
//            listItem.measure(0, 0);
//            totalHeight += listItem.getMeasuredHeight();
//        }
//        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        params.height = totalHeight
//                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
//        listView.setLayoutParams(params);
//    }
}
