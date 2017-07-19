package cn.edu.bistu.Tools;

/**
 * Created by Decrain on 2017/3/21.
 */
public class getUnicode {

    public static String getUnicode(String source){
        String returnUniCode=null;
        String uniCodeTemp=null;
        for(int i=0;i<source.length();i++){
            uniCodeTemp = "\\u"+Integer.toHexString((int)source.charAt(i));//使用char类的charAt()的方法
            returnUniCode=returnUniCode==null?uniCodeTemp:returnUniCode+uniCodeTemp;
        }
        //System.out.print(source +" 's unicode = "+returnUniCode);
        return returnUniCode;//返回一个字符的unicode的编码值
    }

}
