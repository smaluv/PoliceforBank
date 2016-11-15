package com.example.smalu.policebank.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smalu.policebank.R;

import java.util.List;

/**
 * Created by Smalu on 2016/11/13.
 * ViewPager 适配器
 */

public class viewPagerAdapter extends PagerAdapter {
    public List<View> mListViews ;  //界面数据源
    private Context content;
    public LayoutInflater mInflater;


    public viewPagerAdapter(List<View> mListViews ){
//        this.content=context;
//        this.mInflater=LayoutInflater.from(context);
        this.mListViews=mListViews;
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(mListViews.get(position));    //清除当前viewpager
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(mListViews.get(position),0);  //添加viewpager
//        View container1=mInflater.inflate(R.layout.beian_valut_2,null);
//        Button btn =(Button)container1.findViewById(R.id.testbutton2);
//        btn.setText("TTTTTT");
        return mListViews.get(position);
    }


}
