package com.example.smalu.policebank.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.bean.Document;
import com.example.smalu.policebank.utils.CONST;

import java.util.List;
import java.util.Map;

import static com.example.smalu.policebank.utils.CONST.HOST;

/**
 * Created by Smalu on 2016/11/12.
 */

public class linkAdapter extends BaseAdapter {

    private Context context;                        //运行上下文
    private List<Document> listItems;    //商品信息集合
    private LayoutInflater mInflater;
    private String address;

    public linkAdapter(Context context, List<Document> data){
        this.context=context;
        this.mInflater=LayoutInflater.from(context);//根据上下文获取Inflater获取布局
        this.listItems=data;
        for (int i=0;i<data.size();i++){
            Log.d("ID", data.get(i).getId());
        }
    }


    @Override
    public int getCount() {
        return (listItems!=null)?listItems.size():0;
    }

    @Override
    public Object getItem(int position) {
        return (listItems!=null && listItems.size()>position)?listItems.get(position):null;
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
            holder.linearLayoutLink = (LinearLayout)convertView.findViewById(R.id.link_listviewid);
            holder.link_num = (TextView)convertView.findViewById(R.id.link_num);
            holder.link_content = (TextView)convertView.findViewById(R.id.link_content);
            holder.link_time = (TextView)convertView.findViewById(R.id.link_time);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.link_num.setText((String)listItems.get(position).getId());
        holder.link_content.setText((String)listItems.get(position).getTitle());
        holder.link_time.setText((String)listItems.get(position).getDate());
         address =CONST.HOST+listItems.get(position).getAddress();
        holder.linearLayoutLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(address);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });


        Log.d("TAG11",listItems.get(position).getTitle());
        Log.d("TAG11",address);
        return convertView;

    }

    private class ViewHolder{
        private TextView link_num;
        private TextView link_content;
        private TextView link_time;
        private LinearLayout linearLayoutLink;

    }
}
