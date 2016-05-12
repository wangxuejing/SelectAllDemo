package com.wang.www.selectalldemo;

/**
 * Created by wang on 2016/5/12.
 * checkbox抽象模型，用来保存每一个checkbox的选中状态
 */
public class CheckBoxBean {
    private boolean isChecked;

    public CheckBoxBean() {
    }

    public CheckBoxBean(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
