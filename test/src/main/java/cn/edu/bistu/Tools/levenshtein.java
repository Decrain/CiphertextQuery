package cn.edu.bistu.Tools;
/**
 * Created by Decrain on 2017/3/13.
 */


//编辑距离算法 ，计算两个字符串的相似度
/*
str1或str2的长度为0返回另一个字符串的长度。
一、if(str1.length==0) return str2.length; if(str2.length==0) return str1.length;

二、初始化(n+1)*(m+1)的矩阵d，并让第一行和列的值从0开始增长。

三、扫描两字符串（n*m级的），如果：str1[i] == str2[j]，用temp记录它，为0。否则temp记为1。
    然后在矩阵d[i,j]赋于d[i-1,j]+1 、d[i,j-1]+1、d[i-1,j-1]+temp三者的最小值。
四、扫描完后，返回矩阵的最后一个值d[n][m]即是它们的距离。
五、计算相似度公式：1-它们的距离/两个字符串长度的最大值。

*/




public class levenshtein {

    public static double levenshtein(String str1, String str2) {


        // 计算两个字符串的长度。
        int len1 = str1.length();
        int len2 = str2.length();
        // 建立上面说的数组，比字符长度大一个空间


        int[][] dif = new int[len1 + 1][len2 + 1];

        // 赋初值，步骤B。
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        // 计算两个字符是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                // 取三个值中最小的
                dif[i][j] = Math.min(dif[i - 1][j] + 1,Math.min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1));

            }
        }


        // 计算相似度
        float similarity = 1 - (float) dif[len1][len2]
                / Math.max(str1.length(), str2.length());
       // System.out.println("相似度：" + similarity);

        return  similarity;
    }
}
