package com.example.smalu.policebank.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.smalu.policebank.activity.JianchaActivity;
import com.example.smalu.policebank.R;
import com.example.smalu.policebank.activity.BeianActivity;
import com.example.smalu.policebank.activity.PingguActivity;
import com.example.smalu.policebank.activity.Zhenggai_Activity;

/**
 * Created by Smalu on 2016/11/11.
 */

public class HomeFragment  extends Fragment implements View.OnClickListener{

    private Intent intent;
    private ImageView beian,jiancha,pinggu,zhenggai;
    private  Context context;
    private  String username;

    public HomeFragment(){}
    public HomeFragment(Context context){
            this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
//        jiancha=(ImageView)view.findViewById(R.id.jiancha);
//        Bundle bundle = getArguments();
//        username=bundle.getString("username1");
//        Log.d("username",username);
        beian=(ImageView)view.findViewById(R.id.beian);
        beian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,BeianActivity.class);
                startActivity(intent);
            }
        });
//        pinggu=(ImageView)view.findViewById(R.id.pinggu);
//        zhenggai=(ImageView)view.findViewById(R.id.zhenggai);
        initView(view);//获取控件并设置Onclick
        return view;
    }

    private void initView(View view){
        jiancha=(ImageView)view.findViewById(R.id.jiancha);
        beian=(ImageView)view.findViewById(R.id.beian);
        pinggu=(ImageView)view.findViewById(R.id.pinggu);
        zhenggai=(ImageView)view.findViewById(R.id.zhenggai);

        jiancha.setOnClickListener(this);
//        beian.setOnClickListener(this);
        pinggu.setOnClickListener(this);
        zhenggai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.beian:
                //跳转备案
//                Intent intent =new Intent(context, BeianActivity.class);
//                startActivity(intent);
                break;
            case R.id.jiancha:
                intent = new Intent(getActivity(), JianchaActivity.class);
                startActivity(intent);
                break;
            case R.id.pinggu:
                intent = new Intent(getActivity(), PingguActivity.class);
                startActivity(intent);
                break;
            case R.id.zhenggai:
                intent = new Intent(getActivity(), Zhenggai_Activity.class);
                startActivity(intent);
                break;
        }
    }
}
