package cn.edu.bistu.Encrypt;

import java.util.Random;

/**
 * Created by Decrain on 2017/3/9.
 */
public class numEncrypt {
    public static String numEncrypt(String content){

        Long tem1 = Long.parseLong(content);

        tem1 = 10 * tem1 + new Random().nextInt(9) + 1; //添加随机数
        // System.out.println("加密之前数据"+ tem1);

        //加密是类型是字符串，做一次数值转换

        String n = String.valueOf(tem1);

        //调用AES进行加密
        String encrypt = EncryptAES.encrypt1(n);

        return  encrypt;
    }
}
