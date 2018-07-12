package com.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author linyimin
 * @date 2018-4-10
 */
public class CopyFile {

    public static void main(String[] args) throws Exception {
        String url1 = "D:\\a.txt";// 源文件路径
        String url2 = "D:\\b.txt";// 目标路径（复制到E盘，重命名为b.txt）
        copy(url1, url2);
    }
    private static void copy(String url1, String url2) throws Exception {
        File file2 = new File(url2);
        if(file2.exists() && file2.isFile()){
            file2.delete();
        }
        FileInputStream in = new FileInputStream(new File(url1));
        FileOutputStream out = new FileOutputStream(new File(url2));
        byte[] buff = new byte[512];
        int n = 0;
        System.out.println("复制文件：" + "\n" + "源路径：" + url1 + "\n" + "目标路径："
                + url2);
        while ((n = in.read(buff)) != -1) {
            out.write(buff, 0, n);
        }
        out.flush();
        in.close();
        out.close();
        System.out.println("复制完成");
    }


}
