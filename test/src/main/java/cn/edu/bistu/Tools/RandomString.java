package cn.edu.bistu.Tools;

import java.util.Random;

/**
 * Created by Decrain on 2017/3/7.
 */
public class RandomString {

//随机生成固定长度字符函数

    public static String getRandomString(int length) { //length表示生成字符串的长度

        //字符串
        String base = "abcdefghijklmnopqrstuvwxyz0123456789@#%&";

        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {

            int number = random.nextInt(base.length());

            sb.append(base.charAt(number));

        }

        return sb.toString();

    }

    public RandomString() {


    }
}
