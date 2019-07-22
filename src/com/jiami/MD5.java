package com.jiami;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md=MessageDigest.getInstance("MD5") ;
        String code="hello";
        byte[] bt=md.digest(code.getBytes());
        System.out.println(bt.length);
    }
}
