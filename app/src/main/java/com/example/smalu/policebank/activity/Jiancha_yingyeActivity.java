package com.example.smalu.policebank.activity;


import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.viewPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bug:页面一radiobutton无法改变获得的值
 * Created by KL on 2016/11/16 0016.
 */

public class Jiancha_yingyeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView cursor;// 动画图片
    private TextView tt;//标题
    private TextView t1, t2, t3;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度

    private View view1, view2, view3;
    private Spinner sp1, sp2, sp3,sp4,sp5;
    private EditText et1, et2;
    private List<String> spinnerList, spinnerList2, spinnerList3;
    private ArrayAdapter<String> spinner_adapter, spinner_adapter2, spinner_adapter3;
    private Button btn1;
    private String view1_data = "";
    private RadioGroup yyrg1, yyrg2;
    private String[] data1 = new String[9];

    private Button btn;
    private EditText et21,et22,et23,et24,et25,et26,et27,et28,et29,et210,et211,et212;
    private RadioGroup rg21,rg22,rg23,rg24,rg25,rg26,rg27,rg28,rg29,rg210,rg211,rg212,rg213,rg214,rg215,
            rg216,rg217,rg218,rg219,rg220,rg221,rg222,rg223,rg224,rg225,rg226,rg227,rg228;
    private String[] data = new String[40];

    private EditText et31, et32, et33;
    private Button btn31;
    private String view2_data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_common);
        InitImageView();
        InitTextView();
        InitViewPager();
    }

    /**
     * 初始化头标
     */
    private void InitTextView() {
        tt = (TextView) findViewById(R.id.txt_top);
        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);

        tt.setText("银行营业场所安全防范");
        t1.setText("检查场所");
        t2.setText("检查内容");
        t3.setText("隐患及解决方法");

        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
    }

    /**
     * 初始化ViewPager
     */
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.Viewpagerid);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();

        view1 = mInflater.inflate(R.layout.jiancha_yycs1, null);
        view2 = mInflater.inflate(R.layout.jiancha_yycs2, null);
        view3 = mInflater.inflate(R.layout.fanfa, null);

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

    /**
     * 初始化动画
     */
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

    private void initPag1(View view) {
        sp1 = (Spinner) view.findViewById(R.id.sp1);
        sp2 = (Spinner) view.findViewById(R.id.sp2);
        sp3 = (Spinner) view.findViewById(R.id.sp3);
        sp4 = (Spinner) view.findViewById(R.id.sp4);
        sp5 = (Spinner) view.findViewById(R.id.sp5);
        et1 = (EditText) view.findViewById(R.id.et1);
        et2 = (EditText) view.findViewById(R.id.et2);
        yyrg1 = (RadioGroup) view.findViewById(R.id.rg1);
        yyrg2 = (RadioGroup) view.findViewById(R.id.rg2);
        btn1 = (Button) view.findViewById(R.id.btn1);

        spinnerList = new ArrayList<String>();
        spinnerList.add("吉安");
        spinnerList.add("上饶");
        spinnerList.add("九江");
        spinnerList.add("景德镇");
        spinnerList.add("鹰潭");
        spinnerList.add("南昌");
        spinnerList.add("抚州");
        spinnerList.add("新余");
        spinnerList.add("萍香");
        spinnerList.add("赣州");
        spinnerList.add("宜春");

        spinnerList2 = new ArrayList<String>();
        spinnerList2.add("南京路");
        spinnerList2.add("北京路");
        spinnerList2.add("西津路");
        spinnerList2.add("东进路");

        spinnerList3 = new ArrayList<String>();
        for (int i = 1; i < 20; i++) {
            spinnerList3.add(i + "号");
        }

        spinner_adapter = new ArrayAdapter<String>(Jiancha_yingyeActivity.this, android.R.layout.simple_spinner_item, spinnerList);
        spinner_adapter2 = new ArrayAdapter<String>(Jiancha_yingyeActivity.this, android.R.layout.simple_spinner_item, spinnerList2);
        spinner_adapter3 = new ArrayAdapter<String>(Jiancha_yingyeActivity.this, android.R.layout.simple_spinner_item, spinnerList3);
        sp1.setAdapter(spinner_adapter);
        sp2.setAdapter(spinner_adapter2);
        sp3.setAdapter(spinner_adapter3);
        sp4.setAdapter(spinner_adapter3);
        sp5.setAdapter(spinner_adapter3);

        yyrg1 = (RadioGroup) view.findViewById(R.id.rg1);
        yyrg2 = (RadioGroup) view.findViewById(R.id.rg2);

        data1[1] = "有|";
        data1[2] = "有|";

        yyrg1.setOnCheckedChangeListener(this);
        yyrg2.setOnCheckedChangeListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data1[0] = et1.getText().toString()+ "|";
                data1[3] = et2.getText().toString() + "|";
                data1[4] = sp1.getSelectedItem().toString() + "|";
                data1[5] = sp2.getSelectedItem().toString() + "|";
                data1[6] = sp3.getSelectedItem().toString() + "|";
                data1[7] = sp4.getSelectedItem().toString() + "|";
                data1[8] = sp5.getSelectedItem().toString() + "|";

                for (int i = 0; i < data1.length; i++) {
                    view1_data = view1_data + data1[i];
                }
                //将view1_data，以便后面储存传递给数据库
                Toast.makeText(Jiancha_yingyeActivity.this, view1_data, Toast.LENGTH_SHORT).show();
                view1_data = "";
            }
        });
    }

    private void initPag2(View view) {
        btn = (Button) view.findViewById(R.id.btn);
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

        rg21 = (RadioGroup) view.findViewById(R.id.rg1);
        rg22 = (RadioGroup) view.findViewById(R.id.rg2);
        rg23 = (RadioGroup) view.findViewById(R.id.rg3);
        rg24 = (RadioGroup) view.findViewById(R.id.rg4);
        rg25 = (RadioGroup) view.findViewById(R.id.rg5);
        rg26 = (RadioGroup) view.findViewById(R.id.rg6);
        rg27 = (RadioGroup) view.findViewById(R.id.rg7);
        rg28 = (RadioGroup) view.findViewById(R.id.rg8);
        rg29 = (RadioGroup) view.findViewById(R.id.rg9);
        rg210 = (RadioGroup) view.findViewById(R.id.rg10);
        rg211 = (RadioGroup) view.findViewById(R.id.rg11);
        rg212 = (RadioGroup) view.findViewById(R.id.rg12);
        rg213 = (RadioGroup) view.findViewById(R.id.rg13);
        rg214 = (RadioGroup) view.findViewById(R.id.rg14);
        rg215 = (RadioGroup) view.findViewById(R.id.rg15);
        rg216 = (RadioGroup) view.findViewById(R.id.rg16);
        rg217 = (RadioGroup) view.findViewById(R.id.rg17);
        rg218 = (RadioGroup) view.findViewById(R.id.rg18);
        rg219 = (RadioGroup) view.findViewById(R.id.rg19);
        rg220 = (RadioGroup) view.findViewById(R.id.rg20);
        rg221 = (RadioGroup) view.findViewById(R.id.rg21);
        rg222 = (RadioGroup) view.findViewById(R.id.rg22);
        rg223 = (RadioGroup) view.findViewById(R.id.rg23);
        rg224 = (RadioGroup) view.findViewById(R.id.rg24);
        rg225 = (RadioGroup) view.findViewById(R.id.rg25);
        rg226 = (RadioGroup) view.findViewById(R.id.rg26);
        rg227 = (RadioGroup) view.findViewById(R.id.rg27);
        rg228 = (RadioGroup) view.findViewById(R.id.rg28);

        rg21.setOnCheckedChangeListener(this);
        rg22.setOnCheckedChangeListener(this);
        rg23.setOnCheckedChangeListener(this);
        rg24.setOnCheckedChangeListener(this);
        rg25.setOnCheckedChangeListener(this);
        rg26.setOnCheckedChangeListener(this);
        rg27.setOnCheckedChangeListener(this);
        rg28.setOnCheckedChangeListener(this);
        rg29.setOnCheckedChangeListener(this);
        rg210.setOnCheckedChangeListener(this);
        rg211.setOnCheckedChangeListener(this);
        rg212.setOnCheckedChangeListener(this);
        rg213.setOnCheckedChangeListener(this);
        rg214.setOnCheckedChangeListener(this);
        rg215.setOnCheckedChangeListener(this);
        rg216.setOnCheckedChangeListener(this);
        rg217.setOnCheckedChangeListener(this);
        rg218.setOnCheckedChangeListener(this);
        rg219.setOnCheckedChangeListener(this);
        rg220.setOnCheckedChangeListener(this);
        rg221.setOnCheckedChangeListener(this);
        rg222.setOnCheckedChangeListener(this);
        rg223.setOnCheckedChangeListener(this);
        rg224.setOnCheckedChangeListener(this);
        rg225.setOnCheckedChangeListener(this);
        rg226.setOnCheckedChangeListener(this);
        rg227.setOnCheckedChangeListener(this);
        rg228.setOnCheckedChangeListener(this);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data[6] = et21.getText().toString();
                data[7] = et22.getText().toString();
                data[8] = et23.getText().toString();
                data[10] = et24.getText().toString();
                data[11] = et25.getText().toString();
                data[13] = et26.getText().toString();
                data[15] = et27.getText().toString();
                data[16] = et28.getText().toString();
                data[17] = et29.getText().toString();
                data[23] = et210.getText().toString();
                data[24] = et211.getText().toString();
                data[25] = et212.getText().toString();
                for (int i = 0;i<data.length;i++){
                    view2_data += data[i];
                }
                Toast.makeText(Jiancha_yingyeActivity.this,view2_data,Toast.LENGTH_SHORT).show();
                view2_data = "";
            }
        });
    }

    private void initPag3(View view) {
        View viewx = view;
        btn31 = (Button) viewx.findViewById(R.id.btn);
        et31 = (EditText) viewx.findViewById(R.id.et1);
        et32 = (EditText) viewx.findViewById(R.id.et2);
        et33 = (EditText) viewx.findViewById(R.id.et3);
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] data = {et31.getText().toString() + "|", et32.getText().toString() + "|", et33.getText().toString() + "|"};
                for (int i = 0; i < 3; i++) {
                    view1_data = view1_data + data[i];
                }
                Toast.makeText(Jiancha_yingyeActivity.this, view1_data, Toast.LENGTH_SHORT).show();
                view1_data = "";
            }
        });

        et31.getText().toString();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb1:data1[1] = "有|";break;
            case R.id.rb2:data1[1] = "无|";break;
            case R.id.rb3:data1[2] = "有|";break;
            case R.id.rb4:data1[2] = "无|";break;

            case R.id.rb11:data[0] = "防弹玻璃";break;
            case R.id.rb12:data[0] = "防砸玻璃";break;
            case R.id.rb13:data[0] = "加装金属防护栏";break;
            case R.id.rb21:data[1] = "是";break;
            case R.id.rb22:data[1] = "否";break;
            case R.id.rb31:data[2] = "是";break;
            case R.id.rb32:data[2] = "否";break;
            case R.id.rb41:data[3] = "是";break;
            case R.id.rb42:data[3] = "否";break;
            case R.id.rb51:data[4] = "是";break;
            case R.id.rb52:data[4] = "否";break;
            case R.id.rb61:data[5] = "是";break;
            case R.id.rb62:data[5] = "否";break;
            case R.id.rb71:data[9] = "是";break;
            case R.id.rb72:data[9] = "否";break;
            case R.id.rb81:data[12] = "是";break;
            case R.id.rb82:data[12] = "否";break;
            case R.id.rb91:data[14] = "是";break;
            case R.id.rb92:data[14] = "否";break;
            case R.id.rb101:data[18] = "是";break;
            case R.id.rb102:data[18] = "否";break;
            case R.id.rb111:data[19] = "是";break;
            case R.id.rb112:data[19] = "否";break;
            case R.id.rb121:data[20] = "是";break;
            case R.id.rb122:data[20] = "否";break;
            case R.id.rb131:data[21] = "是";break;
            case R.id.rb132:data[21] = "否";break;
            case R.id.rb141:data[22] = "是";break;
            case R.id.rb142:data[22] = "否";break;
            case R.id.rb151:data[26] = "是";break;
            case R.id.rb152:data[26] = "否";break;
            case R.id.rb161:data[27] = "是";break;
            case R.id.rb162:data[27] = "否";break;
            case R.id.rb171:data[28] = "是";break;
            case R.id.rb172:data[28] = "否";break;
            case R.id.rb181:data[29] = "是";break;
            case R.id.rb182:data[29] = "否";break;
            case R.id.rb191:data[30] = "是";break;
            case R.id.rb192:data[30] = "否";break;
            case R.id.rb201:data[31] = "是";break;
            case R.id.rb202:data[31] = "否";break;
            case R.id.rb211:data[32] = "是";break;
            case R.id.rb212:data[32] = "否";break;
            case R.id.rb221:data[33] = "是";break;
            case R.id.rb222:data[33] = "否";break;
            case R.id.rb231:data[34] = "是";break;
            case R.id.rb232:data[34] = "否";break;
            case R.id.rb241:data[35] = "是";break;
            case R.id.rb242:data[35] = "否";break;
            case R.id.rb251:data[36] = "是";break;
            case R.id.rb252:data[36] = "否";break;
            case R.id.rb261:data[37] = "是";break;
            case R.id.rb262:data[37] = "否";break;
            case R.id.rb271:data[38] = "有";break;
            case R.id.rb272:data[38] = "无";break;
            case R.id.rb281:data[39] = "有";break;
            case R.id.rb282:data[39] = "无";break;
        }
    }
    /*
    先获取ListView listView = activity.getListView();
然后获取：
ListAdapter listAdapter = listView.getAdapter();
for(int l=0;l<listAdapter.getCount();l++){
  View view = listAdapter.getView(l, null, null);
     */

        /**
         * 头标点击监听
         */
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

        /**
         * 页卡切换监听
         */
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