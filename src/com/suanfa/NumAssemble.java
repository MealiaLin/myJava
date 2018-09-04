package com.suanfa;

/**
 * 打印N * 1 + N * 2 + N * 3 =num的所有组合
 * @author linyimin
 */
public class NumAssemble {

    public static void main(String[] args) throws Exception{
        printNumAssemble(10);
    }

    private static void printNumAssemble(int num) {
        int totalNum = 0;
        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < num / 2 + 1; j++) {
                for (int in = 0; in < num / 3 + 1; in ++) {
                    //
                    if (i * 1 + j * 2 + in * 3 == num) {
                        System.out.println("小马" + i + ",\t中马" + j + ",\t大马" + in );
                        totalNum++;
                    }
                }
            }
        }
        System.out.println("共有："+ totalNum);
        System.out.print("\n\n");
    }
}
