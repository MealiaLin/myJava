package com.suanfa;

/**
 * 韩信点兵：
 * 韩信带兵不足百人，3人一行排列多一人，7人一行排列少两人，5人一行正好，本例是计算韩信究竟点了多少兵？
 * 将7人少2人转换7人多5人
 * @author linyimin
 */
public class HanxinDianbing {
    public static void main(String[] args) throws Exception{

        getPresonNum(100);

        getPresonNum(200);
    }
    private static void getPresonNum(int num){
        //定义总人数和各种站法的剩余人数
        int a=0,b=0,c=0,preson;
        for(preson=0; preson<num; preson++){
            //每排三人剩余人数
            a = preson%3;
            //每排七人的剩余人数
            b = preson%7;
            //每排五人的剩余人数
            c = preson%5;
            //都符合条件时的人数
            if(a==1&&b==5&&c==0){
                System.out.println("韩信带的兵数是："+preson);
            }
        }
        System.out.print("\n\n");
    }
}
