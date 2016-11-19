package com.example.smalu.policebank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smalu.policebank.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Smalu on 2016/11/12.
 */

public class linkAdapter extends BaseAdapter {

    private Context context;                        //运行上下文
    private List<Map<String, Object>> listItems;    //商品信息集合
    private LayoutInflater mInflater;

    public linkAdapter(Context context, List<Map<String, Object>> data){
        this.context=context;
        this.mInflater=LayoutInflater.from(context);//根据上下文获取Inflater获取布局
        this.listItems=data;
    }


    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //如果缓存convertView为空，则需要创建View
        if(convertView == null)
        {
            holder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.link_listview, null);
            holder.link_num = (TextView)convertView.findViewById(R.id.link_num);
            holder.link_content = (TextView)convertView.findViewById(R.id.link_content);
            holder.link_time = (TextView)convertView.findViewById(R.id.link_time);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.link_num.setText((String)listItems.get(position).get("link_num"));
        holder.link_content.setText((String)listItems.get(position).get("link_content"));
        holder.link_time.setText((String)listItems.get(position).get("link_time"));

        return convertView;

    }

    private class ViewHolder{
        private TextView link_num;
        private TextView link_content;
        private TextView link_time;

    }
}
