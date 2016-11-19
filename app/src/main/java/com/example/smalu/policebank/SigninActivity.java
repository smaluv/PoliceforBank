package com.example.smalu.policebank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smalu.policebank.bean.JsonData;
import com.example.smalu.policebank.bean.Userinfo;

import org.json.JSONObject;

import static com.example.smalu.policebank.utils.CONTS.ServerIp;

/**
 * Created by KL on 2016/11/12 0012.
 */

public class SigninActivity extends Activity implements View.OnClickListener{

    private EditText et1,et2;
    private TextView tv_register;
    private Button btn_sign;
    private RequestQueue mQueue;
    private String text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mQueue = Volley.newRequestQueue(SigninActivity.this);
        tv_register = (TextView) findViewById(R.id.tv_register);
        btn_sign = (Button) findViewById(R.id.btn_sign);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv_register.setOnClickListener(this);
        btn_sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.tv_sign_findpwd:{
//                intent = new Intent(SigninActivity.this,)
//                break;
            case R.id.tv_register:{
                Intent intent = new Intent(SigninActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_sign:{
                //传数据给数据库
                text1 = et1.getText().toString();
                text2 = et2.getText().toString();
                String url = ServerIp+"login?phone="+text1+"&pwd="+text2;
                Log.i("TAG",url);
               //ServerIp+"login?phone="+text1+"&pwd="+text2,

//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url,null,
//                        new Response.Listener<JSONObject>(){
//                           @Override
//                            public void onResponse(JSONObject response){
//                               Log.d("TAG", response.toString());
//                               String mJSON = response.toString();
////                               Userinfo userinfo =
////
////                               userinfo = JSON.parseObject(mJSON,Userinfo.class);
//
//                           }
//                        },new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
//                    }
//                });
//                mQueue.add(jsonObjectRequest);
////


    StringRequest stringRequest = new StringRequest(url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//                                Log.d("TAG", response);
                                Userinfo userinfo = JSON.parseObject(response,Userinfo.class);
                                String s = userinfo.getState().toString();
//                                Log.i("TAG",s);
                                if (s.equals("0")){
                                    Toast.makeText(SigninActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                                }else if(s.equals("1")){
                                    Toast.makeText(SigninActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("username",text1);
                                    Intent intent = new Intent(SigninActivity.this,MainActivity.class);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
                mQueue.add(stringRequest);
                break;
            }
        }//switch()
    }//onClick

//    private String createJson(){
//        JSONObject jsonObject = new JSONObject();
//        return jsonObject.toString();
//    }
}
