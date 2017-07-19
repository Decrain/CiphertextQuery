package cn.edu.bistu.Decrypt;

/**
 * Created by Decrain on 2017/3/9.
 */
public class stringDecrypt {
    public static String stringDecrypt(String password,String m){

        DecryptAES decryptAES = new DecryptAES();

        String tem = decryptAES.decrypt(password,m);

        int length = tem.length();

        tem = tem.substring(0, tem.length() - 10);//去除加入的随机字符串

        return  tem;
    }
}
