package com.example.smalu.policebank;


import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.smalu.policebank.fragment.HomeFragment;
import com.example.smalu.policebank.fragment.LinkFragment;
import com.example.smalu.policebank.fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView home,link,my;

    private TextView tabDeal;
    private TextView tabPoi;
    private TextView tabUser;

    private FrameLayout ly_content;

    private HomeFragment f1;
    private LinkFragment f2;
    private MyFragment f3;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置默认进入的页面


        //动态改变底部drawabletop的图片大小
        home=(TextView)findViewById(R.id.txt_deal);
        link=(TextView)findViewById(R.id.txt_poi);
        my=(TextView)findViewById(R.id.txt_user);
        Drawable drawable1 = getResources().getDrawable(R.drawable.tab_menu_deal1);
        drawable1.setBounds(0, 0, 90, 90);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        home.setCompoundDrawables(null, drawable1, null, null);//图标放在 左  上  右 下边
        Drawable drawable2 = getResources().getDrawable(R.drawable.tab_menu_deal2);
        drawable2.setBounds(0, 0, 80, 80);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        link.setCompoundDrawables(null, drawable2, null, null);//图标放在 左  上  右 下边
        Drawable drawable3 = getResources().getDrawable(R.drawable.tab_menu_deal3);
        drawable3.setBounds(0, 0, 90, 90);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        my.setCompoundDrawables(null, drawable3, null, null);//图标放在 左  上  右 下边

        bindView();
        tabDeal.performClick();//设置首页绑定的tab

    }

    //UI组件初始化与事件绑定
    private void bindView() {
        tabDeal = (TextView)this.findViewById(R.id.txt_deal);
        tabPoi = (TextView)this.findViewById(R.id.txt_poi);
        tabUser = (TextView)this.findViewById(R.id.txt_user);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabDeal.setOnClickListener(this);
        tabUser.setOnClickListener(this);
        tabPoi.setOnClickListener(this);

    }
    //重置所有文本的选中状态
    public void selected(){
        tabDeal.setSelected(false);
        tabPoi.setSelected(false);
        tabUser.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(v.getId()){
            case R.id.txt_deal:
                selected();
                tabDeal.setSelected(true);
                if(f1==null){
                    f1 = new HomeFragment(this);
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;
            case R.id.txt_poi:
                selected();
                tabPoi.setSelected(true);
                if(f3==null){
                    f2 = new LinkFragment(this);
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;
            case R.id.txt_user:
                selected();
                tabUser.setSelected(true);
                if(f3==null){
                    f3 = new MyFragment();
                    transaction.add(R.id.fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;
        }
        transaction.commit();
    }
}
