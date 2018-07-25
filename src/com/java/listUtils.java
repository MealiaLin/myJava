package com.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * list去重
 * @author linyimin
 * @date 2018-5-23
 */
public class listUtils {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        //list.add("2");
        list.add("3");
        // 通过去重之后的HashSet长度来判断原list是否包含重复元素
        boolean isRepeat = list.size() != new HashSet<String>(list).size();
        System.out.println("list中包含重复元素：" + isRepeat);
    }
}
