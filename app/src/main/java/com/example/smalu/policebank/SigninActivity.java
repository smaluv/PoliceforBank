package com.example.smalu.policebank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by KL on 2016/11/12 0012.
 */

public class SigninActivity extends Activity implements View.OnClickListener{

    private TextView tv_register;
    private Button btn_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        tv_register = (TextView) findViewById(R.id.tv_register);
        btn_sign = (Button) findViewById(R.id.btn_sign);

        tv_register.setOnClickListener(this);
        btn_sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
//            case R.id.tv_sign_findpwd:{
//                intent = new Intent(SigninActivity.this,)
//                break;
            case R.id.tv_register:{
                intent = new Intent(SigninActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_sign:{
                intent = new Intent(SigninActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            }
        }//switch()
    }//onClick
}
