package com.suanfa;

/**
 * 打印乘法口诀
 * @author linyimin
 */
public class Multi {
    public static void main(String[] args) throws Exception{
        printMulti();
    }

    /**乘法口诀*/
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
}
