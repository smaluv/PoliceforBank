package com.example.smalu.policebank.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.RegisterActivity;
import com.example.smalu.policebank.SigninActivity;


/**
 * Created by Smalu on 2016/11/11.
 */

public class MyFragment extends Fragment implements View.OnClickListener{

    private Button btn_sign;
    private Button btn_reg;

    public MyFragment(){
//            this.connext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment,container,false);
//        mTextView = (TextView)view.findViewById(R.id.txt_content);
        btn_sign = (Button) view.findViewById(R.id.btn_sign);
        btn_reg = (Button) view.findViewById(R.id.btn_register);

        btn_sign.setOnClickListener(this);
        btn_reg.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_sign:{
                intent = new Intent(getActivity(), SigninActivity.class);
                startActivity(intent);
            }
            case R.id.btn_register:{
                intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
