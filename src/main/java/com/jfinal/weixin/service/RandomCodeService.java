package com.jfinal.weixin.service;

import com.jfinal.kit.StrKit;

/**
 * Created by zengriyong on 16/11/14.
 */
public abstract class RandomCodeService {

//    public static String encode(String randomCode) {
//        return EncryptKit.md5Encrypt(EncryptKit.md5Encrypt(randomCode));
//    }
//
//    public static boolean validate(String inputRandomCode,String rightRandomCode){
//        if (StrKit.isBlank(inputRandomCode))
//            return false;
//        try{
//            inputRandomCode = encode(inputRandomCode);
//            return inputRandomCode.equals(rightRandomCode);
//        }catch(Exception e){
//            return false;
//        }
//    }
}