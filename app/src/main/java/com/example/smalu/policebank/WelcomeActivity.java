package com.example.smalu.policebank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by KL on 2016/11/12 0012.
 */

public class WelcomeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        Intent intent = new Intent(WelcomeActivity.this,SigninActivity.class);
        startActivity(intent);
        finish();
    }
}
