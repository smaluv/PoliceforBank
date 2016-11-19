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

import static com.example.smalu.policebank.R.id.beian_equipment_Radioxiaofang;
import static com.example.smalu.policebank.R.id.beian_equipment_office;

/**
 * Created by Smalu on 2016/11/13.
 */



public class Beian_equipmentActivity extends AppCompatActivity implements DataCallBack {

    // ViewPager是google SDk中自带的一个附加包的一个类，可以用来实现屏幕间的切换。
    // android-support-v4.jar
    private int flag;
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
    private EditText beian_equipment_office,  //填报单位
            beian_equipment_name,   //自助设备、银行名称
            beian_equipment_num,    //备案编号
            beian_equipment_below_office,   //所属机构名称
            beian_equipment_eare,          //地址
            beian_equipment_defend_person,    //保卫责任人
            beian_equipment_defend_person_tel,   //责任人联系电话
            beian_vault_2_finishTime,      //完工时间
            beian_vault_2_startTime,    //开工时间
            beian_vault_2_openTime;     //开业时间
    private Button beian_equipment_information_btn;
    private DatePicker beian_equipment_datePicker;   //填报时间
    private  TextView beianequipment_submit;
    private String datepictime,beian_equipment_Radioxiaofang3;
    private int timestage;//记录金库的建设时间判断码
    private View beian_equipment_1,beian_equipment_2,beian_equipment_3;
    private RadioGroup  beian_equipment_RadioAuto, //自动类型：设备or银行
            beian_equipment_RadioProject,     //工程属性：新建   改建
            beian_equipment_Radioxiaofang,    //消防
            beian_equipment_auto1,
            beian_equipment_auto2,
            beian_equipment_auto3,
            beian_equipment_auto4,
            beian_equipment_auto5,
            beian_equipment_auto6,
            beian_equipment_bank1,
            beian_equipment_bank2,
            beian_equipment_bank3,
            beian_equipment_bank4;
    private String  beian_equipment_RadioAuto1,
            beian_equipment_RadioProject2,
//            beian_equipment_Radioxiaofang3,
            beian_equipment_auto11,
            beian_equipment_auto22,
            beian_equipment_auto33,
            beian_equipment_auto44,
            beian_equipment_auto55,
            beian_equipment_auto66,
            beian_equipment_bank11,
            beian_equipment_bank22,
            beian_equipment_bank33,
            beian_equipment_bank44;
    private String URL;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beian_equipment);
        beianequipment_submit=(TextView)findViewById(R.id.beianequipment_submit);
        mQueue = Volley.newRequestQueue(Beian_equipmentActivity.this);
        InitImageView();
        InitTextView();
        InitViewPager();
        InitTime();
        InitViewClick();
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
        beian_equipment_1=mInflater.inflate(R.layout.beian_equipment_1, null);
        beian_equipment_2=mInflater.inflate(R.layout.beian_equipment_2, null);
        beian_equipment_3=mInflater.inflate(R.layout.beian_equipment_3, null);
        listViews.add(beian_equipment_1);
        listViews.add(beian_equipment_2);
        listViews.add(beian_equipment_3);
        mPager.setAdapter(new viewPagerAdapter(listViews));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());

        beian_equipment_datePicker=(DatePicker)beian_equipment_1.findViewById(R.id.beian_equipment_datePicker);
        beian_vault_2_finishTime=(EditText)beian_equipment_1.findViewById(R.id.beian_vault_2_finishTime);
        beian_vault_2_startTime=(EditText)beian_equipment_1.findViewById(R.id.beian_vault_2_startTime);
        beian_vault_2_openTime=(EditText)beian_equipment_1.findViewById(R.id.beian_vault_2_openTime);
//        beian_equipment_office=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_office);
//        InitTime();
//        InitViewClick();


    }

    private void InitViewClick(){
        beian_equipment_office=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_office);
        beian_equipment_office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(Beian_equipmentActivity.this,beian_equipment_office.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });
        beian_equipment_name=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_name);
        beian_equipment_num=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_num);
        beian_equipment_below_office=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_below_office);
        beian_equipment_eare=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_eare);
        beian_equipment_defend_person=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_defend_person);
        beian_equipment_defend_person_tel=(EditText)beian_equipment_1.findViewById(R.id.beian_equipment_defend_person_tel);
        beian_equipment_RadioAuto=(RadioGroup)beian_equipment_1.findViewById(R.id.beian_equipment_RadioAuto);
        beian_equipment_RadioProject=(RadioGroup)beian_equipment_1.findViewById(R.id.beian_equipment_RadioProject);
        beian_equipment_Radioxiaofang=(RadioGroup)beian_equipment_1.findViewById(R.id.beian_equipment_Radioxiaofang);
        beian_equipment_information_btn=(Button)beian_equipment_1.findViewById(R.id.beian_equipment_information_btn);
        beian_equipment_datePicker=(DatePicker)beian_equipment_1.findViewById(R.id.beian_equipment_datePicker);


       //界面3
        beian_equipment_bank1= (RadioGroup) beian_equipment_3.findViewById(R.id.beian_equipment_bank1);
        beian_equipment_bank2= (RadioGroup) beian_equipment_3.findViewById(R.id.beian_equipment_bank2);
        beian_equipment_bank3= (RadioGroup) beian_equipment_3.findViewById(R.id.beian_equipment_bank3);
        beian_equipment_bank4= (RadioGroup) beian_equipment_3.findViewById(R.id.beian_equipment_bank4);

        //获取RadioGroup值
        beian_equipment_bank1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_equipment_auto11=rb.getText().toString();
                Toast.makeText(Beian_equipmentActivity.this, "出入口装填区安装控制装置：" + beian_equipment_auto11, Toast.LENGTH_SHORT).show();
            }
        });

        beian_equipment_bank2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_bank22= String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this, "现金安装入侵设备并联网：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_equipment_bank3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_bank33= String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this, "远程报警、图像、声音等信息传输：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_equipment_bank4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_equipment_bank44= String.valueOf(rb.getText());
                Toast.makeText(Beian_equipmentActivity.this, "自助银行门前及运钞车停放区域安装监控设施：" + beian_equipment_bank44, Toast.LENGTH_SHORT).show();
            }
        });
        //界面2
        beian_equipment_auto1 = (RadioGroup) beian_equipment_2.findViewById(R.id.beian_equipment_auto1);
        beian_equipment_auto2 = (RadioGroup) beian_equipment_2.findViewById(R.id.beian_equipment_auto2);
        beian_equipment_auto3 = (RadioGroup) beian_equipment_2.findViewById(R.id.beian_equipment_auto3);
        beian_equipment_auto4 = (RadioGroup) beian_equipment_2.findViewById(R.id.beian_equipment_auto4);
        beian_equipment_auto5 = (RadioGroup) beian_equipment_2.findViewById(R.id.beian_equipment_auto5);
        beian_equipment_auto6 = (RadioGroup) beian_equipment_2.findViewById(R.id.beian_equipment_auto6);
        //获取RadioGroup值
        beian_equipment_auto1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_equipment_auto11= String.valueOf(rb.getText());
                Toast.makeText(Beian_equipmentActivity.this, "安装防砸等探测装置：" + beian_equipment_auto11, Toast.LENGTH_SHORT).show();

            }
        });
        beian_equipment_auto2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_auto22=String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this, "安装数字监控装置：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_equipment_auto3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_auto33=String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this, "安装报警联网功能：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_equipment_auto4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_auto44=String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this, "远程报警传输：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_equipment_auto5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_auto55=String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this, "对操作人员面部监控：" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        beian_equipment_auto6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_auto66=String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this, "回放图片清晰：" + beian_equipment_auto66, Toast.LENGTH_SHORT).show();
            }
        });

        //获取DatePicker时间
        // 获取日历对象
        calendar = Calendar.getInstance();
        // 获取当前对应的年、月、日的信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        int monthtime=month+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datepictime=year + "-" + monthtime + "-" + day;
        Toast.makeText(Beian_equipmentActivity.this,datepictime,Toast.LENGTH_LONG).show();
//         dataPicker初始化
        beian_equipment_datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Beian_equipmentActivity.this.year=year;
                Beian_equipmentActivity.this.month=monthOfYear+1;
                Beian_equipmentActivity.this.day=dayOfMonth;
                datepictime=year + "-" + month + "-" + day;
                Toast.makeText(Beian_equipmentActivity.this,datepictime,Toast.LENGTH_LONG).show();
            }
        });
        //获取RadioGroup值
        beian_equipment_RadioAuto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                     // TODO Auto-generated method stub
                     //获取变更后的选中项的ID
                     int radioButtonId = arg0.getCheckedRadioButtonId();
                    //根据ID获取RadioButton的实例
                     RadioButton rb = (RadioButton)Beian_equipmentActivity.this.findViewById(radioButtonId);
                     beian_equipment_RadioAuto1=String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                     Toast.makeText(Beian_equipmentActivity.this,"自助类型：" + rb.getText(),Toast.LENGTH_SHORT).show();
                 }
        });
        //获取RadioGroup值
        beian_equipment_RadioProject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton)Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_RadioProject2=String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this,"项目属性：" + beian_equipment_RadioProject2,Toast.LENGTH_SHORT).show();
//                if(beian_equipment_RadioProject2=="1")
//                {flag=0;
//                    Toast.makeText(Beian_equipmentActivity.this,"新建Flag0",Toast.LENGTH_SHORT).show();
//                }else if(beian_equipment_RadioProject2=="2"){
//                    flag=1;
//                }
            }
        });
        //获取RadioGroup值
        beian_equipment_Radioxiaofang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton)Beian_equipmentActivity.this.findViewById(radioButtonId);
                beian_equipment_Radioxiaofang3= String.valueOf(rb.getText());
                //更新文本内容，以符合选中项
                Toast.makeText(Beian_equipmentActivity.this,"消防合格：" + beian_equipment_Radioxiaofang3,Toast.LENGTH_SHORT).show();
            }
        });

        beian_equipment_information_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(Beian_equipmentActivity.this,beian_equipment_office.getText().toString(),Toast.LENGTH_SHORT).show();
//                Toast.makeText(Beian_equipmentActivity.this,"填报时间"+datepictime,Toast.LENGTH_LONG).show();
//                String beian_equipment_information_data=beian_equipment_office.toString()+beian_equipment_name.toString()+beian_equipment_num.toString()+beian_equipment_below_office.toString()+beian_equipment_eare.toString()+beian_equipment_defend_person.toString()+beian_equipment_defend_person_tel.toString()+beian_vault_2_startTime.toString()+beian_vault_2_openTime.toString()+beian_vault_2_finishTime.getText().toString();
//                Toast.makeText(v.getContext(),beian_equipment_information_data,Toast.LENGTH_LONG).show();
//                Log.d("hs","shsh");
//                Intent intent=new Intent(v.getContext(),BeianActivity.class);
//                startActivity(intent);
            }
        });

        beianequipment_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                loadData();
                URL= CONST.HOST + CONST.SelfServiceInsert +
                        "runit=" +  beian_equipment_office.getText().toString()+
                        "&selfname=" + beian_equipment_name.getText().toString() +
                        "&rnum=" + beian_equipment_num.getText().toString() +
                        "&belongto=" + beian_equipment_below_office.getText().toString() +
                        "&addr=" + beian_equipment_eare.getText().toString() +
                        "&guard=" + beian_equipment_defend_person.getText().toString() +
                        "&phone=" + beian_equipment_defend_person_tel.getText().toString()
                        + "&ischecked=" + beian_equipment_Radioxiaofang3 +
                        "&project=" + beian_equipment_RadioProject2 +
                        "&busiplace=" + beian_equipment_RadioAuto1 +
                        "&startdate=" + beian_vault_2_startTime.getText().toString() +
                        "&completedate=" + beian_vault_2_finishTime.getText().toString() +
                        "&kaiyedate=" + beian_vault_2_openTime.getText().toString() +
                        "&rtime=" + datepictime //界面1
                        +"&barsize=" + beian_equipment_auto11 +
                        "&barwidth=" + beian_equipment_auto22+
                        "&barheight=" + beian_equipment_auto33+
                        "&singlearea=" + beian_equipment_auto44+
                        "&maxheight=" + beian_equipment_auto55+
                        "&wrongsize=" + beian_equipment_auto66+
                        "&doorkey=" + beian_equipment_bank11 +
                        "&window=" + beian_equipment_bank22 +
                        "&wall=" + beian_equipment_bank33 +
                        "&barmaterial=" + beian_equipment_bank44 +
                        "&advice=" + "无";
                Log.i("TAG",URL);
                Toast.makeText(Beian_equipmentActivity.this,beian_equipment_office.getText().toString(),Toast.LENGTH_SHORT).show();


                StringRequest stringRequest = new StringRequest(URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("TAG", response);
                                Toast.makeText(Beian_equipmentActivity.this,"备案成功",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Beian_equipmentActivity.this,BeianActivity.class);
                                startActivity(intent);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                        Toast.makeText(Beian_equipmentActivity.this,"备案失败，请查证输入数据",Toast.LENGTH_SHORT).show();
                    }
                });
                mQueue.add(stringRequest);
//                Toast.makeText(Beian_equipmentActivity.this,URL,Toast.LENGTH_SHORT).show();
            }
        });

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
