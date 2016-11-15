package com.example.smalu.policebank.activity;


import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.viewPagerAdapter;
import com.example.smalu.policebank.fragment.DatePickerFragment;
import com.example.smalu.policebank.interfaceclass.DataCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smalu on 2016/11/13.
 */



public class Beian_equipmentActivity extends AppCompatActivity implements DataCallBack {

    // ViewPager是google SDk中自带的一个附加包的一个类，可以用来实现屏幕间的切换。
    // android-support-v4.jar
    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView cursor;// 动画图片
    private TextView t1, t2, t3;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
    private EditText beian_vault_2_finishTime,beian_vault_2_startTime,beian_vault_2_openTime;
    private Button testbutton2;
    private int timestage;//记录金库的建设时间判断码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beian_equipment);
        InitImageView();
        InitTextView();
        InitViewPager();

    }

    /**
     * 初始化头标
     */
    private void InitTextView() {
        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);

        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
    }

    /**
     * 初始化ViewPager
     */
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.beianequipmentViewpagerid);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        View beian_equipment_1=mInflater.inflate(R.layout.beian_equipment_1, null);
        View beian_equipment_2=mInflater.inflate(R.layout.beian_equipment_2, null);
        View beian_equipment_3=mInflater.inflate(R.layout.beian_equipment_3, null);
        listViews.add(beian_equipment_1);
        listViews.add(beian_equipment_2);
        listViews.add(beian_equipment_3);

        mPager.setAdapter(new viewPagerAdapter(listViews));

        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());

        testbutton2=(Button)beian_equipment_2.findViewById(R.id.testbutton2);
        beian_vault_2_finishTime=(EditText)beian_equipment_1.findViewById(R.id.beian_vault_2_finishTime);
        beian_vault_2_startTime=(EditText)beian_equipment_1.findViewById(R.id.beian_vault_2_startTime);
        beian_vault_2_openTime=(EditText)beian_equipment_1.findViewById(R.id.beian_vault_2_openTime);
        InitTime();


//        testbutton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"test",Toast.LENGTH_LONG).show();
//                Log.d("hs","shsh");
//                Intent intent=new Intent(v.getContext(),BeianActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    //选择时间
    private void InitTime() {
        beian_vault_2_finishTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化对象
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                //调用show方法弹出对话框
                // 第一个参数为FragmentManager对象
                // 第二个为调用该方法的fragment的标签
                datePickerFragment.show(getSupportFragmentManager(), "date_picker");
                timestage=2;
            }
        });
        beian_vault_2_openTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化对象
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                //调用show方法弹出对话框
                // 第一个参数为FragmentManager对象
                // 第二个为调用该方法的fragment的标签
                datePickerFragment.show(getSupportFragmentManager(), "date_picker");
                timestage=3;
            }
        });
        beian_vault_2_startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化对象
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                //调用show方法弹出对话框
                // 第一个参数为FragmentManager对象
                // 第二个为调用该方法的fragment的标签
                datePickerFragment.show(getSupportFragmentManager(), "date_picker");
                timestage=1;
            }
        });
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

    @Override
    public void getData(String data) {
        //data即为fragment调用该函数传回的日期时间
        if(timestage==1){
            beian_vault_2_startTime.setText(data);
        }else  if(timestage==2){
            beian_vault_2_finishTime.setText(data);
        }else if(timestage==3){
            beian_vault_2_openTime.setText(data);
        }
    }

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
    };

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
