package com.suanfa;


/**
 * 排序相关
 * @author linyimin
 */
public class Sort {

    public static void main(String[] args) throws Exception{

        Integer[] in = {2, 8, 1, 5, 10, 9, 0};

        efferArray(in);
    }

    /**
     * 插入排序
     * */
    private static void insertArray(Integer[] in ) {
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            //与前一位比较
            for (int j = i - 1; j >= 0; j--) {
                num++;
                if ( in [j + 1] < in [j]) {
                    tem = in [j + 1]; in [j + 1] = in [j]; in [j] = tem;
                    upnum++;
                } else {
                    break;
                }
            }
        }
        System.out.println("----插入排序-----");
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n");
    }

    /**
     * 冒泡排序
     * */
    private static void efferArray(Integer[] in ) {
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            //与后一位比较
            for (int j = i; j < in .length - 1; j++) {
                num++;
                if ( in [j + 1] < in [i]) {
                    tem = in [j + 1]; in [j + 1] = in [i]; in [i] = tem;
                    upnum++;
                }
            }
        }
        System.out.println("----冒泡排序-----");
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n");
    }
}
