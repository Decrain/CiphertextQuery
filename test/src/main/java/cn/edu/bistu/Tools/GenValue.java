package cn.edu.bistu.Tools;

/**
 * Created by Decrain on 2017/3/7.
 */
public class GenValue {


    public GenValue() {



    }

    //获取特征值

    public static String GenValue(String String1) {


        String String2 = "0";

        String SubChar = "";

        int length = String1.length();

        int M = 8;
        //System.out.println("字符串长度：" + length);
        int j = 1;

        int l = 0, i = 0;

        SubString subString = new SubString();

       // System.out.println("String1: " + String1);

        if(length<2){
            String2="0";

        }

        while (j < length && length>2) {

            //分割字符串
            SubChar = subString.SubString(String1, j, 2);

            //求hash值
            l = SubChar.hashCode();

            i = l % M;
            // System.out.println("第" + (j - 1) % 8 + "字符串是：" + SubChar + "的hash值是" + l + " 特征值：" + i);
            //String3 += i ;
            // System.out.println("string30: " + String3);
            if (j - 1 == i) {

                String2 += "1";//指定位置置换为'1'


            } else {

                String2 += "0";

            }
            //System.out.println("string2: " + String2);
            //System.out.println("第" + (j-1) + " 位的特征值是：" + String2.charAt(m));
            j++;
        }
       /* int q = String2.length();
        System.out.println("string2长度: " + q);
        if(q>8){
            for (int n1=8;n1<q;n1++){
                String s2 = String.valueOf(n1);
                char t2 = s2.charAt(0);
                if(n1%8==0 && t2 == '1'){
                    //String2 = String2.replace(String2.charAt(n1%8), '1');
                }
            }
        }*/
        //System.out.println("string2: " + String2);

        /*System.out.println("string2: " + String2);
        int q = String2.length();
        System.out.println("string2长度: " + q);
        if (q>0) {
            for(int n1 =0;n1<q;n1++){
                int t3 = n1%8;
                String s2 = String.valueOf(t3);
                char t2 = s2.charAt(0);

                    if (t2 == String2.charAt(n1) && n1%8==t3) {
                        System.out.println("string2某个值: " +String2.charAt(t3) );
                        String2 = String2.replace(String2.charAt(t3), '1');
                        System.out.println("第"+n1+"个"+"string2某个值替换: " +String2.charAt(t3) );
                    }



            }
            System.out.println("string2变换之后: " + String2);

            for(int n2 =0;n2<8;n2++){
                if (String2.charAt(n2) != '1') {
                    String2 = String2.replace(String2.charAt(n2), '0');
                }
            }
            System.out.println("string2变换之后2: " + String2);

        }*/


        //设置固定的特征码 本系统设置为8位
        int q1 = String2.length();

        //System.out.println("q的长度：" + q1);

        while (q1 <= 8) {

            String2 += "0";

            q1++;

        }

        if (q1 > 8) {

            String2 = String2.substring(0, 8);

        }


        return String2;
    }
}
