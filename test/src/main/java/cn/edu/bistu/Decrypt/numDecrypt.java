package cn.edu.bistu.Decrypt;

/**
 * Created by Decrain on 2017/3/9.
 */
public class numDecrypt {
    public static String numDecrypt(String m){

        DecryptAES decryptAES = new DecryptAES();

        Long t = Long.parseLong(decryptAES.decrypt1(m));

        t /= 10;

        String n = String.valueOf(t);

        return  n ;
    }
}
