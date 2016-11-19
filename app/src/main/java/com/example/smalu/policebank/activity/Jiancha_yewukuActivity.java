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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smalu.policebank.MainActivity;
import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.viewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.smalu.policebank.utils.CONTS.ServerIp;

/**
 * Created by KL on 2016/11/14 0014.
 */

public class Jiancha_yewukuActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView cursor;// 动画图片
    private TextView tt;//标题
    private TextView t1, t2, t3;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
    private ImageView tit_iv;

    private View view1,view2,view3;
    private Spinner sp2_changsuo,sp8_changsuo,sp10_changsuo,sp11_changsuo;
    private EditText et1,et3,et4,et5,et6,et7,et9;
    private List<String> spinnerList,spinnerList2;
    private ArrayAdapter<String> spinner_adapter,spinner_adapter2;
    private String view_data = "";

    private Button btn;
    private RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10,rg11,rg12,rg13,rg14,rg15,rg16,rg17,rg18,rg19,rg20,
            rg21,rg22,rg23,rg24,rg25,rg26,rg27,rg28,rg29,rg30,rg31,rg32,rg33,rg34,rg35,rg36,rg37,rg38,rg39,rg40,
            rg41,rg42,rg43,rg44,rg45,rg46,rg47,rg48,rg49,rg50,rg51;
    private String data [] = new String[66];

    private EditText et311,et312,et32,et33;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_common);
        mQueue = Volley.newRequestQueue(Jiancha_yewukuActivity.this);
        tit_iv = (ImageView) findViewById(R.id.title_id);
        tit_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jiancha_yewukuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
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

        tt.setText("银行业务库安全防范");
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

        view1 = mInflater.inflate(R.layout.jiancha_ywk1, null);
        view2 = mInflater.inflate(R.layout.jiancha_ywk2, null);
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
        sp2_changsuo = (Spinner) view.findViewById(R.id.sp2_changsuo);
        sp8_changsuo = (Spinner) view.findViewById(R.id.sp8_changsuo);
        sp10_changsuo = (Spinner) view.findViewById(R.id.sp10_changsuo);
        sp11_changsuo = (Spinner) view.findViewById(R.id.sp11_changsuo);

        et1 = (EditText) view.findViewById(R.id.et1);
        et3 = (EditText) view.findViewById(R.id.et3);
        et4 = (EditText) view.findViewById(R.id.et4);
        et5 = (EditText) view.findViewById(R.id.et5);
        et6 = (EditText) view.findViewById(R.id.et6);
        et7 = (EditText) view.findViewById(R.id.et7);
        et9 = (EditText) view.findViewById(R.id.et9);

        spinnerList = new ArrayList<String>();
        for (int i =1;i<30;i++){
            spinnerList.add("2016年11月"+ i + "日");
        }
        spinnerList2 = new ArrayList<String>();
        spinnerList2.add("一类库");
        spinnerList2.add("二类库");
        spinnerList2.add("三类库");
        spinnerList2.add("四类库");

        spinner_adapter = new ArrayAdapter<String>(Jiancha_yewukuActivity.this,android.R.layout.simple_spinner_item,spinnerList);
        spinner_adapter2 = new ArrayAdapter<String>(Jiancha_yewukuActivity.this,android.R.layout.simple_spinner_item,spinnerList2);
        sp2_changsuo.setAdapter(spinner_adapter);
        sp10_changsuo.setAdapter(spinner_adapter);
        sp11_changsuo.setAdapter(spinner_adapter);
        sp8_changsuo.setAdapter(spinner_adapter2);
    }
    private void initPag2(View view){
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
        rg25 = (RadioGroup) view.findViewById(R.id.rg25);
        rg26 = (RadioGroup) view.findViewById(R.id.rg26);
        rg27 = (RadioGroup) view.findViewById(R.id.rg27);
        rg28 = (RadioGroup) view.findViewById(R.id.rg28);
        rg29 = (RadioGroup) view.findViewById(R.id.rg29);
        rg30 = (RadioGroup) view.findViewById(R.id.rg30);
        rg31 = (RadioGroup) view.findViewById(R.id.rg31);
        rg32 = (RadioGroup) view.findViewById(R.id.rg32);
        rg33 = (RadioGroup) view.findViewById(R.id.rg33);
        rg34 = (RadioGroup) view.findViewById(R.id.rg34);
        rg35 = (RadioGroup) view.findViewById(R.id.rg35);
        rg36 = (RadioGroup) view.findViewById(R.id.rg36);
        rg37 = (RadioGroup) view.findViewById(R.id.rg37);
        rg38 = (RadioGroup) view.findViewById(R.id.rg38);
        rg39 = (RadioGroup) view.findViewById(R.id.rg39);
        rg40 = (RadioGroup) view.findViewById(R.id.rg40);
        rg41 = (RadioGroup) view.findViewById(R.id.rg41);
        rg42 = (RadioGroup) view.findViewById(R.id.rg42);
        rg43 = (RadioGroup) view.findViewById(R.id.rg43);
        rg44 = (RadioGroup) view.findViewById(R.id.rg44);
        rg45 = (RadioGroup) view.findViewById(R.id.rg45);
        rg46 = (RadioGroup) view.findViewById(R.id.rg46);
        rg47 = (RadioGroup) view.findViewById(R.id.rg47);
        rg48 = (RadioGroup) view.findViewById(R.id.rg48);
        rg49 = (RadioGroup) view.findViewById(R.id.rg49);
        rg50 = (RadioGroup) view.findViewById(R.id.rg50);
        rg51 = (RadioGroup) view.findViewById(R.id.rg51);

        //预先设置的选项导入数组中,在OnCheckedChangeListener中更改用户的点击
        for (int i = 0;i<51;i++){
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
        rg25.setOnCheckedChangeListener(this);
        rg26.setOnCheckedChangeListener(this);
        rg27.setOnCheckedChangeListener(this);
        rg28.setOnCheckedChangeListener(this);
        rg29.setOnCheckedChangeListener(this);
        rg30.setOnCheckedChangeListener(this);
        rg31.setOnCheckedChangeListener(this);
        rg32.setOnCheckedChangeListener(this);
        rg33.setOnCheckedChangeListener(this);
        rg34.setOnCheckedChangeListener(this);
        rg35.setOnCheckedChangeListener(this);
        rg36.setOnCheckedChangeListener(this);
        rg37.setOnCheckedChangeListener(this);
        rg38.setOnCheckedChangeListener(this);
        rg39.setOnCheckedChangeListener(this);
        rg40.setOnCheckedChangeListener(this);
        rg41.setOnCheckedChangeListener(this);
        rg42.setOnCheckedChangeListener(this);
        rg43.setOnCheckedChangeListener(this);
        rg44.setOnCheckedChangeListener(this);
        rg45.setOnCheckedChangeListener(this);
        rg46.setOnCheckedChangeListener(this);
        rg47.setOnCheckedChangeListener(this);
        rg48.setOnCheckedChangeListener(this);
        rg49.setOnCheckedChangeListener(this);
        rg50.setOnCheckedChangeListener(this);
        rg51.setOnCheckedChangeListener(this);
    }
    private void initPag3(View view){
        btn = (Button) view.findViewById(R.id.btn);
        et311 = (EditText) view.findViewById(R.id.et11);
        et312 = (EditText) view.findViewById(R.id.et12);
        et32 = (EditText) view.findViewById(R.id.et2);
        et33 = (EditText) view.findViewById(R.id.et3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data[0] = et1.getText() + "|";
                data[1] = sp2_changsuo.getSelectedItem().toString() + "|";
                data[2] = et3.getText() + "|";
                data[3] = et4.getText() + "|";
                data[4] = et5.getText() + "|";
                data[5] = et6.getText() + "|";
                data[6] = et7.getText() + "|";
                data[7] = sp8_changsuo.getSelectedItem().toString() + "|";
                data[8] = et9.getText() + "|";
                data[9] = sp10_changsuo.getSelectedItem().toString() + "|";
                data[10] = sp11_changsuo.getSelectedItem().toString() + "|";
                data[62] = et311.getText().toString() + "|";
                data[63] = et312.getText().toString() + "|";
                data[64] = et32.getText().toString() + "|";
                data[65] = et33.getText().toString() + "|";
                String url = ServerIp+"BankLibraryCheckInsert?belong_unit="+data[0]+"&date="+data[1]+"&address="+data[2]+"&defend_head="+data[3]+"&tel="+data[4]+"&item_unit="+data[5]+"&tech_unit="+data[6]+"&cate="+data[7]+"&area="+data[8]+"&start_date="+data[9]+"&finish_date="+data[10]+"&req1="+data[11]+"&req2="+data[12]+"&req3="+data[13]+"&req4="+data[14]+"&req5="+data[15]+"&req6="+data[16]+"&req7="+data[17]+"&req8="+data[18]+"&req9="+data[19]+"&req10="+data[20]+"&req11="+data[21]+"&req12="+data[22]+"&req13="+data[23]+"&req14="+data[24]+"&req15="+data[25]+"&req16="+data[26]+"&req17="+data[27]+"&req18="+data[28]+"&req19="+data[29]+"&req20="+data[30]+"&req21="+data[31]+"&req22="+data[32]+"&req23="+data[33]+"&req24="+data[34]+"&req25="+data[35]+"&req26="+data[36]+"&req27="+data[37]+"&req28="+data[38]+"&req29="+data[39]+"&req30="+data[40]+"&req31="+data[41]+"&req32="+data[42]+"&req33="+data[43]+"&req34="+data[44]+"&req35="+data[45]+"&req36="+data[46]+"&req37="+data[47]+"&req38="+data[48]+"&req39="+data[49]+"&req40="+data[50]+"&req41"+data[51]+"&req42="+data[52]+"&req43="+data[53]+"&req44="+data[54]+"&req45="+data[55]+"&req46="+data[56]+"&req47="+data[57]+"&req48="+data[58]+"&req49="+data[59]+"&req50="+data[60]+"&req51="+data[61]+"&hid_danger_method="+data[62]+"&method="+data[63]+"&check_unit="+data[64]+"&check_man="+data[65];
                StringRequest stringRequest = new StringRequest(url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("TAG", response);
                                Toast.makeText(Jiancha_yewukuActivity.this,"信息插入成功",Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
                mQueue.add(stringRequest);

//                for(int i =0;i<data.length;i++){
//                    view_data = view_data+data[i];
//                }
//                Toast.makeText(Jiancha_yewukuActivity.this,view_data,Toast.LENGTH_SHORT).show();
//                view_data = "";
            }
        });
    }

    /*
    先获取ListView listView = activity.getListView();
然后获取：
ListAdapter listAdapter = listView.getAdapter();
for(int l=0;l<listAdapter.getCount();l++){
  View view = listAdapter.getView(l, null, null);
     */

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.rb11:data[11] = "是";break;
            case R.id.rb12:data[11] = "否";break;
            case R.id.rb21:data[12] = "是";break;
            case R.id.rb22:data[12] = "否";break;
            case R.id.rb31:data[13] = "是";break;
            case R.id.rb32:data[13] = "否";break;
            case R.id.rb41:data[14] = "是";break;
            case R.id.rb42:data[14] = "否";break;
            case R.id.rb51:data[15] = "是";break;
            case R.id.rb52:data[15] = "否";break;
            case R.id.rb61:data[16] = "是";break;
            case R.id.rb62:data[16] = "否";break;
            case R.id.rb71:data[17] = "是";break;
            case R.id.rb72:data[17] = "否";break;
            case R.id.rb81:data[18] = "是";break;
            case R.id.rb82:data[18] = "否";break;
            case R.id.rb91:data[19] = "是";break;
            case R.id.rb92:data[19] = "否";break;
            case R.id.rb101:data[20] = "是";break;
            case R.id.rb102:data[20] = "否";break;
            case R.id.rb111:data[21] = "是";break;
            case R.id.rb112:data[21] = "否";break;
            case R.id.rb121:data[22] = "是";break;
            case R.id.rb122:data[22] = "否";break;
            case R.id.rb131:data[23] = "是";break;
            case R.id.rb132:data[23] = "否";break;
            case R.id.rb141:data[24] = "是";break;
            case R.id.rb142:data[24] = "否";break;
            case R.id.rb151:data[25] = "是";break;
            case R.id.rb152:data[25] = "否";break;
            case R.id.rb161:data[26] = "是";break;
            case R.id.rb162:data[26] = "否";break;
            case R.id.rb171:data[27] = "是";break;
            case R.id.rb172:data[27] = "否";break;
            case R.id.rb181:data[28] = "是";break;
            case R.id.rb182:data[28] = "否";break;
            case R.id.rb191:data[29] = "是";break;
            case R.id.rb192:data[29] = "否";break;
            case R.id.rb201:data[30] = "是";break;
            case R.id.rb202:data[30] = "否";break;
            case R.id.rb211:data[31] = "是";break;
            case R.id.rb212:data[31] = "否";break;
            case R.id.rb221:data[32] = "是";break;
            case R.id.rb222:data[32] = "否";break;
            case R.id.rb231:data[33] = "是";break;
            case R.id.rb232:data[33] = "否";break;
            case R.id.rb241:data[34] = "是";break;
            case R.id.rb242:data[34] = "否";break;
            case R.id.rb251:data[35] = "是";break;
            case R.id.rb252:data[35] = "否";break;
            case R.id.rb261:data[36] = "是";break;
            case R.id.rb262:data[36] = "否";break;
            case R.id.rb271:data[37] = "是";break;
            case R.id.rb272:data[37] = "否";break;
            case R.id.rb281:data[38] = "是";break;
            case R.id.rb282:data[38] = "否";break;
            case R.id.rb291:data[39] = "是";break;
            case R.id.rb292:data[39] = "否";break;
            case R.id.rb301:data[40] = "是";break;
            case R.id.rb302:data[40] = "否";break;
            case R.id.rb311:data[41] = "是";break;
            case R.id.rb312:data[41] = "否";break;
            case R.id.rb321:data[42] = "是";break;
            case R.id.rb322:data[42] = "否";break;
            case R.id.rb331:data[43] = "是";break;
            case R.id.rb332:data[43] = "否";break;
            case R.id.rb341:data[44] = "是";break;
            case R.id.rb342:data[44] = "否";break;
            case R.id.rb351:data[45] = "是";break;
            case R.id.rb352:data[45] = "否";break;
            case R.id.rb361:data[46] = "是";break;
            case R.id.rb362:data[46] = "否";break;
            case R.id.rb371:data[47] = "是";break;
            case R.id.rb372:data[47] = "否";break;
            case R.id.rb381:data[48] = "是";break;
            case R.id.rb382:data[48] = "否";break;
            case R.id.rb391:data[49] = "是";break;
            case R.id.rb392:data[49] = "否";break;
            case R.id.rb401:data[50] = "是";break;
            case R.id.rb402:data[50] = "否";break;
            case R.id.rb411:data[51] = "是";break;
            case R.id.rb412:data[51] = "否";break;
            case R.id.rb421:data[52] = "是";break;
            case R.id.rb422:data[52] = "否";break;
            case R.id.rb431:data[53] = "是";break;
            case R.id.rb432:data[53] = "否";break;
            case R.id.rb441:data[54] = "是";break;
            case R.id.rb442:data[54] = "否";break;
            case R.id.rb451:data[55] = "是";break;
            case R.id.rb452:data[55] = "否";break;
            case R.id.rb461:data[56] = "是";break;
            case R.id.rb462:data[56] = "否";break;
            case R.id.rb471:data[57] = "是";break;
            case R.id.rb472:data[57] = "否";break;
            case R.id.rb481:data[58] = "是";break;
            case R.id.rb482:data[58] = "否";break;
            case R.id.rb491:data[59] = "是";break;
            case R.id.rb492:data[59] = "否";break;
            case R.id.rb501:data[60] = "是";break;
            case R.id.rb502:data[60] = "否";break;
            case R.id.rb511:data[61] = "是";break;
            case R.id.rb512:data[61] = "否";break;
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
