//package com.example.smalu.policebank.adapter;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.ImageView;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.smalu.policebank.R;
//import com.example.smalu.policebank.activity.ChildItem;
//import com.example.smalu.policebank.activity.YewukuActivity;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by KL on 2016/11/13 0013.
// */
//
//public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter implements View.OnClickListener{
//    private Context mContext;
//    private ChildHolder childHolder = null;
//    String radiotext = "";//记录数据
//    private List<String> groupTitle;
//    //子项是一个map，key是group的id，每一个group对应一个childitem的list
//    private Map<Integer,List<ChildItem>> childMap;
//    private ImageView groupImageview;//group上的Imageview
//
//    private Handler handler = null;
//    private String texttot;
//
//    public MyBaseExpandableListAdapter(Handler handler,Context context,List<String> groupTitle,Map<Integer,List<ChildItem>> childMap){
//        this.mContext = context;
//        this.groupTitle = groupTitle;
//        this.childMap = childMap;
//        this.handler = handler;
//    }
//    @Override
//    public int getGroupCount() {
//        return groupTitle.size();
//    }
//
//    @Override
//    public int getChildrenCount(int i) {
//        return childMap.get(i).size();
//    }
//
//    @Override
//    public Object getGroup(int i) {
//        return groupTitle.get(i);
//    }
//
//    @Override
//    public Object getChild(int i, int i1) {
//        //我们这里返回一下每个Item的名称，以便单击时显示
////        return childMap.get(groupPosition).get(childPosition).getTitle();
//        //暂时用不到
//        return null;
//    }
//
//    @Override
//    public long getGroupId(int i) {
//        return i;
//    }
//
//    //取得给定分组中给定子视图的ID，该组ID必须在组中是唯一的
//    @Override
//    public long getChildId(int i, int i1) {
//        return i1;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return true;
//    }
//
//    //这里如果用if语句判断（view == null）再进行创建
//    //会导致点击了一个radiobutton后
//    //后面的一定间隔的radiobutton也被规律的选中
//    @Override
//    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
//        GroupHolder groupHolder = null;
//            view = LayoutInflater.from(mContext).inflate(R.layout.groupitem,null);
//            groupHolder = new GroupHolder();
//            groupHolder.groupImage = (ImageView) view.findViewById(R.id.imageview_groupitem);
//            groupHolder.groupText = (TextView) view.findViewById(R.id.textview_groupitem);
//            view.setTag(groupHolder);
//        if (b){
//            groupHolder.groupImage.setBackgroundResource(R.drawable.arrow_down);
//        }else{
//            groupHolder.groupImage.setBackgroundResource(R.drawable.arrow_right);
//        }
//        groupHolder.groupText.setText(groupTitle.get(i));
//        groupHolder.groupImage.setOnClickListener(this);
//        return view;
//    }
//
//    //这里如果用if语句判断（view == null）再进行创建
//    //会导致点击了一个radiobutton后
//    //后面的一定间隔的radiobutton也被规律的选中
//    @Override
//    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
//        view = LayoutInflater.from(mContext).inflate(R.layout.childitem,null);
//        childHolder = new ChildHolder();
//        childHolder.childText = (TextView) view.findViewById(R.id.textview_childitem);
//        childHolder.childRadioGroup = (RadioGroup) view.findViewById(R.id.radiogroup_childitem);
//        childHolder.childRadioButton1 = (RadioButton) view.findViewById(R.id.radio1);
//        childHolder.childRadioButton2 = (RadioButton) view.findViewById(R.id.radio2);
//
//        childHolder.childRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                String text;
//                radiotext = "";
//                if (i == childHolder.childRadioButton1.getId()){
//                    radiotext = childHolder.childRadioButton1.getText().toString();
//                }else if (i == childHolder.childRadioButton2.getId()){
//                    radiotext = childHolder.childRadioButton2.getText().toString();
//                }
//                text = radiotext + "|";
//                Log.i("123", text);
//                sendMsg(text);
//            }
//        });
//
//        view.setTag(childHolder);
//        childHolder.childText.setText(childMap.get(i).get(i1).getTitle());
//        return view;
//    }
//
//    private void sendMsg(String text){
//        Log.i("123",text+"99");
//        final Message message = new Message();
//        Bundle bundle = new Bundle();
//        bundle.putString("text",text);
//        message.setData(bundle);
//        message.what = 0;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendMessage(message);
//            }
//        }).start();
//
//    }
//    @Override
//    public boolean isChildSelectable(int i, int i1) {
//        return true;
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//    private class GroupHolder
//    {
//        ImageView groupImage;
//        TextView groupText;
//    }
//    private class ChildHolder
//    {
//        TextView childText;
//        RadioGroup childRadioGroup;
//        RadioButton childRadioButton1,childRadioButton2;
//    }
//}
