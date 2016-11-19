package com.example.smalu.policebank.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smalu.policebank.R;

/**
 * Created by KL on 2016/11/16 0016.
 */

public class ZhenggaiActivity extends Activity implements View.OnClickListener{
    private Button btn1,btn2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinggu);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:{
                intent = new Intent(ZhenggaiActivity.this,Pinggu_qingkuang.class);
                startActivity(intent);
                break;
            }
            case R.id.btn2:{
                intent = new Intent(ZhenggaiActivity.this,Pinggu_fenshu.class);
                startActivity(intent);
                break;
            }
        }
    }
}
