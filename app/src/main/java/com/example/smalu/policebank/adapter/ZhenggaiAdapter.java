package com.example.smalu.policebank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.utils.Theone;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public class ZhenggaiAdapter extends BaseAdapter {
    private LayoutInflater mlayoutInflater;
    private List<Theone>list;

    public ZhenggaiAdapter(Context context, List<Theone> list) {
        this.mlayoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodle viewHodle=null;
        if (convertView==null){
           viewHodle=new ViewHodle();
            convertView=mlayoutInflater.inflate(R.layout.zhenggai_item,null);
            viewHodle.one= (TextView) convertView.findViewById(R.id.one);
            viewHodle.two= (TextView) convertView.findViewById(R.id.two);
            viewHodle.three= (TextView) convertView.findViewById(R.id.three);
            viewHodle.four= (TextView) convertView.findViewById(R.id.four);
            viewHodle.five= (TextView) convertView.findViewById(R.id.five);
            viewHodle.six= (TextView) convertView.findViewById(R.id.six);
            viewHodle.seven= (TextView) convertView.findViewById(R.id.seven);
            viewHodle.eight= (TextView) convertView.findViewById(R.id.eight);
            viewHodle.nine= (TextView) convertView.findViewById(R.id.nine);
            viewHodle.ten= (TextView) convertView.findViewById(R.id.ten);
            viewHodle.eleven= (TextView) convertView.findViewById(R.id.eleven);
            viewHodle.twelve= (TextView) convertView.findViewById(R.id.twelve);
            convertView.setTag(viewHodle);
        }
        else {
            viewHodle= (ViewHodle) convertView.getTag();
        }
        Theone to=list.get(position);
        viewHodle.one.setText(to.getOne());
        viewHodle.two.setText(to.getTwo());
        viewHodle.three.setText(to.getThree());
        viewHodle.five.setText(to.getFive());
        viewHodle.four.setText(to.getFour());
        viewHodle.six.setText(to.getSix());
        viewHodle.seven.setText(to.getSeven());
        viewHodle.eight.setText(to.getEight());
        viewHodle.nine.setText(to.getNine());
        viewHodle.ten.setText(to.getTen());
        viewHodle.eleven.setText(to.getEleven());
        viewHodle.twelve.setText(to.getTwelve());
        return convertView;
    }
    class ViewHodle{
        public TextView one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;
    }
}
