package cn.edu.bistu.Tools;

/**
 * Created by Decrain on 2017/3/7.
 */


public class SubString {

    //进行分词处理

    public static String SubString(String String1,int j,int i){

        String SubChar = "";

        for(int k = i-2;k<i;k++){

            SubChar += String1.charAt(j-1);//charAt()取字符函数

            j++;

        }

        return SubChar;
    }
}
