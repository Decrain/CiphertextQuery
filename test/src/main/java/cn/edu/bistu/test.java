package cn.edu.bistu;

import java.io.UnsupportedEncodingException;

/**
 * Created by Decrain on 2017/3/7.
 */
public class test {





    public static void main(String[] args) throws UnsupportedEncodingException {

        /*System.out.println("Ascii: "+ getUnicode.getUnicode("邓丁朋") );*/

 /*  String str1="sggg";
   String str = getUnicode.getUnicode(str1);
    if(isChinese.isChinese(str)){
        System.out.println("是中文" );

    }

       char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(char2Ascii.char2Ascii(chars[i]));
        }
        System.out.println("Ascii：" + sb.toString());
        System.out.println("输出特征值： " + GenValue.GenValue(sb.toString()));*/
       /* String content = "123214";
        String password = "123";
        System.out.println("加密之前：" + content);

        // 加密
        String encrypt = EncryptAES.encrypt(content, password);
        System.out.println("加密后的内容：" + new String(encrypt));

        // 解密
        byte[] decrypt = DecryptAES.decrypt(encrypt, password);
        System.out.println("解密后的内容：" + new String(decrypt));*/

        /*levenshtein levenshtein = new levenshtein();
        levenshtein.levenshtein("203.0.217.92","203.0.217");
        System.out.println("字符串的相似度："+ levenshtein.levenshtein("203.233.2","203.0.217"));
*/
    /* StuDaoImp stuDaoImp = new StuDaoImp();

        List<Stu> list = new ArrayList<Stu>();

        list =stuDaoImp.list1Stu();
        for(int i=0;i<list.size();i++){
            stuDaoImp.addStu(list.get(i));
            System.out.println("插入第"+i+"条成功");
        }*/


       // 需要加密的字串
      /* String cSrc = "2013011424";
        System.out.println(cSrc);
        String   password="8888";
        // 加密
        EncryptAES encryptAES = new EncryptAES();
        DecryptAES decryptAES = new DecryptAES();
        String enString = stringEncrypt.stringEncrypt(password,cSrc);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = stringDecrypt.stringDecrypt(password,enString);
        System.out.println("解密后的字串是：" + DeString);*/

/*
        //测试随机产生字符串函数
        RandomString RS = new RandomString();
        System.out.println("产生的字符串: " + RS.getRandomString(6));

        //测试产生的字符串
        SubString subString = new SubString();
        System.out.println(subString.SubString("qwertyu", 1, 2));

        //测试产生的特征值
        GenValue genValue = new GenValue();

        System.out.println("输出特征值： " + genValue.GenValue("dnegidngoeng"));
        System.out.println("afas");

        EncryptAES encryptAES1 = new EncryptAES();
        DecryptAES decryptAES1 = new DecryptAES();
        formats formats = new formats();
        String content = "这是一条明文？";
        // 加密
        byte[] encrypt = encryptAES1.encrypt1(content);
        System.out.println("加密后的内容：" + new String(encrypt));

        //如果想要加密内容不显示乱码，可以先将密文转换为16进制
        String hexStrResult = formats.parseByte2HexStr(encrypt);
        System.out.println("16进制的密文：" + hexStrResult);
*/

        //如果的到的是16进制密文，别忘了先转为2进制再解密
        //byte[] twoStrResult = formats.parseHexStr2Byte(hexStrResult);

        // 解密
        //byte[] decrypt = decryptAES1.decrypt1(encrypt);
        //System.out.println("解密后的内容：" + new String(decrypt));
/*
        //测试中文字符产生的特征值
       *//**//* GenValue genValue1 = new GenValue();
        System.out.println("测试中文产生的特征值： "+genValue.GenValue("ddengdingpeng"));*//**//*
        *//**//*String String2 = "aksjfahs";

        String2 = String2.replace(String2.charAt(0),'1');
       System.out.println("取值： "+String2);*/

    }
}

