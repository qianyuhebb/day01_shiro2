package com.qianfeng.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

import java.util.UUID;

/**
 * 时间：  2020/2/3
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
public class JiaMiTest {

    public static void main(String[] args) {

        String a ="123";
        String s = new Md5Hash(a).toBase64();
        String s2 = new Md5Hash(a).toString();
        System.out.println(s);
        System.out.println(s2);
        System.out.println("==========");
        String salt = UUID.randomUUID().toString();
        String salt2 = UUID.randomUUID().toString();
        String md5Hash = new Md5Hash(a, salt, 100).toBase64();

        System.out.println(md5Hash);
        String s1 = new Sha256Hash(a, salt2, 122).toBase64();
        System.out.println(s1);



    }
}
