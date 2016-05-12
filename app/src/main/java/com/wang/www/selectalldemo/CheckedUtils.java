package com.wang.www.selectalldemo;

import java.util.List;

/**
 * Created by wang on 2016/5/12.
 */
public class CheckedUtils {
    /**
     * 根据模型类集合 的选中属性，返回选中项的内容
     * @param stringsList
     * @param boxBeenList
     * @return 由选中项内容组成的字符串
     */
    public static String getSelectedInfo(List<String> stringsList, List<CheckBoxBean> boxBeenList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boxBeenList.size(); i++) {

            if (boxBeenList.get(i).isChecked()) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(stringsList.get(i));
            }

        }
        return sb.toString();
    }


}
