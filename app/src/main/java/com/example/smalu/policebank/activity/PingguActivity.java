package com.example.smalu.policebank.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smalu.policebank.R;
import com.example.smalu.policebank.modle.UserData;

import static com.example.smalu.policebank.utils.CONTS.ServerIp;

/**
 * Created by KL on 2016/11/16 0016.
 */

public class PingguActivity extends Activity{

    private RequestQueue mQueue;
    private TextView tv_title;
    private EditText et_check1,et_check2,et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et19,et20,
            et21,et22,et23,et24,et25,et26,et27,et28,et29,et30,et31,et32,et33,et34,et35,et36,et37,et38,et39,et40,et41,et42;
    private Button btn;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pinggu);
        mQueue = Volley.newRequestQueue(PingguActivity.this);
        initView();
    }

    private void initView(){
        et_check1 = (EditText) findViewById(R.id.et_check1);
        et_check2 = (EditText) findViewById(R.id.et_check2);
        tv_title = (TextView) findViewById(R.id.txt_top);
        iv_back = (ImageView) findViewById(R.id.title_id);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        et8 = (EditText) findViewById(R.id.et8);
        et9 = (EditText) findViewById(R.id.et9);
        et10 = (EditText) findViewById(R.id.et10);
        et11 = (EditText) findViewById(R.id.et11);
        et12 = (EditText) findViewById(R.id.et12);
        et13 = (EditText) findViewById(R.id.et13);
        et14 = (EditText) findViewById(R.id.et14);
        et15 = (EditText) findViewById(R.id.et15);
        et16 = (EditText) findViewById(R.id.et16);
        et17 = (EditText) findViewById(R.id.et17);
        et18 = (EditText) findViewById(R.id.et18);
        et19 = (EditText) findViewById(R.id.et19);
        et20 = (EditText) findViewById(R.id.et20);
        et21 = (EditText) findViewById(R.id.et21);
        et22 = (EditText) findViewById(R.id.et22);
        et23 = (EditText) findViewById(R.id.et23);
        et24 = (EditText) findViewById(R.id.et24);
        et25 = (EditText) findViewById(R.id.et25);
        et26 = (EditText) findViewById(R.id.et26);
        et27 = (EditText) findViewById(R.id.et27);
        et28 = (EditText) findViewById(R.id.et28);
        et29 = (EditText) findViewById(R.id.et29);
        et30 = (EditText) findViewById(R.id.et30);
        et31 = (EditText) findViewById(R.id.et31);
        et32 = (EditText) findViewById(R.id.et32);
        et33 = (EditText) findViewById(R.id.et33);
        et34 = (EditText) findViewById(R.id.et34);
        et35 = (EditText) findViewById(R.id.et35);
        et36 = (EditText) findViewById(R.id.et36);
        et37 = (EditText) findViewById(R.id.et37);
        et38 = (EditText) findViewById(R.id.et38);
        et39 = (EditText) findViewById(R.id.et39);
        et40 = (EditText) findViewById(R.id.et40);
        et41 = (EditText) findViewById(R.id.et41);
        et42 = (EditText) findViewById(R.id.et42);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_title.setText("安全评估计分");

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData ud = (UserData) getApplication();
                String username = ud.getUsername();
                String data[] = {et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),
                        et4.getText().toString(),et5.getText().toString(),et6.getText().toString(),
                        et7.getText().toString(),et8.getText().toString(),et9.getText().toString(),
                        et10.getText().toString(),et11.getText().toString(),et12.getText().toString(),
                        et13.getText().toString(),et14.getText().toString(),et15.getText().toString(),
                        et16.getText().toString(),et17.getText().toString(),et18.getText().toString(),
                        et19.getText().toString(),et20.getText().toString(),et21.getText().toString(),
                        et22.getText().toString(),et23.getText().toString(),et24.getText().toString(),
                        et25.getText().toString(),et26.getText().toString(),et27.getText().toString(),
                        et28.getText().toString(),et29.getText().toString(),et30.getText().toString(),
                        et31.getText().toString(),et32.getText().toString(),et33.getText().toString(),
                        et34.getText().toString(),et35.getText().toString(),et36.getText().toString(),
                        et37.getText().toString(),et38.getText().toString(),et39.getText().toString(),
                        et40.getText().toString(),et41.getText().toString(),et42.getText().toString(),
                        et_check1.getText().toString(),et_check2.getText().toString(),username};
                String url = ServerIp+"EvaluateInsert?item_equip_proj="+data[0]+"&item_equip_prob="+data[1]+"&item_equip_score="+data[2]+
                        "&tech_equip_proj="+data[3]+"&tech_equip_prob="+data[4]+"&tech_equip_score="+data[5]+"&en_pre_proj="+data[6]+"&en_pre_prob="+data[7]
                        +"&en_pre_score="+data[8]+"&tech_pre_proj="+data[9]+"&tech_pre_prob="+data[10]+"&tech_pre_score="+data[11]+"&loc_pre_proj="+data[12]
                        +"&loc_pre_prob="+data[13]+"&loc_pre_score="+data[14]+"&helf_safe_proj="+data[15]+"&helf_safe_prob="+data[16]+"&helf_safe_score="+data[17]+"&bank_safe_proj="+data[18]
                        +"&bank_safe_prob="+data[19]+"&bank_safe_score="+data[20]+"&tran_cash_proj="+data[21]+"&tran_cash_prob="+data[22]+"&tran_cash_score="+data[23]+"&fire_control_proj="+data[24]
                        +"&fire_control_prob="+data[25]+"&fire_control_score="+data[26]+"&compu_safe_proj="+data[27]+"&compu_safe_prob="+data[28]+"&compu_safe_score="+data[29]
                        +"&date_safe_proj="+data[30]+"&date_safe_prob="+data[31]+"&date_safe_score="+data[32]+"&gun_safe_proj="+data[33]+"&gun_safe_prob="+data[34]+"&gun_safe_score="+data[35]
                        +"&case_proj="+data[36]+"&case_prob="+data[37]+"&case_score="+data[38]+"&safe_defent_proj="+data[39]+"&safe_defent_prob="+data[40]+"&safe_defent_score="+data[41]
                        +"&assess_member="+data[42]+"&assess_leader="+data[43]+"&username="+data[44];

                Log.i("TAG",url);
                StringRequest stringRequest = new StringRequest(url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("TAG", response);
                                Toast.makeText(PingguActivity.this,"信息插入成功",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                        Toast.makeText(PingguActivity.this,"信息插入失败",Toast.LENGTH_SHORT).show();
                    }
                });
                mQueue.add(stringRequest);
            }
        });
    }

}
