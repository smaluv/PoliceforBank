package com.example.smalu.policebank.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smalu.policebank.R;

import java.util.List;

/**
 * Created by Smalu on 2016/11/13.
 */

public class BeianActivity extends Activity {

    private Button beianValut,beianLobby,beianEquipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beian);
        beianValut=(Button)findViewById(R.id.beian_vault);
        beianValut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(BeianActivity.this,Beian_valutActivity.class);
                startActivity(intent);
            }
        });
        beianLobby=(Button)findViewById(R.id.beian_lobby);
        beianLobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(BeianActivity.this,Beian_lobbyActivity.class);
                startActivity(intent);
            }
        });
        beianEquipment=(Button)findViewById(R.id.beian_equipment);
        beianEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(BeianActivity.this,Beian_equipmentActivity.class);
                startActivity(intent);
            }
        });
    }




}
