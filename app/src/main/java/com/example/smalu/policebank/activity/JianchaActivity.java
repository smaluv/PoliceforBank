package com.example.smalu.policebank.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smalu.policebank.R;

/**
 * Created by KL on 2016/11/13 0013.
 */

public class JianchaActivity extends Activity implements View.OnClickListener{

    private Button btn_yewuku,btn_yingyechangsuo,btn_zizhu;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiancha);

        btn_yewuku = (Button) findViewById(R.id.btn_yewuku);
        btn_yingyechangsuo = (Button) findViewById(R.id.btn_yingyechangsuo);
        btn_zizhu = (Button) findViewById(R.id.btn_zizhu);

        btn_yewuku.setOnClickListener(this);
        btn_yingyechangsuo.setOnClickListener(this);
        btn_zizhu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_yewuku :{
                intent = new Intent(JianchaActivity.this, Jiancha_yewukuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_yingyechangsuo :{
                intent = new Intent(JianchaActivity.this, Jiancha_yingyeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_zizhu:{
                intent = new Intent(JianchaActivity.this, Jiancha_autoActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
