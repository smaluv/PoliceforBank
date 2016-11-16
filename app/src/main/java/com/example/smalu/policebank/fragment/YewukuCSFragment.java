package com.example.smalu.policebank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smalu.policebank.R;

/**
 * Created by KL on 2016/11/14 0014.
 */

public class YewukuCSFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jiancha_ywk1,container,false);
        initview(view);
        return view;
    }

    public void initview(View view){

    }
    @Override
    public void onClick(View view) {

    }
}
