package com.example.smalu.policebank.activity;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.viewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KL on 2016/11/17 0017.
 */

public class Pinggu_qingkuang extends Activity {

    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView cursor;// 动画图片
    private TextView tt;//标题
    private TextView t1, t2, t3;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度

    private View view1,view2,view3;
    private Button btn;
    private Spinner sp;
    private EditText et1,et2,et3,et4,et5,et6,et7,et8;
    private List<String> spinnerList;
    private ArrayAdapter<String> spinner_adapter;
    private String view_data;
    private String[] data;

    private EditText et21,et22,et23,et24,et25,et26,et27,et28,et29,et210,et211,et212,et213,et214,et215,et216,et217,et218;
    private EditText et31,et32,et33,et34,et35,et36,et37,et38,et39,et310,et311,et312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_common);

        InitImageView();
        InitTextView();
        InitViewPager();
    }
    private void InitTextView() {
        tt = (TextView) findViewById(R.id.txt_top);
        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);

        tt.setText("安全评估工作情况");
        t1.setText("基本情况");
        t2.setText("评估结果");
        t3.setText("设区市级银行业金融机构评估分值情况");

        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
    }
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.Viewpagerid);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();

        view1 = mInflater.inflate(R.layout.pinggu_qingkuang1, null);
        view2 = mInflater.inflate(R.layout.pinggu_qingkuang2, null);
        view3 = mInflater.inflate(R.layout.pinggu_qingkuang3, null);

        initPag1(view1);
        initPag2(view2);
        initPag3(view3);

        listViews.add(view1);
        listViews.add(view2);
        listViews.add(view3);

        mPager.setAdapter(new viewPagerAdapter(listViews));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }
    private void InitImageView() {
        cursor = (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.mipmap.a)
                .getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 3 - bmpW) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        cursor.setImageMatrix(matrix);// 设置动画初始位置
    }

    private void initPag1(View view){
        sp = (Spinner) view.findViewById(R.id.sp);
        et1 = (EditText) view.findViewById(R.id.et1);
        et2 = (EditText) view.findViewById(R.id.et2);
        et3 = (EditText) view.findViewById(R.id.et3);
        et4 = (EditText) view.findViewById(R.id.et4);
        et5 = (EditText) view.findViewById(R.id.et5);
        et6 = (EditText) view.findViewById(R.id.et6);
        et7 = (EditText) view.findViewById(R.id.et7);
        et8 = (EditText) view.findViewById(R.id.et8);

        spinnerList = new ArrayList<String>();
        for (int i =1;i<30;i++){
            spinnerList.add("2016年11月"+ i + "日");
        }
        spinner_adapter = new ArrayAdapter<String>(Pinggu_qingkuang.this,android.R.layout.simple_spinner_item,spinnerList);
        sp.setAdapter(spinner_adapter);
    }
    private void initPag2(View view){
        et21 = (EditText) view.findViewById(R.id.et1);
        et22 = (EditText) view.findViewById(R.id.et2);
        et23 = (EditText) view.findViewById(R.id.et3);
        et24 = (EditText) view.findViewById(R.id.et4);
        et25 = (EditText) view.findViewById(R.id.et5);
        et26 = (EditText) view.findViewById(R.id.et6);
        et27 = (EditText) view.findViewById(R.id.et7);
        et28 = (EditText) view.findViewById(R.id.et8);
        et29 = (EditText) view.findViewById(R.id.et9);
        et210 = (EditText) view.findViewById(R.id.et10);
        et211 = (EditText) view.findViewById(R.id.et11);
        et212 = (EditText) view.findViewById(R.id.et12);
        et213 = (EditText) view.findViewById(R.id.et13);
        et214 = (EditText) view.findViewById(R.id.et14);
        et215 = (EditText) view.findViewById(R.id.et15);
        et216 = (EditText) view.findViewById(R.id.et16);
        et217 = (EditText) view.findViewById(R.id.et17);
        et218 = (EditText) view.findViewById(R.id.et18);
    }
    private void initPag3(View view){
        btn = (Button) view.findViewById(R.id.btn);
        et31 = (EditText) view.findViewById(R.id.et1);
        et32 = (EditText) view.findViewById(R.id.et2);
        et33 = (EditText) view.findViewById(R.id.et3);
        et34 = (EditText) view.findViewById(R.id.et4);
        et35 = (EditText) view.findViewById(R.id.et5);
        et36 = (EditText) view.findViewById(R.id.et6);
        et37 = (EditText) view.findViewById(R.id.et7);
        et38 = (EditText) view.findViewById(R.id.et8);
        et39 = (EditText) view.findViewById(R.id.et9);
        et310 = (EditText) view.findViewById(R.id.et10);
        et311 = (EditText) view.findViewById(R.id.et11);
        et312 = (EditText) view.findViewById(R.id.et12);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = new String[]{et1.getText().toString(),sp.getSelectedItem().toString(),
                        et2.getText().toString(),et3.getText().toString(),
                        et4.getText().toString(),et5.getText().toString(),
                        et6.getText().toString(),et7.getText().toString(),
                        et8.getText().toString(),et21.getText().toString(),
                        et22.getText().toString(),
                        et23.getText().toString(), et24.getText().toString(),
                        et25.getText().toString(), et26.getText().toString(),
                        et27.getText().toString(), et28.getText().toString(),
                        et29.getText().toString(), et210.getText().toString(),
                        et211.getText().toString(), et212.getText().toString(),
                        et213.getText().toString(), et214.getText().toString(),
                        et215.getText().toString(), et216.getText().toString(),
                        et217.getText().toString(), et218.getText().toString(),
                        et31.getText().toString(),et32.getText().toString(),
                        et33.getText().toString(),et34.getText().toString(),
                        et35.getText().toString(),et36.getText().toString(),
                        et37.getText().toString(),et38.getText().toString(),
                        et39.getText().toString(),et310.getText().toString(),
                        et311.getText().toString(),et312.getText().toString()};

                for (int i = 0;i<data.length;i++){
                    view_data = view_data+data[i];
                }
                Toast.makeText(Pinggu_qingkuang.this,view_data,Toast.LENGTH_SHORT).show();
                view_data = "";
            }
        });

    }
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    }
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
        int two = one * 2;// 页卡1 -> 页卡3 偏移量

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                    }
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            cursor.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}
