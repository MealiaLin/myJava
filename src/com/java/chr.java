package com.java;

public class chr {

    public static void main(String[] args) {
        // 记录分隔符
        String RECORD_SEPARATOR = new String(new char[]{13, 10});
        // 字段分隔符
        String FIELD_SEPARATOR = new String(new char[]{27});

        StringBuilder sb=new StringBuilder("I'm test string");
        sb.append(FIELD_SEPARATOR);
        sb.append("in the world!");
        sb.append(RECORD_SEPARATOR);
        sb.append("I'm test string in the world!");
        System.out.println(sb.toString());
    }
}
