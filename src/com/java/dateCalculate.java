package com.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * 日期操作
 * @author linyimin
 * @date 2018-4-17
 */
public class dateCalculate {
    public static void main(String[] args) throws Exception {

        List<String> weekList = getWeekDays("2018-04-17", "yyyy-MM-dd", true);
        System.out.println(weekList);

        String fridayDate = getDay("2018-04-17","yyyy-MM-dd", true, 5);
        System.out.println(fridayDate);
    }


    /**
     * 获得某个日期周一到周日的日期列表
     * @param date  待查询的日期字符串
     * @param isChina 是否按国内的星期格式
     * @param dateFormat 日期格式
     * @return 周一到周日的日期字符串列表
     * @throws ParseException
     */
    private static List<String> getWeekDays(String date, String dateFormat, boolean isChina) throws ParseException {
        List<String> list  = new ArrayList<String>();
        Calendar c = Calendar.getInstance(Locale.CHINA);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        c.setTime(sdf.parse(date));
        int currentYear=c.get(Calendar.YEAR);
        int weekIndex = c.get(Calendar.WEEK_OF_YEAR);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==1&&isChina){
            c.add(Calendar.DAY_OF_MONTH,-1);
            String date_str = sdf.format(c.getTime());
            list=getWeekDays(date_str,dateFormat,isChina);
        }
        else{
            c.setWeekDate(currentYear, weekIndex, 1);
            for(int i=1;i<=7;i++){
                c.add(Calendar.DATE, 1);
                String date_str = sdf.format(c.getTime());
                list.add(date_str);
            }
        }
        return list;
    }


    /**
     * 获得某个日期所在星期的星期几
     * @param date  待查询的日期字符串
     * @param isChina 是否按国内的星期格式
     * @param dateFormat 日期格式
     * @param dayNum 获取周几，周一到周日分别填入1~7
     * @return 周一到周日的日期字符串列表
     * @throws ParseException
     */
    private static String getDay(String date, String dateFormat, boolean isChina, int dayNum) throws ParseException {
        List<String> list  = new ArrayList<String>();
        Calendar c = Calendar.getInstance(Locale.CHINA);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        c.setTime(sdf.parse(date));
        int currentYear=c.get(Calendar.YEAR);
        int weekIndex = c.get(Calendar.WEEK_OF_YEAR);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==1&&isChina){
            c.add(Calendar.DAY_OF_MONTH,-1);
            String date_str = sdf.format(c.getTime());
            list=getWeekDays(date_str,dateFormat,isChina);
        }
        else{
            c.setWeekDate(currentYear, weekIndex, 1);
            for(int i=1;i<=7;i++){
                c.add(Calendar.DATE, 1);
                String date_str = sdf.format(c.getTime());
                list.add(date_str);
            }
        }
        String targetDay = list.get(dayNum - 1);

        return targetDay;
    }


}
