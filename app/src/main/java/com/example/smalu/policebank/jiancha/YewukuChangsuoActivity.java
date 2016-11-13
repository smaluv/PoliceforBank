package com.example.smalu.policebank.jiancha;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smalu.policebank.R;
import com.example.smalu.policebank.adapter.JianchaPagerAdapter;
import com.example.smalu.policebank.adapter.MyBaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KL on 2016/11/13 0013.
 */

public class YewukuChangsuoActivity extends Activity{

    private ExpandableListView expandableListView;
    private List<String> groupData;//group的数据源
    private Map<Integer,List<ChildItem>> childData;//child的数据源
    private MyBaseExpandableListAdapter myBaseExpandableListAdapter;

    final int CONTEXT_MENU_GROUP_DELETE = 0;
    final int CONTEXT_MENU_GROUP_RENAME = 1;
    final int CONTEXT_MENU_CHILD_EDIT = 2;
    final int CONTEXT_MENU_CHILD_DELETE = 3;

    private List<View> viewList;
    private List<String> stringList;
    private ViewPager pager_jiancha;
    private Spinner sp2_changsuo,sp8_changsuo,sp10_changsuo,sp11_changsuo;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jiancha_ywkcs);

        initListDatas();
        initListView();
        initListEvents();

        viewList = new ArrayList<>();
        stringList = new ArrayList<String>();
        stringList.add("2016年11月26日");
        stringList.add("2016年11月27日");
        stringList.add("2016年11月28日");
        stringList.add("2016年11月29日");
        stringList.add("2016年11月30日");

        adapter = new ArrayAdapter<String>(YewukuChangsuoActivity.this,android.R.layout.simple_spinner_item,stringList);

//        initView();//初始化
        pager_jiancha = (ViewPager)findViewById(R.id.pager_jiancha);

        View view1 = View.inflate(YewukuChangsuoActivity.this, R.layout.layout_ywk_xiangmu, null);
        View view2 = View.inflate(YewukuChangsuoActivity.this, R.layout.layout_ywk_xiangmu, null);
        View view3 = View.inflate(YewukuChangsuoActivity.this, R.layout.layout_ywk_xiangmu, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        JianchaPagerAdapter adapters = new JianchaPagerAdapter(viewList);

        pager_jiancha.setAdapter(adapters);
    }

//    public void initView(){//绑定ID，并绑定适配器
//        sp2_changsuo = (Spinner) findViewById(R.id.sp2_changsuo);
//        sp8_changsuo = (Spinner) findViewById(R.id.sp8_changsuo);
//        sp10_changsuo = (Spinner) findViewById(R.id.sp10_changsuo);
//        sp11_changsuo = (Spinner) findViewById(R.id.sp11_changsuo);
//        sp2_changsuo.setAdapter(adapter);
//        sp10_changsuo.setAdapter(adapter);
//        sp11_changsuo.setAdapter(adapter);
//    }

    private void initListDatas(){
        groupData = new ArrayList<>();
        groupData.add("一般要求");
        groupData.add("实体防范");
        groupData.add("技术防范");

        List<ChildItem> childItems = new ArrayList<ChildItem>();
        ChildItem childData1 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData1);
        ChildItem childData2 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData2);
        ChildItem childData3 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData3);
        ChildItem childData4 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData4);

        List<ChildItem> childItems2 = new ArrayList<ChildItem>();
        ChildItem childData5 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData5);
        ChildItem childData6 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData6);
        ChildItem childData7 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData7);
        ChildItem childData8 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData8);

        List<ChildItem> childItems3 = new ArrayList<ChildItem>();
        ChildItem childData9 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData9);
        ChildItem childData10 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData10);
        ChildItem childData11 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData11);
        ChildItem childData12 = new ChildItem("库区照明系统总闸应有");
        childItems.add(childData12);

        childData = new HashMap<Integer, List<ChildItem>>();
        childData.put(0,childItems);
        childData.put(1,childItems2);
        childData.put(2,childItems3);

        myBaseExpandableListAdapter = new MyBaseExpandableListAdapter(YewukuChangsuoActivity.this,groupData,childData);
    }

    private void initListView(){
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_listView);
        expandableListView.setGroupIndicator(null);
        expandableListView.setGroupIndicator(this.getResources().getDrawable(R.drawable.indicators));
        expandableListView.setAdapter(myBaseExpandableListAdapter);
        registerForContextMenu(expandableListView);
    }
    private void initListEvents(){
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo)menuInfo;
        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        if(type == ExpandableListView.PACKED_POSITION_TYPE_GROUP){
            menu.setHeaderTitle("Options");
            menu.add(0, CONTEXT_MENU_GROUP_DELETE, 0, "删除");
            menu.add(0, CONTEXT_MENU_GROUP_RENAME, 0, "重命名");
        }
        if(type == ExpandableListView.PACKED_POSITION_TYPE_CHILD){
            menu.setHeaderTitle("Options");
            menu.add(1, CONTEXT_MENU_CHILD_EDIT, 0, "编辑");
            menu.add(1, CONTEXT_MENU_CHILD_DELETE, 0, "删除");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case CONTEXT_MENU_GROUP_DELETE:
                Toast.makeText(this, "这是group的删除", Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_MENU_GROUP_RENAME:
                Toast.makeText(this, "这是group的重命名", Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_MENU_CHILD_EDIT:
                Toast.makeText(this, "这是child的编辑", Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_MENU_CHILD_DELETE:
                Toast.makeText(this, "这是child的删除", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
