package com.example.smalu.policebank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
                if (!isMobile(text1)){
                    Toast.makeText(getApplication(),"请输入正确的手机号码",Toast.LENGTH_SHORT).show();
                }else{
                    if (!(text2.length()==6)){
                        Toast.makeText(getApplication(),"请输入6位密码",Toast.LENGTH_SHORT).show();
                    }else if(!emailValidation(text5)){
                        Toast.makeText(getApplication(),"请输入正确的邮箱",Toast.LENGTH_SHORT).show();
                    }else if (text2.equals("")||text1.equals("")||text4.equals("")||text5.equals("")){
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
    public boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }

    public boolean emailValidation(String email) {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }

}
