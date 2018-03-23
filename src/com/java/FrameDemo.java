package com.java;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by linyimin on 2018-3-23.
 */
public class FrameDemo extends Frame {
    //方格的宽度和长度
    public static final int BLOCK_WIDTH = 15 ;
    public static final int BLOCK_HEIGHT = 15 ;
    //界面的方格的行数和列数
    public static final int ROW = 40;
    public static final int COL = 40;
    public static void main(String[] args) {
        new FrameDemo().launch();
    }

    public void launch(){

        this.setTitle("Java 窗体demo");
        this.setSize(ROW*BLOCK_HEIGHT, COL*BLOCK_WIDTH);
        this.setLocation(300, 400);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        this.setResizable(false);
        this.setVisible(true);
    }

}