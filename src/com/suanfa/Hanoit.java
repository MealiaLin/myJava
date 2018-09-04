package com.suanfa;

/**
 * 汉诺塔问题
 * @author linyimin
 */
public class Hanoit {

    public static void main(String[] args) throws Exception{
        hanoit(5, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔问题
     * 将n个盘子从a底座借助b底座放到c底座上面
     * */
    private static void hanoit(int n, char a, char b, char c){
        //只有一个盘子的话，就直接移到c盘上
        if(n == 1){
            move(a, c);
        }else {
            //将一上的盘子借助三移到二上
            hanoit(n-1, a, c, b);
            move(a, c);
            //将二上的盘子借助一移到三上
            hanoit(n-1, b, a, c);
        }
    }
    private static void move(char x,char y){
        System.out.printf("%c-->%c",x,y);
        System.out.print("\n");
    }
}
