package com.wang.www.selectalldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "selectalldemo";
    private CheckBox checkBox;
    private ListView listView;
    private Button button;
    MyAdapter adapter;
    private List<String> list = new ArrayList<>();
    private List<CheckBoxBean> boxList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        initBoxBeanList();
        initView();
    }

    private void initBoxBeanList() {
        boxList.clear();
        for (int i = 0; i < list.size(); i++) {
            boxList.add(new CheckBoxBean(false));
        }
    }

    private void initList() {
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedInfo = CheckedUtils.getSelectedInfo(list, boxList);
                Log.i(TAG, "you want to delete item are ：" + selectedInfo);
                deleteCheckedItem();
            }
        });
        listView = (ListView) findViewById(R.id.listview);
        adapter = new MyAdapter(list,boxList,this);
        listView.setAdapter(adapter);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectAll(isChecked);
                adapter.notifyDataSetChanged();
            }
        });

    }

    /**
     * 删除选中项
     */
    private void deleteCheckedItem() {
        int count = list.size() - 1 ;
        //从大都小遍历，否则，从小到大遍历的话会出现错位
        for (int i = count ; i >= 0 ; i--) {
            if (boxList.get(i).isChecked()){
                list.remove(i);
            }
        }

        //如果是全部删除,全选框设为未选中
        if (list.size()==0){
            checkBox.setChecked(false);
        }
        initBoxBeanList();
        adapter.notifyDataSetChanged();
    }

    /**
     * 单项中选中状态改变时，由adpater回调
     * @param position
     * @param isChecked
     */
    public void checkedStateChange(int position, boolean isChecked) {
        boxList.get(position).setChecked(isChecked);
        adapter.notifyDataSetChanged();
    }

    /**
     * 是否全选
     * @param isChecked
     * true:全选
     * false:全不选
     */
    private void selectAll(boolean isChecked) {
        for (int i = 0; i < boxList.size(); i++) {
            boxList.get(i).setChecked(isChecked);
        }
    }

    /**
     * 点击加载数据，重新初始化
     * @param v
     */
    public void loadData(View v){
        initList();
        initBoxBeanList();
        adapter.notifyDataSetChanged();
    }
}
