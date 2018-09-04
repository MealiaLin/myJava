package com.suanfa;

/**
 * 斐波那契数列:它的第一项和第二项均为1，以后各项都为前两项之和
 * @author linyimin
 */
public class Fibonacci {
    public static void main(String[] args) throws Exception{

        getFbo(5);

        getFbo(8);
    }

    private static void getFbo(int x){

        x = x/2+1;

        int f1=1,f2=1,i=3;
        if(x==1){
            System.out.print(f1);
        }
        if(x==2){
            System.out.print(f1+"  "+f2);
        }
        if(x>=3){
            //求位置大于三的数列
            System.out.print(f1+"  "+f2);
            //求数列
            while(x>=i){
                //求两项之和
                f1=f2+f1;
                System.out.print("  "+f1);
                i++;
                f2=f2+f1;
                System.out.print("  "+f2);
            }
        }

        System.out.print("\n");
    }
}
