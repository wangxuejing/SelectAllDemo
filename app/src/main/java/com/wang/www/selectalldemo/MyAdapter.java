package com.wang.www.selectalldemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wang on 2016/5/11.
 */
public class MyAdapter extends BaseAdapter {
    private static final String TAG = "selectalldemo";
    private List<String> list;
    private List<CheckBoxBean> boxBeanList;
    private Context context;

    public MyAdapter(List<String> list, List<CheckBoxBean> boxBeanList, Context context) {
        this.list = list;
        this.boxBeanList = boxBeanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position));
        //设置监听
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.checkedStateChange(position, isChecked);
            }
        });

        //根据集合中的 抽象模型的属性的设置checkbox的选中状态
        holder.checkBox.setChecked(boxBeanList.get(position).isChecked());

        return convertView;
    }

    class ViewHolder {
        CheckBox checkBox;
        TextView textView;

        public ViewHolder(View itemView) {
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox_item);
            textView = (TextView) itemView.findViewById(R.id.textView_item);
        }
    }
}
