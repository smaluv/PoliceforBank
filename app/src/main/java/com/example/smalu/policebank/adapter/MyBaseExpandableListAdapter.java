package com.example.smalu.policebank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.jiancha.ChildItem;

import java.util.List;
import java.util.Map;

/**
 * Created by KL on 2016/11/13 0013.
 */

public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter implements View.OnClickListener{
    private Context mContext;
    private List<String> groupTitle;
    //子项是一个map，key是group的id，每一个group对应一个childitem的list
    private Map<Integer,List<ChildItem>> childMap;
    private ImageView groupImageview;//group上的Imageview

    public MyBaseExpandableListAdapter(Context context,List<String> groupTitle,Map<Integer,List<ChildItem>> childMap){
        this.mContext = context;
        this.groupTitle = groupTitle;
        this.childMap = childMap;
    }
    @Override
    public int getGroupCount() {
        return groupTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childMap.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupTitle.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        //我们这里返回一下每个Item的名称，以便单击时显示
//        return childMap.get(groupPosition).get(childPosition).getTitle();
        //暂时用不到
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    //取得给定分组中给定子视图的ID，该组ID必须在组中是唯一的
    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupHolder groupHolder = null;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.groupitem,null);
            groupHolder = new GroupHolder();
            groupHolder.groupImage = (ImageView) view.findViewById(R.id.imageview_groupitem);
            groupHolder.groupText = (TextView) view.findViewById(R.id.textview_groupitem);
            view.setTag(groupHolder);
        }else{
            groupHolder = (GroupHolder) view.getTag();
        }
        if (b){
            groupHolder.groupImage.setBackgroundResource(R.mipmap.arrowdown);
        }else{
            groupHolder.groupImage.setBackgroundResource(R.mipmap.arrowright);
        }
        groupHolder.groupText.setText(groupTitle.get(i));
        groupHolder.groupImage.setOnClickListener(this);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder childHolder = null;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.childitem,null);
            childHolder = new ChildHolder();
            childHolder.childText = (TextView) view.findViewById(R.id.textview_childitem);
            childHolder.childRadioGroup = (RadioGroup) view.findViewById(R.id.radiogroup_childitem);
            view.setTag(childHolder);
        }else{
            childHolder = (ChildHolder) view.getTag();
        }

        childHolder.childText.setText(childMap.get(i).get(i1).getTitle());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public void onClick(View view) {

    }
    private class GroupHolder
    {
        ImageView groupImage;
        TextView groupText;
    }
    private class ChildHolder
    {
        TextView childText;
        RadioGroup childRadioGroup;
    }
}
