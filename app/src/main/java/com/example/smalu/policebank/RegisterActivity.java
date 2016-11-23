package com.example.smalu.policebank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.example.smalu.policebank.utils.CONTS.ServerIp;

/**
 * Created by KL on 2016/11/12 0012.
 */

public class RegisterActivity extends Activity {
    RequestQueue mQueue;
    private EditText et1,et2,et3,et4,et5;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mQueue = Volley.newRequestQueue(RegisterActivity.this);
        initView();
        checked();
    }

    private void checked() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1,text2,text3,text4,text5;
                text1 = et1.getText().toString();
                text2 = et2.getText().toString();
                text3 = et3.getText().toString();
                text4 = et4.getText().toString();
                text5 = et5.getText().toString();
                if (text2.equals("")||text1.equals("")||text4.equals("")||text5.equals("")){
                    Toast.makeText(RegisterActivity.this,"请输入相关内容注册",Toast.LENGTH_SHORT).show();
                }else if(!text2.equals(text3)){
                    Toast.makeText(RegisterActivity.this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                    et2.setText("");
                    et3.setText("");
                }else {
                    //传数据给数据库
                    String url;
                    url = ServerIp+"Register?phone="+ text1 + "&pwd="+text2+"&city="+text4+"&email="+text5;
                    Log.i("TAG",url);
                    //需要修改HTTP地址
                    StringRequest stringRequest = new StringRequest(url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                    Log.d("TAG", response);
                                    Intent intent = new Intent(RegisterActivity.this,SigninActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", error.getMessage(), error);
                        }
                    });
                    mQueue.add(stringRequest);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        btn = (Button) findViewById(R.id.btn);
    }


}
