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
 * Created by KL on 2016/11/16 0016.
 */

public class Jiancha_autoActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView cursor;// 动画图片
    private TextView tt;//标题
    private TextView t1, t2, t3;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度

    private View view1,view2,view3;
    private Spinner sp;
    private EditText et1,et2;
    private List<String> spinnerList;
    private ArrayAdapter<String> spinner_adapter;
    private Button btn1;
    private String view1_data = "";

    private Button btn;
    private RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10,rg11,rg12,rg13,rg14,rg15,
            rg16,rg17,rg18,rg19,rg20,rg21,rg22,rg23,rg24;
    private String data [] = new String[24];

    private EditText et31,et32,et33;
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

        tt.setText("银行自助服务场所安全防护");
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

        view1 = mInflater.inflate(R.layout.jiancha_auto1, null);
        view2 = mInflater.inflate(R.layout.jiancha_auto2, null);
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

    private void initPag1(View view){
        btn1 = (Button) view.findViewById(R.id.btn);
        sp = (Spinner) view.findViewById(R.id.sp);
        et1 = (EditText) view.findViewById(R.id.et1);
        et2 = (EditText) view.findViewById(R.id.et2);

        spinnerList = new ArrayList<String>();
        for (int i =1;i<30;i++){
            spinnerList.add("2016年11月"+ i + "日");
        }

        spinner_adapter = new ArrayAdapter<String>(Jiancha_autoActivity.this,android.R.layout.simple_spinner_item,spinnerList);
        sp.setAdapter(spinner_adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] data = {sp.getSelectedItem().toString()+"|",et1.getText().toString()+"|",
                        et2.getText().toString()+"|"};
                for(int i =0;i<data.length;i++){
                    view1_data = view1_data+data[i];
                }
                //将view1_data，以便后面储存传递给数据库
                Toast.makeText(Jiancha_autoActivity.this,view1_data,Toast.LENGTH_SHORT).show();
                view1_data = "";
            }
        });
    }
    private void initPag2(View view){
        btn = (Button) view.findViewById(R.id.btn);
        rg1 = (RadioGroup) view.findViewById(R.id.rg1);
        rg2 = (RadioGroup) view.findViewById(R.id.rg2);
        rg3 = (RadioGroup) view.findViewById(R.id.rg3);
        rg4 = (RadioGroup) view.findViewById(R.id.rg4);
        rg5 = (RadioGroup) view.findViewById(R.id.rg5);
        rg6 = (RadioGroup) view.findViewById(R.id.rg6);
        rg7 = (RadioGroup) view.findViewById(R.id.rg7);
        rg8 = (RadioGroup) view.findViewById(R.id.rg8);
        rg9 = (RadioGroup) view.findViewById(R.id.rg9);
        rg10 = (RadioGroup) view.findViewById(R.id.rg10);
        rg11 = (RadioGroup) view.findViewById(R.id.rg11);
        rg12 = (RadioGroup) view.findViewById(R.id.rg12);
        rg13 = (RadioGroup) view.findViewById(R.id.rg13);
        rg14 = (RadioGroup) view.findViewById(R.id.rg14);
        rg15 = (RadioGroup) view.findViewById(R.id.rg15);
        rg16 = (RadioGroup) view.findViewById(R.id.rg16);
        rg17 = (RadioGroup) view.findViewById(R.id.rg17);
        rg18 = (RadioGroup) view.findViewById(R.id.rg18);
        rg19 = (RadioGroup) view.findViewById(R.id.rg19);
        rg20 = (RadioGroup) view.findViewById(R.id.rg20);
        rg21 = (RadioGroup) view.findViewById(R.id.rg21);
        rg22 = (RadioGroup) view.findViewById(R.id.rg22);
        rg23 = (RadioGroup) view.findViewById(R.id.rg23);
        rg24 = (RadioGroup) view.findViewById(R.id.rg24);

        for (int i = 0;i<24;i++){
            data[i] = "是";
        }
        rg1.setOnCheckedChangeListener(this);
        rg2.setOnCheckedChangeListener(this);
        rg3.setOnCheckedChangeListener(this);
        rg4.setOnCheckedChangeListener(this);
        rg5.setOnCheckedChangeListener(this);
        rg6.setOnCheckedChangeListener(this);
        rg7.setOnCheckedChangeListener(this);
        rg8.setOnCheckedChangeListener(this);
        rg9.setOnCheckedChangeListener(this);
        rg10.setOnCheckedChangeListener(this);
        rg11.setOnCheckedChangeListener(this);
        rg12.setOnCheckedChangeListener(this);
        rg13.setOnCheckedChangeListener(this);
        rg14.setOnCheckedChangeListener(this);
        rg15.setOnCheckedChangeListener(this);
        rg16.setOnCheckedChangeListener(this);
        rg17.setOnCheckedChangeListener(this);
        rg18.setOnCheckedChangeListener(this);
        rg19.setOnCheckedChangeListener(this);
        rg20.setOnCheckedChangeListener(this);
        rg21.setOnCheckedChangeListener(this);
        rg22.setOnCheckedChangeListener(this);
        rg23.setOnCheckedChangeListener(this);
        rg24.setOnCheckedChangeListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0;i<data.length;i++){
                    view2_data += data[i];
                }
                Toast.makeText(Jiancha_autoActivity.this,view2_data,Toast.LENGTH_SHORT).show();
                view2_data = "";
            }
        });
    }
    private void initPag3(View view){
        View viewx = view;
        btn31 = (Button) viewx.findViewById(R.id.btn);
        et31 = (EditText) viewx.findViewById(R.id.et1);
        et32 = (EditText) viewx.findViewById(R.id.et2);
        et33 = (EditText) viewx.findViewById(R.id.et3);
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] data = {et31.getText().toString() + "|",et32.getText().toString() + "|",et33.getText().toString() + "|"};
                for(int i =0;i<3;i++){
                    view1_data = view1_data+data[i];
                }
                Toast.makeText(Jiancha_autoActivity.this,view1_data,Toast.LENGTH_SHORT).show();
                view1_data = "";
            }
        });

        et31.getText().toString();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb11:
                data[0] = "是";
                break;
            case R.id.rb12:
                data[0] = "否";
                break;
            case R.id.rb21:
                data[1] = "是";
                break;
            case R.id.rb22:
                data[1] = "否";
                break;
            case R.id.rb31:
                data[2] = "是";
                break;
            case R.id.rb32:
                data[2] = "否";
                break;
            case R.id.rb41:
                data[3] = "是";
                break;
            case R.id.rb42:
                data[3] = "否";
                break;
            case R.id.rb51:
                data[4] = "是";
                break;
            case R.id.rb52:
                data[4] = "否";
                break;
            case R.id.rb61:
                data[5] = "是";
                break;
            case R.id.rb62:
                data[5] = "否";
                break;
            case R.id.rb71:
                data[6] = "是";
                break;
            case R.id.rb72:
                data[6] = "否";
                break;
            case R.id.rb81:
                data[7] = "是";
                break;
            case R.id.rb82:
                data[7] = "否";
                break;
            case R.id.rb91:
                data[8] = "是";
                break;
            case R.id.rb92:
                data[8] = "否";
                break;
            case R.id.rb101:
                data[9] = "是";
                break;
            case R.id.rb102:
                data[9] = "否";
                break;
            case R.id.rb111:
                data[10] = "是";
                break;
            case R.id.rb112:
                data[10] = "否";
                break;
            case R.id.rb121:
                data[11] = "是";
                break;
            case R.id.rb122:
                data[11] = "否";
                break;
            case R.id.rb131:
                data[12] = "是";
                break;
            case R.id.rb132:
                data[12] = "否";
                break;
            case R.id.rb141:
                data[13] = "是";
                break;
            case R.id.rb142:
                data[13] = "否";
                break;
            case R.id.rb151:
                data[14] = "是";
                break;
            case R.id.rb152:
                data[14] = "否";
                break;
            case R.id.rb161:
                data[15] = "是";
                break;
            case R.id.rb162:
                data[15] = "否";
                break;
            case R.id.rb171:
                data[16] = "是";
                break;
            case R.id.rb172:
                data[16] = "否";
                break;
            case R.id.rb181:
                data[17] = "是";
                break;
            case R.id.rb182:
                data[17] = "否";
                break;
            case R.id.rb191:
                data[18] = "是";
                break;
            case R.id.rb192:
                data[18] = "否";
                break;
            case R.id.rb201:
                data[19] = "是";
                break;
            case R.id.rb202:
                data[19] = "否";
                break;
            case R.id.rb211:
                data[20] = "是";
                break;
            case R.id.rb212:
                data[20] = "否";
                break;
            case R.id.rb221:
                data[21] = "是";
                break;
            case R.id.rb222:
                data[21] = "否";
                break;
            case R.id.rb231:
                data[22] = "是";
                break;
            case R.id.rb232:
                data[22] = "否";
                break;
            case R.id.rb241:
                data[23] = "是";
                break;
            case R.id.rb242:
                data[23] = "否";
                break;
            case R.id.rb251:
                data[24] = "是";
                break;
            case R.id.rb252:
                data[24] = "否";
                break;
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
