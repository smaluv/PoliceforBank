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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.viewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KL on 2016/11/17 0017.
 */

public class Pinggu_fenshu extends Activity {
    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView cursor;// 动画图片
    private TextView tt;//标题
    private TextView t1, t2, t3;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
    private String[] data;

    private View view1,view2,view3;
    private String view_data;
    private Button btn;
    private EditText et11,et12,et13,et14,et15,et16,et17,et18,et19,et110,et111,et112,et113,et114,et115,
            et116,et117,et118,et119,et120,et121,et122,et123,et124,et125,et126,et127,et128,et129,et130;

    private EditText et21,et22,et23,et24,et25,et26,et27,et28,et29,et210,et211,et212,et213,et214,et215,
            et216,et217,et218,et219,et220,et221,et222,et223,et224;

    private EditText et31,et32;

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

        tt.setText("安全评估计分");
        t1.setText("评估一");
        t2.setText("评估二");
        t3.setText("签字");

        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
    }
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.Viewpagerid);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();

        view1 = mInflater.inflate(R.layout.pinggu_fenshu1, null);
        view2 = mInflater.inflate(R.layout.pinggu_fenshu2, null);
        view3 = mInflater.inflate(R.layout.pinggu_fenshu3, null);

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
        et11 = (EditText) view.findViewById(R.id.et1);
        et12 = (EditText) view.findViewById(R.id.et2);
        et13 = (EditText) view.findViewById(R.id.et3);
        et14 = (EditText) view.findViewById(R.id.et4);
        et15 = (EditText) view.findViewById(R.id.et5);
        et16 = (EditText) view.findViewById(R.id.et6);
        et17 = (EditText) view.findViewById(R.id.et7);
        et18 = (EditText) view.findViewById(R.id.et8);
        et19 = (EditText) view.findViewById(R.id.et9);
        et110 = (EditText) view.findViewById(R.id.et10);
        et111 = (EditText) view.findViewById(R.id.et11);
        et112 = (EditText) view.findViewById(R.id.et12);
        et113 = (EditText) view.findViewById(R.id.et13);
        et114 = (EditText) view.findViewById(R.id.et14);
        et115 = (EditText) view.findViewById(R.id.et15);
        et116 = (EditText) view.findViewById(R.id.et16);
        et117 = (EditText) view.findViewById(R.id.et17);
        et118 = (EditText) view.findViewById(R.id.et18);
        et119 = (EditText) view.findViewById(R.id.et19);
        et120 = (EditText) view.findViewById(R.id.et20);
        et121 = (EditText) view.findViewById(R.id.et21);
        et122 = (EditText) view.findViewById(R.id.et22);
        et123 = (EditText) view.findViewById(R.id.et23);
        et124 = (EditText) view.findViewById(R.id.et24);
        et125 = (EditText) view.findViewById(R.id.et25);
        et126 = (EditText) view.findViewById(R.id.et26);
        et127 = (EditText) view.findViewById(R.id.et27);
        et128 = (EditText) view.findViewById(R.id.et28);
        et129 = (EditText) view.findViewById(R.id.et29);
        et130 = (EditText) view.findViewById(R.id.et30);

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
        et219 = (EditText) view.findViewById(R.id.et19);
        et220 = (EditText) view.findViewById(R.id.et20);
        et221 = (EditText) view.findViewById(R.id.et21);
        et222 = (EditText) view.findViewById(R.id.et22);
        et223 = (EditText) view.findViewById(R.id.et23);
        et224 = (EditText) view.findViewById(R.id.et24);
    }

    private void initPag3(View view){
        btn = (Button) view.findViewById(R.id.btn);
        et31 = (EditText) view.findViewById(R.id.et1);
        et32 = (EditText) view.findViewById(R.id.et2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = new String[]{et11.getText().toString() + "|",et12.getText().toString() + "|",et13.getText().toString() + "|",
                        et14.getText().toString() + "|",et15.getText().toString() + "|",et16.getText().toString() + "|",
                        et17.getText().toString() + "|",et18.getText().toString() + "|",et19.getText().toString() + "|",
                        et110.getText().toString() + "|",et111.getText().toString() + "|",et112.getText().toString() + "|",
                        et113.getText().toString() + "|",et114.getText().toString() + "|",et115.getText().toString() + "|",
                        et116.getText().toString() + "|",et117.getText().toString() + "|",et118.getText().toString() + "|",
                        et19.getText().toString() + "|",et120.getText().toString() + "|",et121.getText().toString() + "|",
                        et122.getText().toString() + "|",et123.getText().toString() + "|",et124.getText().toString() + "|",
                        et125.getText().toString() + "|",et126.getText().toString() + "|",et127.getText().toString() + "|",
                        et128.getText().toString() + "|",et129.getText().toString() + "|",et130.getText().toString() + "|",
                        et21.getText().toString() + "|",et22.getText().toString() + "|",
                        et23.getText().toString() + "|", et24.getText().toString() + "|",
                        et25.getText().toString() + "|", et26.getText().toString() + "|",
                        et27.getText().toString() + "|", et28.getText().toString() + "|",
                        et29.getText().toString() + "|", et210.getText().toString() + "|",
                        et211.getText().toString() + "|", et212.getText().toString() + "|",
                        et213.getText().toString() + "|", et214.getText().toString() + "|",
                        et215.getText().toString() + "|", et216.getText().toString() + "|",
                        et217.getText().toString() + "|", et218.getText().toString() + "|",
                        et219.getText().toString() + "|", et220.getText().toString() + "|",
                        et221.getText().toString() + "|", et222.getText().toString() + "|",
                        et223.getText().toString() + "|", et224.getText().toString() + "|",
                        et31.getText().toString() + "|",et32.getText().toString() + "|"};

                for (int i = 0;i<data.length;i++){
                    view_data = view_data+data[i];
                }
                Toast.makeText(Pinggu_fenshu.this,view_data,Toast.LENGTH_SHORT).show();
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
