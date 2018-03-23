package com.java;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class tortoise {
    public static void main(String[] args) {
        JFrame w=new JFrame("乌龟游啊游");
        w.setSize(1720, 768);
        w.setBackground(Color.LIGHT_GRAY);
        Mypan mp=new Mypan();
        w.add(mp);

        w.addMouseListener(mp);
        w.addMouseMotionListener(mp);

        w.addKeyListener(mp);
        mp.addKeyListener(mp);

        Thread ti=new Thread(mp);
        ti.start();
        w.show();
    }
}

class Mypan extends JPanel implements Runnable,MouseListener,MouseMotionListener,KeyListener{//这里要设置监听
    int x=300;//乌龟的初始坐标
    int y=100;
    int[] m=new int[50];//气泡
    int[] n=new int[50];
    int[] q=new int[50];
    int[] a=new int[300];//海水
    int[] b=new int[300];
    int[] c=new int[10];//金鱼
    int[] d=new int[10];

    int f=0;//o就是右下，如果是1就是左下，2就是左上，3就是右上
    int ga=0;
    boolean fan=true;
    boolean mov=true;


    Mypan(){
        for(int i=0;i<300;i++){//设置海浪的随机
            a[i]=(int)(Math.random()*1720);
            b[i]=(int)(Math.random()* 768);
        }
        for(int j=0;j<50;j++){//设置气泡的随机
            m[j]=(int)(Math.random()*1720);
            n[j]=(int)(Math.random()* 768);
            q[j]=(int)(Math.random()*35+4);
        }
        for(int k=0;k<10;k++){//设置金鱼的随机
            c[k]=(int)(Math.random()*1720);
            d[k]=(int)(Math.random()* 268+450);//金鱼一般在底部运动
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.cyan);


        for(int j=0;j<50;j++){//画气泡
            g.setColor(Color.blue);
            g.fillOval(m[j], n[j], q[j], q[j]);
            g.setColor(Color.white);
            g.fillOval(m[j]+3,n[j]+3,q[j]-4,q[j]-4);
        }

        g.setColor(Color.green);
        g.fillOval(80,600,20,200);
        g.fillOval(70, 650, 200, 200);
        g.setColor(Color.cyan);
        g.fillOval(80, 670, 200, 200);
        g.setColor(Color.green);
        g.fillOval(40, 650, 50, 50);
        g.setColor(Color.cyan);
        g.fillOval(30, 670, 50, 50);

        g.setColor(Color.green);
        g.fillOval(150,500,25,300);
        g.fillOval(140, 650, 200, 300);
        g.setColor(Color.cyan);
        g.fillOval(150, 670, 200, 200);
        g.setColor(Color.green);
        g.fillOval(110, 650, 50, 50);
        g.setColor(Color.cyan);
        g.fillOval(100, 670, 50, 50);

        for(int k=0;k<10;k++){//画金鱼
            g.setColor(Color.black);
            g.fillOval(c[k], d[k], 20, 15);
            g.setColor(Color.cyan);
            g.fillOval(c[k]-10, d[k], 20, 15);
            g.setColor(Color.orange);
            g.fillOval(c[k]+15, d[k]-10, 50, 30);
            g.setColor(Color.black);
            g.fillOval(c[k]+45, d[k]-5, 5, 10);
            g.setColor(Color.red);
            g.fillOval(c[k]+63, d[k]+3, 5, 8);
        }

        if(fan==true){
            if(mov==true){
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟的头
                g.fillOval(x, y, 70, 100);
                g.setColor(Color.BLACK);
                g.fillOval(x+10, y+30, 10, 10);
                g.fillOval(x+50, y+30, 10, 10);
            }else{
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟的头
                g.fillOval(x, y, 70, 120);
                g.setColor(Color.BLACK);
                g.fillOval(x+10, y+30, 12, 12);
                g.fillOval(x+50, y+30, 12, 12);
                g.setColor(Color.red);
                g.fillOval(x+30, y, 8, 5);
            }
        }else{
            g.setColor(Color.getHSBColor(30,20,50));//乌龟的头
            g.fillOval(x, y, 70, 100);
            g.setColor(Color.black);
            g.drawOval(x+10, y+30, 20, 20);
            g.drawOval(x+40, y+30, 20, 20);
            g.setColor(Color.white);
            g.fillOval(x+10, y+30, 20, 20);
            g.fillOval(x+40, y+30, 20, 20);
            g.setColor(Color.black);
            g.fillOval(x+8, y+30, 15, 15);
            g.fillOval(x+38, y+30, 15, 15);
            g.setColor(Color.red);
            g.fillOval(x+25, y+50, 20, 10);


        }

        if(fan==true){
            if(mov==true){
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟左shang腿
                g.fillOval(x-90, y+60, 70, 70);
            }else{
                g.setColor(Color.getHSBColor(169, 40, 3));//龟左上腿
                g.fillOval(x-80, y+70, 70, 70);
            }
        }else{
            g.setColor(Color.getHSBColor(30, 20, 50));//龟左上腿
            g.fillOval(x-80, y+70, 60, 60);
        }
        if(fan==true){

            if(mov==true){
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟右上腿
                g.fillOval(x+90, y+50, 70, 70);
            }else{
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟右上腿
                g.fillOval(x+80, y+70, 70, 70);
            }
        }else{
            g.setColor(Color.getHSBColor(30, 20, 50));//乌龟右上腿
            g.fillOval(x+80, y+70, 60, 60);

        }
        if(fan==true){
            if(mov==true){
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟左下腿
                g.fillOval(x-80, y+220, 70, 70);
            }else{
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟左下腿
                g.fillOval(x-90, y+210, 70, 70);
            }
        }else{
            g.setColor(Color.getHSBColor(30, 20, 50));//乌龟左下腿
            g.fillOval(x-80, y+220, 60, 60);
        }
        if(fan==true){
            if(mov==true){
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟右下腿
                g.fillOval(x+80, y+220, 70, 70);
            }else{
                g.setColor(Color.getHSBColor(169, 40, 3));//乌龟右下腿
                g.fillOval(x+90, y+210, 70, 70);
            }
        }else{
            g.setColor(Color.getHSBColor(30, 20, 50));//乌龟右下腿
            g.fillOval(x+80, y+220, 60, 60);
        }
        //g.fillOval(arg0, arg1, arg2, arg3)
        if(fan==true){
            if(mov==true){
                g.setColor(Color.getHSBColor(169, 40, 3));//龟尾巴
                g.fillOval(x, y+290, 60, 80);
                g.setColor(Color.cyan);
                g.fillOval(x+20, y+300, 60, 80);
            }else{
                g.setColor(Color.getHSBColor(169, 40, 3));//龟尾巴
                g.fillOval(x, y+290, 60, 80);
                g.setColor(Color.cyan);
                g.fillOval(x-20, y+300, 60, 80);
            }
        }else{
            g.setColor(Color.getHSBColor(30, 20, 50));//龟尾巴
            g.fillOval(x, y+290, 60, 80);
            g.setColor(Color.cyan);
            g.fillOval(x-20, y+300, 60, 80);
        }
        if(fan==true){
            g.setColor(Color.GREEN);//龟盖
            g.fillOval(x-66, y+69, 200, 230);
            g.setColor(Color.black);
            g.drawOval(x-65, y+70, 200, 230);
            g.setColor(Color.black);//龟盖

            g.drawLine(x+5, y+130, x+75, y+130);
            g.drawLine(x+5, y+130, x-30, y+200);
            g.drawLine(x-30, y+200, x+5, y+270);
            g.drawLine(x+5, y+270, x+75, y+270);
            g.drawLine(x+75, y+270, x+100, y+200);
            g.drawLine(x+100, y+200, x+75, y+130);

            g.drawLine(x+5, y+130, x-5, y+80);
            g.drawLine(x+75, y+130,x+100,y+95);
            g.drawLine(x-30, y+200, x-64, y+200);
            g.drawLine( x+5, y+270,x-5,y+290);
            g.drawLine(x+75, y+270, x+95, y+280);
            g.drawLine(x+100, y+200, x+130, y+200);
        }else{
            g.setColor(Color.getHSBColor(169, 40, 3));//龟盖
            g.fillOval(x-66, y+69, 200, 230);
            g.setColor(Color.black);
            g.drawOval(x-65, y+70, 200, 230);
            g.setColor(Color.black);//龟盖

            g.drawLine(x+5, y+130, x+75, y+130);
            g.drawLine(x-10, y+82, x+5, y+130);
            g.drawLine( x+75, y+130, x+100, y+95);
            g.drawLine(x-67,y+200,x+135,y+200);
            g.drawLine(x+5,y+250,x+75,y+250);
            g.drawLine(x+5,y+250,x-20,y+278);
            g.drawLine(x+100,y+275,x+75,y+250);
            g.drawLine(x+40, y+70, x+40, y+300);
        }

        //g.draw


        g.setColor(Color.BLUE);//画海浪
        for(int i=0;i<300;i++){
            g.drawString("~~~~", a[i], b[i]);
        }




    }

    @Override
    public void run(){
        while(true){

            ga++;
            if(ga>20){
                ga=0;
                if(mov==true){
                    mov=false;
                }else {
                    mov=true;
                }
            }
            if(f==0){
                x++;
                y++;

            }
            if(f==1){
                x--;
                y++;
            }
            if(f==2){
                x--;
                y--;
            }
            if(f==3){
                x++;
                y--;
            }
            if(x>1200){
                if(f==0){
                    f=1;
                }else{
                    f=2;
                }
            }
            if(y>400){
                if(f==1){
                    f=2;
                }else{
                    f=3;
                }
            }
            if(x<0){
                if(f==1){
                    f=0;
                }else{
                    f=3;
                }
            }
            if(y<40){
                if(f==3){
                    f=0;
                }else{
                    f=1;
                }
            }
            for(int i=0;i<300;i++){

                a[i]--;
                if(a[i]<0){
                    a[i]=1720;
                }
            }
            for(int j=0;j<50;j++){
                n[j]--;
                if(n[j]<2){
                    n[j]=765;
                }
            }
            for(int k=0;k<10;k++){
                c[k]=c[k]+2;
                if(c[k]>1720){
                    c[k]=0;
                }
            }
            try{
                Thread.sleep(20);
            }catch(Exception e){}
            repaint();

        }

    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO 自动生成方法存根


    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO 自动生成方法存根

    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO 自动生成方法存根

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO 自动生成方法存根
        if(e.getX()>x-18&&e.getY()>y&&e.getX()<x+80&&e.getY()<y+300)
        {
            fan=false;
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO 自动生成方法存根
        fan=true;

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO 自动生成方法存根
        x = e.getX()-30 ;
        y = e.getY()-200 ;
        this.repaint() ;


    }
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO 自动生成方法存根

    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO 自动生成方法存根
        if(e.getKeyCode()==39){

        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO 自动生成方法存根


    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO 自动生成方法存根

    }
}