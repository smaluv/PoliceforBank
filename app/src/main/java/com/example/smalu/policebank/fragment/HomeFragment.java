package com.example.smalu.policebank.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.smalu.policebank.R;

/**
 * Created by Smalu on 2016/11/11.
 */

public class HomeFragment  extends Fragment implements View.OnClickListener{

    private ImageView beian,jiancha,pinggu,zhenggai;
    private  Context context;

    public  HomeFragment(Context context){
            this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
//        jiancha=(ImageView)view.findViewById(R.id.jiancha);
//        beian=(ImageView)view.findViewById(R.id.beian);
//        pinggu=(ImageView)view.findViewById(R.id.pinggu);
//        zhenggai=(ImageView)view.findViewById(R.id.zhenggai);
        initView(view);//获取控件
        return view;
    }

    private void initView(View view){
        jiancha=(ImageView)view.findViewById(R.id.jiancha);
        beian=(ImageView)view.findViewById(R.id.beian);
        pinggu=(ImageView)view.findViewById(R.id.pinggu);
        zhenggai=(ImageView)view.findViewById(R.id.zhenggai);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.beian:
                //跳转备案
                break;
            case R.id.jiancha:

                break;
            case R.id.pinggu:

                break;
            case R.id.zhenggai:

                break;
        }
    }
}
