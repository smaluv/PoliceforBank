package com.example.smalu.policebank.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.RegisterActivity;
import com.example.smalu.policebank.SigninActivity;
import com.example.smalu.policebank.activity.My_MessageActivity;
import com.example.smalu.policebank.activity.Zhenggai_Activity;


/**
 * Created by Smalu on 2016/11/11.
 */

public class MyFragment extends Fragment {

    private TextView tv,text_mycheck,text_mymessage;
//    private Button btn_sign;
//    private Button btn_reg;

    public MyFragment(){
//            this.connext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.my_fragment,container,false);
        tv = (TextView) view.findViewById(R.id.tv1);
        Bundle bundle = getArguments();
        tv.setText(bundle.getString("username"));
        text_mycheck=(TextView)view.findViewById(R.id.text_mycheck);
        text_mycheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(view.getContext(), Zhenggai_Activity.class);
                startActivity(intent);
            }
        });
        text_mymessage=(TextView)view.findViewById(R.id.text_mymessage);
        text_mymessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(view.getContext(), My_MessageActivity.class);
                startActivity(intent);
            }
        });
        //textview显示获得的用户名

//        mTextView = (TextView)view.findViewById(R.id.txt_content);
//        btn_sign = (Button) view.findViewById(R.id.btn_sign);
//        btn_reg = (Button) view.findViewById(R.id.btn_register);
//
//        btn_sign.setOnClickListener(this);
//        btn_reg.setOnClickListener(this);

        return view;
    }

//    @Override
//    public void onClick(View view) {
//        Intent intent;
//        switch (view.getId()){
//            case R.id.btn_sign:{
//                intent = new Intent(getActivity(), SigninActivity.class);
//                startActivity(intent);
//            }
//            case R.id.btn_register:{
//                intent = new Intent(getActivity(), RegisterActivity.class);
//                startActivity(intent);
//            }
//            break;
//        }
//    }
}
