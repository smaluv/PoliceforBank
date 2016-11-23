package com.example.smalu.policebank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.bean.InspectorServlet;
import com.example.smalu.policebank.utils.Theone;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public class ZhenggaiAdapter extends BaseAdapter {
    private LayoutInflater mlayoutInflater;
    private List<InspectorServlet>list;

    public ZhenggaiAdapter(Context context, List<InspectorServlet> list) {
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
            viewHodle.five= (TextView) convertView.findViewById(R.id.five);
            viewHodle.six= (TextView) convertView.findViewById(R.id.six);
            viewHodle.seven= (TextView) convertView.findViewById(R.id.seven);
            viewHodle.eight= (TextView) convertView.findViewById(R.id.eight);
            viewHodle.nine= (TextView) convertView.findViewById(R.id.nine);
            convertView.setTag(viewHodle);
        }
        else {
            viewHodle= (ViewHodle) convertView.getTag();
        }
        InspectorServlet to=list.get(position);
        viewHodle.one.setText(to.getPlace());
        viewHodle.two.setText(to.getDate());
        viewHodle.five.setText(to.getCheckman());
        viewHodle.six.setText(to.getCheck_unit());
        viewHodle.seven.setText(to.getTel());
        viewHodle.eight.setText(to.getHid_danger());
        viewHodle.nine.setText(to.getMethod());
        return convertView;
    }
    class ViewHodle{
        public TextView one,two,five,six,seven,eight,nine;
    }
}
