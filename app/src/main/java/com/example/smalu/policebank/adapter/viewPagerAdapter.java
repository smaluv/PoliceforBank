package com.example.smalu.policebank.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Smalu on 2016/11/13.
 * ViewPager 适配器
 */

public class viewPagerAdapter extends PagerAdapter {
    public List<View> mListViews ;  //界面数据源

    public viewPagerAdapter(List<View> mListViews ){
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
        return mListViews.get(position);
    }


}
