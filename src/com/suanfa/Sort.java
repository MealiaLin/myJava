package com.suanfa;


/**
 * 排序相关
 * @author linyimin
 */
public class Sort {

    public static void main(String[] args) throws Exception{

        Integer[] in = {2, 8, 1, 5, 10, 9, 0};

        efferArray(in);
        printMulti();

        printNumAssemble(10);
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

    /**打印乘法口诀*/
    private static void printMulti() {
        System.out.println("----打印乘法口诀-----");
        for (int j = 1; j < 10; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(i + " * " + j + " = " + j * i + "\t");
            }
            System.out.print("\t\n");
        }
        System.out.print("\n\n");
    }

    /**打印N * 1 + N * 2 + N * 3 =num的所有组合*/
    private static void printNumAssemble(int num) {
        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < num / 2 + 1; j++) {
                for (int in = 0; in < num / 3 + 1; in ++) {
                    if (i * 1 + j * 2 + in * 3 == num) {
                        System.out.println("小马" + i + ",\t中马" + j + ",\t大马" + in );
                    }
                }
            }
        }
    }


}
