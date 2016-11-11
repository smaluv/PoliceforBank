package com.example.smalu.policebank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smalu.policebank.R;

/**
 * Created by Smalu on 2016/11/11.
 */

public class LinkFragment extends Fragment{


    public LinkFragment(){
//            this.connext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.link_fragment,container,false);
//        mTextView = (TextView)view.findViewById(R.id.txt_content);

        return view;
    }
}
