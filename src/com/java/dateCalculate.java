package com.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

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


        String a = "2018-11-16 10:30:00";
        String b = "2018-11-18 10:00:00";
        String c = getDistanceOfTwoStringDate(a,b);
        System.out.println(c);

        System.out.println(getAfterDate("2018-11-16 10:30:00", 20));

        System.out.println(compareDate("2018-11-16 10:30:00", "2018-11-18 10:00:00","yyyy-MM-dd HH:mm:ss"));
    }


    private static boolean compareDate(String time1, String time2, String format) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        //将字符串形式的时间转化为Date类型的时间
        Date a=sdf.parse(time1);
        Date b=sdf.parse(time2);
        //Date类的一个方法，如果a早于b返回true，否则返回false
        if(a.before(b)){
            return true;
        } else {
            return false;
        }
    }

    private static String getAfterDate(String datetime, int days){
        // 时间表示格式可以改变，yyyyMMdd需要写例如20160523这种形式的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
        Date date = sdf.parse(datetime, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        calendar.add(Calendar.DATE, days);
        Date date1 = calendar.getTime();
        String out = sdf.format(date1);

        return out;
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

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     * @throws ParseException
     */
    public static String getDistanceOfTwoStringDate(String before, String after) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beforeDate;
        Date afterDate;

        beforeDate = fmt.parse(before);
        afterDate = fmt.parse(after);
        long beforeTime = beforeDate.getTime();
        long afterTime = afterDate.getTime();
        long day = (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
        long hour = (afterTime - beforeTime) / (1000 * 60 * 60);
        long min = (afterTime - beforeTime) / (1000 * 60);

        return String.valueOf(hour);
    }


}
