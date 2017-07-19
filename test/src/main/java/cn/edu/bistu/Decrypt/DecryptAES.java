package cn.edu.bistu.Decrypt;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * Created by Decrain on 2017/3/6.
 */

public class DecryptAES {

    public static String decrypt(String password2,String content) {

        try {
            //int转String类型



            String password = "12345678"+password2;

            //确保密钥长度16位

            int q1 = password.length();

            while (q1 < 16) {

                password += "0";

                q1++;

            }

            if (q1 > 16) {

                password = password.substring(0, 16);

            }

            byte[] raw = password.getBytes("utf-8");

            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            //先用base64解密
          //  BASE64Decoder decoder = new BASE64Decoder();
            //byte[] encrypted1 = decoder.decodeBuffer(content);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(content);

            try {

                byte[] original = cipher.doFinal(encrypted1);

                String originalString = new String(original, "utf-8");

                return originalString;

            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static String decrypt1(String content) {

        try {
            //int转String类型


            String password = "1234567890123456";

            byte[] raw = password.getBytes("utf-8");

            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            //先用base64解密
            //  BASE64Decoder decoder = new BASE64Decoder();
            //byte[] encrypted1 = decoder.decodeBuffer(content);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(content);

            try {

                byte[] original = cipher.doFinal(encrypted1);

                String originalString = new String(original, "utf-8");

                return originalString;

            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


    /*public static byte[] decrypt(String content1, String password) {
        byte[] content = formats.parseHexStr2Byte(content1);
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化为解密模式的密码器
            byte[] result = cipher.doFinal(content);
            return result; // 明文

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
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

