package cn.edu.bistu.Encrypt;

import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Decrain on 2017/3/6.
 */
public class EncryptAES {


    public static String encrypt(String  password2,String content)  {

        try {

            String password = "12345678" +password2;

            int q1 = password.length();



            while (q1 < 16) {

                password += "0";

                q1++;

            }

            if (q1 > 16) {

                password = password.substring(0, 16);

            }


            //String content = String.valueOf(content0);
            byte[] raw = password.getBytes("utf-8");

            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));

            return new BASE64Encoder().encodeBuffer(encrypted);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } catch (InvalidKeyException e) {
            e.printStackTrace();

        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();

        } catch (BadPaddingException e) {
            e.printStackTrace();

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static String encrypt1(String content)  {

        try {


            String password = "1234567890123456" ;

            //String content = String.valueOf(content0);
            byte[] raw = password.getBytes("utf-8");

            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));

            return new BASE64Encoder().encodeBuffer(encrypted);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } catch (InvalidKeyException e) {
            e.printStackTrace();

        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();

        } catch (BadPaddingException e) {
            e.printStackTrace();

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }


   /* public static String encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者

            kgen.init(128, new SecureRandom(password.getBytes()));// 利用用户密码作为随机数初始化出
            // 128位的key生产者
            //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行

            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥

            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回
            // null。

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥

            Cipher cipher = Cipher.getInstance("AES");// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return formats.parseByte2HexStr(result);

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }*/




}
