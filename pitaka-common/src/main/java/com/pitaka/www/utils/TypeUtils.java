package com.pitaka.www.utils;

import java.util.ArrayList;
import java.util.List;

public class TypeUtils {

    /**
     * 将数组字符串转化为list
     * 如 :"[1, 3, 5]"转化为List<Integer>
     * @param arrayString
     * @return
     */
    public static List<Integer> arrayStingToList(String arrayString){
        String res = arrayString.replace('[',' ').replace(']',' ').replace(" ", "");
        if("".equals(res)){
            return new ArrayList<Integer>();
        }
        String[]  StringArray = res.split(",");
        List<Integer> list = new ArrayList<>();
        for(String str: StringArray) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }
}
