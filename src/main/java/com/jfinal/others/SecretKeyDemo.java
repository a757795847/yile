package com.jfinal.others;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zengriyong on 16/11/18.
 */
public class SecretKeyDemo {

    public SecretKey createSecretKey(String algorithm) {
        // 声明KeyGenerator对象
        KeyGenerator keygen;
        // 声明 密钥对象
        SecretKey deskey = null;
        try {
            // 返回生成指定算法的秘密密钥的 KeyGenerator 对象
            keygen = KeyGenerator.getInstance(algorithm);
            // 生成一个密钥
            deskey = keygen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 返回密匙
        return deskey;
    }

    public static void main(String[] args) throws Exception {
        //**************************加密******************************

        //Cipher：提供加密的类，"AES" 表示加密使用的算法
        Cipher cipher = Cipher.getInstance("AES");
        //SecretKey密码生成器，用于生成一个密钥
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        System.out.println(key);
        //用密钥初始化此 Cipher，   Cipher.ENCRYPT_MODE 加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //对"aaa"执行加密的操作,返回值为加密后的结果
        byte[] result = cipher.doFinal("aaa".getBytes());
        System.out.println(new String(result));
        //**************************解密******************************
        //解密的时候，要用原来加密的密钥
        cipher.init(Cipher.DECRYPT_MODE, key);
        //解密，得到加密前的字符串
        result = cipher.doFinal(result);
        System.out.println(new String(result));
    }

}
