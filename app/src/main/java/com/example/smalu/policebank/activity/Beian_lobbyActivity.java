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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.viewPagerAdapter;
import com.example.smalu.policebank.fragment.DatePickerFragment;
import com.example.smalu.policebank.interfaceclass.DataCallBack;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Smalu on 2016/11/13.
 */



public class Beian_lobbyActivity extends AppCompatActivity implements DataCallBack {

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
            beian_lobby_office,   //填报单位
            beian_lobby_bankname, //银行营业场所名称
            beian_lobby_number,//备案编号
            beian_lobby_belowoffice,//填报所属机构名称
            beian_lobby_eare,//地址
            beian_lobby_defender,//保卫责任人
            beian_lobby_defendertel,//保卫联系电话
            beian_lobby2_guitai_width,//柜台宽
            beian_lobby2_guitai_height,//柜台   高
            beian_lobby2_fanghuban_width,//防护板宽
            beian_lobby2_fanghuban_height,//防护板   高
            beian_lobby2_singer_eare,//防护板单块面积
            beian_lobby2_fengdinggaodu,//防护板封顶高度
            beian_lobby2_danwei_height,//防护板防护板单位长度及空隙
            beian_lobby2_shouyincao_long,//收银槽长度
            beian_lobby2_shouyincao_width,//收银槽宽度
            beian_lobby2_shouyincao_height,//收银槽高度
            beian_lobby3_video_savetime;  //录像保留时间
    private RadioGroup beian_lobby_isnew,//工程属性
            beian_lobby_isxiaofang,//消防是否达标
            beian_lobby2_1,
            beian_lobby2_2,
            beian_lobby2_3,
            beian_lobby2_4,
            beian_lobby2_5,
            beian_lobby2_6,
            beian_lobby2_7,
            beian_lobby2_8,
            beian_lobby2_9,
            beian_lobby2_10,
            beian_lobby2_11,
            beian_lobby3_1,
            beian_lobby3_2,
            beian_lobby3_3,
            beian_lobby3_4,
            beian_lobby3_5,
            beian_lobby3_6,
            beian_lobby3_7,
            beian_lobby3_8,
            beian_lobby3_9,
            beian_lobby3_10;
    private String beian_lobby_isnew1="新建",//工程属性
            beian_lobby_isxiaofang1="达标",//消防是否达标
            beian_lobby2_01="达标",
            beian_lobby2_21="达标",
            beian_lobby2_31="达标",
            beian_lobby2_41="达标",
            beian_lobby2_51="达标",
            beian_lobby2_61="达标",
            beian_lobby2_71="达标",
            beian_lobby2_81="达标",
            beian_lobby2_91="达标",
            beian_lobby2_101="达标",
            beian_lobby2_111="达标",
            beian_lobby3_11="有",
            beian_lobby3_21="有",
            beian_lobby3_31="有",
            beian_lobby3_41="有",
            beian_lobby3_51="有",
            beian_lobby3_61="有",
            beian_lobby3_71="有",
            beian_lobby3_81="达标",
            beian_lobby3_91="达标",
            beian_lobby3_101="达标";
    private DatePicker beian_lobby_datePicker;
    private Button testbutton2;
    private String datepictime;
    private int timestage;//记录金库的建设时间判断码
    private View beian_lobby_1,beian_lobby_2,beian_lobby_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beian_lobby);
        InitImageView();
        InitTextView();
        InitViewPager();
        InitViewClick();
    }

    //初始化界面
    private void InitViewClick(){
        //界面1
        beian_lobby_office=(EditText)beian_lobby_1.findViewById(R.id.beian_lobby_office);
        beian_lobby_bankname=(EditText)beian_lobby_1.findViewById(R.id.beian_lobby_bankname);
        beian_lobby_number=(EditText)beian_lobby_1.findViewById(R.id.beian_lobby_number);
        beian_lobby_belowoffice=(EditText)beian_lobby_1.findViewById(R.id.beian_lobby_belowoffice);
        beian_lobby_eare=(EditText)beian_lobby_1.findViewById(R.id.beian_lobby_eare);
        beian_lobby_defender=(EditText)beian_lobby_1.findViewById(R.id.beian_lobby_defender);
        beian_lobby_defendertel=(EditText)beian_lobby_1.findViewById(R.id.beian_lobby_defendertel);
        beian_lobby_isnew= (RadioGroup) beian_lobby_1.findViewById(R.id.beian_lobby_isnew);
        //获取RadioGroup值
        beian_lobby_isnew.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby_isnew1= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "工程属性：" + beian_lobby_isnew1, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby_isxiaofang= (RadioGroup) beian_lobby_1.findViewById(R.id.beian_lobby_isxiaofang);
        //获取RadioGroup值
        beian_lobby_isxiaofang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby_isxiaofang1= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "消防设备合格：" + beian_lobby_isxiaofang1, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby_datePicker=(DatePicker)beian_lobby_1.findViewById(R.id.beian_lobby_datePicker);
        beian_vault_2_finishTime=(EditText)beian_lobby_1.findViewById(R.id.beian_vault_2_finishTime);
        beian_vault_2_startTime=(EditText)beian_lobby_1.findViewById(R.id.beian_vault_2_startTime);
        beian_vault_2_openTime=(EditText)beian_lobby_1.findViewById(R.id.beian_vault_2_openTime);
        InitTime();

        //获取DatePicker时间
        // 获取日历对象
        calendar = Calendar.getInstance();
        // 获取当前对应的年、月、日的信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        int monthtime=month+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
//         dataPicker初始化
        beian_lobby_datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Beian_lobbyActivity.this.year=year;
                Beian_lobbyActivity.this.month=monthOfYear+1;
                Beian_lobbyActivity.this.day=dayOfMonth;
                datepictime=year + "-" + month + "-" + day;
                Toast.makeText(Beian_lobbyActivity.this,datepictime,Toast.LENGTH_LONG).show();
            }
        });
        //页面2
        beian_lobby2_guitai_width=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_guitai_width);
        beian_lobby2_guitai_height=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_guitai_height);
        beian_lobby2_fanghuban_width=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_fanghuban_width);
        beian_lobby2_fanghuban_height=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_fanghuban_height);
        beian_lobby2_singer_eare=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_singer_eare);
        beian_lobby2_fengdinggaodu=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_fengdinggaodu);
        beian_lobby2_danwei_height=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_danwei_height);
        beian_lobby2_shouyincao_long=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_shouyincao_long);
        beian_lobby2_shouyincao_width=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_shouyincao_width);
        beian_lobby2_shouyincao_height=(EditText)beian_lobby_2.findViewById(R.id.beian_lobby2_shouyincao_height);
        beian_lobby2_1= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_1);
        //获取RadioGroup值
        beian_lobby2_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_01= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "与外界出口门和锁具：" + beian_lobby2_01, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_2= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_2);
        //获取RadioGroup值
        beian_lobby2_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_21= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "二层以下门窗：" + beian_lobby2_21, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_3= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_3);
        //获取RadioGroup值
        beian_lobby2_3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_31= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "周边 围墙 防护：" + beian_lobby2_31, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_4= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_4);
        //获取RadioGroup值
        beian_lobby2_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_41= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "柜台建筑材料：" + beian_lobby2_41, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_5= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_5);
        //获取RadioGroup值
        beian_lobby2_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_51= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "现金业务区出入防尾门：" + beian_lobby2_51, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_6= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_6);
        //获取RadioGroup值
        beian_lobby2_6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_61= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "卫生间设置：" + beian_lobby2_61, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_7= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_7);
        //获取RadioGroup值
        beian_lobby2_7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_71= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "自卫器材：" + beian_lobby2_71, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_8= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_8);
        //获取RadioGroup值
        beian_lobby2_8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_81= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "自动照明设备：" + beian_lobby2_81, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_9= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_9);
        //获取RadioGroup值
        beian_lobby2_9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_91= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "消防器材：" + beian_lobby2_91, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_10= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_10);
        //获取RadioGroup值
        beian_lobby2_10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_101= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "紧急报警装置：" + beian_lobby2_101, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby2_11= (RadioGroup) beian_lobby_2.findViewById(R.id.beian_lobby2_11);
        //获取RadioGroup值
        beian_lobby2_11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby2_111= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "110联网情况：" + beian_lobby2_111, Toast.LENGTH_SHORT).show();
            }
        });
        //页面3
        beian_lobby3_video_savetime=(EditText)beian_lobby_3.findViewById(R.id.beian_lobby3_video_savetime);
        beian_lobby3_1= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_1);
        //获取RadioGroup值
        beian_lobby3_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_11= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "场所与外界的出口及门口：" + beian_lobby3_11, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_2= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_2);
        //获取RadioGroup值
        beian_lobby3_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_21= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "现金业务：" + beian_lobby3_21, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_4= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_4);
        //获取RadioGroup值
        beian_lobby3_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_41= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "非现金业务：" + beian_lobby3_41, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_5= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_5);
        //获取RadioGroup值
        beian_lobby3_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_51= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "场所内设置的自助设备：" + beian_lobby3_51, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_6= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_6);
        //获取RadioGroup值
        beian_lobby3_6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_61= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "场内人员活动区监控：" + beian_lobby3_61, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_7= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_7);
        //获取RadioGroup值
        beian_lobby3_7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_71= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "运钞交接区：" + beian_lobby3_71, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_8= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_8);
        //获取RadioGroup值
        beian_lobby3_8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_81= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "监控回放清晰情况：" + beian_lobby3_81, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_9= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_9);
        //获取RadioGroup值
        beian_lobby3_9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_91= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "现金业务柜台连续记录声音复核装置：" + beian_lobby3_91, Toast.LENGTH_SHORT).show();
            }
        });
        beian_lobby3_10= (RadioGroup) beian_lobby_3.findViewById(R.id.beian_lobby3_10);
        //获取RadioGroup值
        beian_lobby3_10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Beian_lobbyActivity.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                beian_lobby3_101= String.valueOf(rb.getText());
                Toast.makeText(Beian_lobbyActivity.this, "入侵报警、照明等设备联动：" + beian_lobby3_101, Toast.LENGTH_SHORT).show();
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

    /**
     * 初始化ViewPager
     */
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.beianlobbyViewpagerid);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        beian_lobby_1=mInflater.inflate(R.layout.beian_lobby_1, null);
        beian_lobby_2=mInflater.inflate(R.layout.beian_lobby_2, null);
        beian_lobby_3=mInflater.inflate(R.layout.beian_lobby_3, null);
        listViews.add(beian_lobby_1);
        listViews.add(beian_lobby_2);
        listViews.add(beian_lobby_3);

        mPager.setAdapter(new viewPagerAdapter(listViews));

        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());

        testbutton2=(Button)beian_lobby_2.findViewById(R.id.testbutton2);


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
