package com.example.smalu.policebank.activity;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.viewPagerAdapter;
import com.example.smalu.policebank.fragment.DatePickerFragment;
import com.example.smalu.policebank.interfaceclass.DataCallBack;
import com.example.smalu.policebank.utils.CONST;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Smalu on 2016/11/13.
 */



public class Beian_valutActivity extends AppCompatActivity implements DataCallBack {

    // ViewPager是google SDk中自带的一个附加包的一个类，可以用来实现屏幕间的切换。
    // android-support-v4.jar
    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView cursor;// 动画图片
    private TextView t1, t2, t3;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private EditText beian_vault_2_finishTime,beian_vault_2_startTime,beian_vault_2_openTime,
            beian_valut_office,   //填报单位
            beian_valut_name, //银行金库名称
            beian_valut_num,//备案编号
            beian_valut_belowoffice,//填报所属机构名称
            beian_valut_eare,//地址
            beian_valut2_defendpeople,//保卫责任人
            beian_valut2_defendtel,//保卫联系电话
            beian_valut3_eare;//金库面积
    private RadioGroup beian_valut2_defendproject,//工程属性
            beian_valut2_isxiaofang,//消防是否达标
            beian_valut3_1,
            beian_valut3_2,
            beian_valut3_3,
            beian_valut3_4,
            beian_valut3_5,
            beian_valut3_6,
            beian_valut3_7,
            beian_valut3_8,
            beian_valut3_9,
            beian_valut3_10,
            beian_valut3_11,
            beian_valut3_12;
    private String beian_valut2_defendproject1="新建",//工程属性
            beian_valut2_isxiaofang1="达标",//消防是否达标
            beian_valut3_110="达标",
            beian_valut3_33="达标",
            beian_valut3_44="达标",
            beian_valut3_55="达标",
            beian_valut3_66="达标",
            beian_valut3_77="达标",
            beian_valut3_88="达标",
            beian_valut3_99="达标",
            beian_valut3_101="达标",
            beian_valut3_111="达标",
            beian_valut3_122="达标";
    private DatePicker beian_valut_datepicker;
    private Button testbutton2;
    private String datepictime;
    private int timestage;//记录金库的建设时间判断码
    private View beian_valut_1,beian_valut_2,beian_valut_3;
    private String URL;
    private TextView beianequipment_submit;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beian_valut);
        beianequipment_submit = (TextView) findViewById(R.id.beianequipment_submit);
        mQueue = Volley.newRequestQueue(Beian_valutActivity.this);
        InitImageView();
        InitTextView();
        InitViewPager();
        InitViewClick();
        ImageView back =(ImageView)findViewById(R.id.bback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

    private void InitViewClick(){
        //界面1
        beian_valut_office=(EditText)beian_valut_1.findViewById(R.id.beian_valut_office);
        beian_valut_name=(EditText)beian_valut_1.findViewById(R.id.beian_valut_name);
        beian_valut_num=(EditText)beian_valut_1.findViewById(R.id.beian_valut_num);
        beian_valut_belowoffice=(EditText)beian_valut_1.findViewById(R.id.beian_valut_belowoffice);
        beian_valut_eare=(EditText)beian_valut_1.findViewById(R.id.beian_valut_eare);
        beian_valut_datepicker=(DatePicker)beian_valut_1.findViewById(R.id.beian_valut_datepicker);
        beian_vault_2_finishTime=(EditText)beian_valut_2.findViewById(R.id.beian_vault_2_finishTime);
        beian_vault_2_startTime=(EditText)beian_valut_2.findViewById(R.id.beian_vault_2_startTime);
        beian_vault_2_openTime=(EditText)beian_valut_2.findViewById(R.id.beian_vault_2_openTime);
        InitTime();

        //获取DatePicker时间
        // 获取日历对象
        calendar = Calendar.getInstance();
        // 获取当前对应的年、月、日的信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        int monthtime=month+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datepictime=year + "-" + monthtime + "-" + day;
//         dataPicker初始化
        beian_valut_datepicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Beian_valutActivity.this.year=year;
                Beian_valutActivity.this.month=monthOfYear+1;
                Beian_valutActivity.this.day=dayOfMonth;
                datepictime=year + "-" + month + "-" + day;
                Toast.makeText(Beian_valutActivity.this,datepictime,Toast.LENGTH_LONG).show();
            }
        });
        //界面2
        beian_valut2_defendpeople=(EditText)beian_valut_2.findViewById(R.id.beian_valut2_defendpeople);
        beian_valut2_defendtel=(EditText)beian_valut_2.findViewById(R.id.beian_valut2_defendtel);
        beian_valut2_defendproject = (RadioGroup) beian_valut_2.findViewById(R.id.beian_valut2_defendproject);
        //获取RadioGroup值
        beian_valut2_defendproject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut2_defendproject1= String.valueOf(rb.getText());
                Toast.makeText(Beian_valutActivity.this, "工程属性：" + beian_valut2_defendproject1, Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut2_isxiaofang = (RadioGroup) beian_valut_2.findViewById(R.id.beian_valut2_isxiaofang);
        beian_valut2_isxiaofang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut2_isxiaofang1= String.valueOf(rb.getText());
                Toast.makeText(Beian_valutActivity.this, "消防合格：" + beian_valut2_isxiaofang1, Toast.LENGTH_SHORT).show();
            }
        });
        //界面三
        beian_valut3_eare=(EditText)beian_valut_3.findViewById(R.id.beian_valut3_eare);
        beian_valut3_1 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_1);
        //获取RadioGroup值
        beian_valut3_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_110= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "库房结构：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_3 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_3);
        beian_valut3_3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_33= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "墙体结构：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_4 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_4);
        beian_valut3_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_44= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "金库门：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_5 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_5);
        beian_valut3_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_55= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "金库外隔离门：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_6 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_6);
        beian_valut3_6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_66= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "辅助安防器材：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_7 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_7);
        beian_valut3_7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_77= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "监控报警系统：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_8 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_8);
        beian_valut3_8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_88= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "报警控制系统：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_9 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_9);
        beian_valut3_9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_99= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "守卫室方位：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_10 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_10);
        beian_valut3_10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_101= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "守卫室及其他设施：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_11 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_11);
        beian_valut3_11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_111= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "武器弹药配置：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_valut3_12 = (RadioGroup) beian_valut_3.findViewById(R.id.beian_valut3_12);
        beian_valut3_12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_valutActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_valut3_122= String.valueOf(rb.getText());
//                Toast.makeText(Beian_valutActivity.this, "与公安联网情况：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        beianequipment_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beian_valut_office.getText().toString().equals("")||beian_valut_name.getText().toString().equals("")||beian_valut_num.getText().toString().equals("")||beian_valut_belowoffice.getText().toString().equals("")) {
                    Toast.makeText(Beian_valutActivity.this, "备案失败，请查证输入数据", Toast.LENGTH_SHORT).show();
                } else {
                    URL = CONST.HOST + CONST.EvaluateInsert +
                            "runit=" + beian_valut_office.getText().toString() +
                            "&vaultname=" + beian_valut_name.getText().toString() +
                            "&rnum=" + beian_valut_num.getText().toString() +
                            "&belongto=" + beian_valut_belowoffice.getText().toString() +
                            "&addr=" + beian_valut_eare.getText().toString() +
                            "&rtime=" + datepictime +
                            "&guard=" + beian_valut2_defendpeople.getText().toString()
                            + "&phone=" + beian_valut2_defendtel.getText().toString() +
                            "&ischecked=" + beian_valut2_isxiaofang1 +
                            "&startdate=" + beian_vault_2_startTime.getText().toString() +
                            "&completedate=" + beian_vault_2_finishTime.getText().toString() +
                            "&kaiyedate=" + beian_vault_2_openTime.getText().toString() +
                            "&project=" + beian_valut2_defendproject1 +//界面2
                            "&vaultsize=" + beian_valut3_eare.getText().toString() +
                            "&vaulthouse=" + beian_valut3_110 +
                            "&wall=" + beian_valut3_33 +
                            "&door=" + beian_valut3_44 +
                            "&outdoor=" + beian_valut3_55 +
                            "&pequipment=" + beian_valut3_66 +
                            "&walarm=" + beian_valut3_77 +
                            "&alarmcontrol=" + beian_valut3_88 +
                            "&otheroom=" + beian_valut3_99 +
                            "&vaultguard=" + beian_valut3_101 +
                            "&weapons=" + beian_valut3_111 +
                            "&internet=" + beian_valut3_122 +
                            "&advice=" + "无";
                    Log.d("URL", URL);
                    StringRequest stringRequest = new StringRequest(URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.d("TAG", response);
                                    Toast.makeText(Beian_valutActivity.this, "备案成功", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(Beian_valutActivity.this, BeianActivity.class);
//                                    startActivity(intent);
                                    finish();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", error.getMessage(), error);
                            Toast.makeText(Beian_valutActivity.this, "备案失败，请查证输入数据", Toast.LENGTH_SHORT).show();
                        }
                    });
                    mQueue.add(stringRequest);
                }
            }
        });

    }

    /**
     * 初始化ViewPager
     */
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.beianValutViewpagerid);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        beian_valut_1=mInflater.inflate(R.layout.beian_valut_1, null);
        beian_valut_2=mInflater.inflate(R.layout.beian_valut_2, null);
        beian_valut_3=mInflater.inflate(R.layout.beian_valut_3, null);
        listViews.add(beian_valut_1);
        listViews.add(beian_valut_2);
        listViews.add(beian_valut_3);

        mPager.setAdapter(new viewPagerAdapter(listViews));

        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());

        testbutton2=(Button)beian_valut_2.findViewById(R.id.testbutton2);



//        testbutton2.setOnClickListener(new View.OnClickListener() {
//             @Override
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
