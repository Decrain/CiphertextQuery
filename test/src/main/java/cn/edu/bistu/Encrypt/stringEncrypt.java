package cn.edu.bistu.Encrypt;

import cn.edu.bistu.Tools.RandomString;

/**
 * Created by Decrain on 2017/3/9.
 */
public class stringEncrypt {

    public static String stringEncrypt(String password,String connent){

        RandomString randomString = new RandomString();

        EncryptAES EncryptAES = new EncryptAES();

        String tem2 =connent + randomString.getRandomString(10); //添加随机字符串


        tem2 = EncryptAES.encrypt(password,tem2);

        return  tem2;
    }
}
