package cn.edu.bistu.dao;

import cn.edu.bistu.Decrypt.DecryptAES;
import cn.edu.bistu.Decrypt.numDecrypt;
import cn.edu.bistu.Decrypt.stringDecrypt;
import cn.edu.bistu.Encrypt.EncryptAES;
import cn.edu.bistu.Encrypt.numEncrypt;
import cn.edu.bistu.Encrypt.stringEncrypt;
import cn.edu.bistu.Tools.GenValue;
import cn.edu.bistu.Tools.RandomString;
import cn.edu.bistu.Tools.char2Ascii;
import cn.edu.bistu.Tools.isChinese;
import cn.edu.bistu.entity.Stu;
import cn.edu.bistu.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Decrain on 2017/3/3.
 */


public class StuDaoImp implements StuDao {


    public boolean addStu(Stu stu) throws UnsupportedEncodingException {

        stringEncrypt stringEncrypt = new stringEncrypt();

        numEncrypt numEncrypt = new numEncrypt();

        List<Stu> list = new ArrayList<Stu>();

        boolean flag = false;

        Session session = HibernateUtil.getSession();

        Transaction tx = null;




        //加密字符型数据
        RandomString randomString = new RandomString();

        String character = "";

        //获取特征值

        if(isChinese.isChinese(stu.getName())){//判断是否是中文
            System.out.println("是中文");
            char[] chars = stu.getName().toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sb.append(char2Ascii.char2Ascii(chars[i]));
            }
            character = GenValue.GenValue(sb.toString());
            System.out.println("中文字符的ASCII："+sb.toString());
            System.out.println("中文字符的特征值："+character);

        }
        else{
            System.out.println("不是中文");
            character = GenValue.GenValue(stu.getName());
            System.out.println("非中文字符的特征值："+character);
        }


        // tem2 = EncryptAES.encrypt(tem2);
        // System.out.println("加密后数据： "+ tem2);
        //System.out.println("特征值： "+ character);

        stu.setEigenVal(character);


        String tem2 = stringEncrypt.stringEncrypt(character,stu.getName());

      //  System.out.println("ID： " + character);

       /* //获取特征值
        character = GenValue.GenValue(stu.getName());

        // tem2 = EncryptAES.encrypt(tem2);
        // System.out.println("加密后数据： "+ tem2);
        System.out.println("特征值： "+ character);

        stu.setEigenVal(character);*/

        stu.setName(tem2);

        //加密数值型数据

        String encrypt = numEncrypt.numEncrypt(stu.getNum());
        // System.out.println("加密后数据"+ encrypt);

        //存取stu中
        stu.setNum(encrypt);


        try {

            tx = session.beginTransaction();
            Integer i = (Integer) session.save(stu);
            flag = i > 0;
            tx.commit();
            //session.remove(stu);

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
            session.clear();
        }
        return flag;
    }


    //显示数据
    //查询数据库的前十条记录并显示在首页

    public List<Stu> listStu() {

        List<Stu> list = new ArrayList<Stu>();


        Session session = HibernateUtil.getSession();

        DecryptAES decryptAES = new DecryptAES();

        numDecrypt numDecrypt = new numDecrypt();

        stringDecrypt stringDecrypt = new stringDecrypt();

        Transaction tx = null;


        try {
            tx = session.beginTransaction();
            String hql = "from Stu ";

            Query query = session.createQuery(hql);

            query.setFirstResult(0); //开始记录

            query.setMaxResults(10); //查询多少条

            list = query.list();

            tx.commit();


            //
            // System.out.println(newlist);
            for (int i = 0; i < 10; i++) {

                String tem6 = numDecrypt.numDecrypt(list.get(i).getNum());



                //处理数据
                list.get(i).setNum(tem6);//修改数据

                //解密字符


                String tem5 = stringDecrypt.stringDecrypt(list.get(i).getEigenVal(),list.get(i).getName());
                //System.out.println("String NAME： "+ list.get(i).getEigenVal());
                //解密后放入session中
                list.get(i).setName(tem5);//修改数据

            }


        } catch (HibernateException e) {

            if (tx != null) tx.rollback();
            e.printStackTrace();

        } finally {
            session.clear();
        }


        return list;
    }


    //按照数值查找
    public List<Stu> queryStuByNum(String num) {


        List<Stu> list = new ArrayList<Stu>();

        Session session = HibernateUtil.getSession();


        stringDecrypt stringDecrypt = new stringDecrypt();


        Transaction tx = null;


        //加密

        //设置可能的查找值
        Long temp = Long.parseLong(num);

        Long[] tem = new Long[9];

        String[] No = new String[9];


        for (int i = 0; i < 9; i++) {

            tem[i] = 10 * temp + i + 1;
            String content = String.valueOf(tem[i]);
            No[i] = EncryptAES.encrypt1(content);
        }

        try {

            tx = session.beginTransaction();
            String hql = "from Stu where " +
                    "num =:num1 " +
                    "or num=:num2 " +
                    "or num=:num3 " +
                    "or num=:num4 " +
                    "or num=:num5 " +
                    "or num=:num6 " +
                    "or num=:num7 " +
                    "or num=:num8 " +
                    "or num=:num9";

            Query query = session.createQuery(hql);

            query.setParameter("num1", No[0]);

            query.setParameter("num2", No[1]);

            query.setParameter("num3", No[2]);

            query.setParameter("num4", No[3]);

            query.setParameter("num5", No[4]);

            query.setParameter("num6", No[5]);

            query.setParameter("num7", No[6]);

            query.setParameter("num8", No[7]);

            query.setParameter("num9", No[8]);


            list = query.list();
            //System.out.println(list.get(2).getNum());
            tx.commit();


            // 不解密返回数据方法：

           /* if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setNum(num);
                }
            }*/

            if (list != null && list.size() > 0) {

                for (int i = 0; i < list.size(); i++) {

                    list.get(i).setNum(num);

                    String temp1 = stringDecrypt.stringDecrypt(list.get(i).getEigenVal(),list.get(i).getName());

                    list.get(i).setName(temp1);//修改数据*/
                }
            }

        }

        catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.clear();
        }

        return list;
    }


    //按照字符串查找
    public List<Stu> queryStuByString(String string0) {


        List<Stu> list = new ArrayList<Stu>();

        Session session = HibernateUtil.getSession();

        numDecrypt numDecrypt = new numDecrypt();

        stringDecrypt stringDecrypt = new stringDecrypt();

        String tem3;

        //SubString subString = new SubString();

        Transaction tx = null;

        //获取特征值

        if(isChinese.isChinese(string0)){//判断是否是中文

            char[] chars = string0.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sb.append(char2Ascii.char2Ascii(chars[i]));
            }
            tem3 = GenValue.GenValue(sb.toString());

            System.out.println("中文字符的特征值："+tem3);

        }

        else{
            tem3 = GenValue.GenValue(string0);
        }

        //获取输入参数string的特征值
       // String tem3 = GenValue.GenValue(string0);

        // System.out.println("特征值tem3: " + tem3);
        //System.out.println("传进来的字符串:" + string0);


        try {


            tx = session.beginTransaction();

            String hql = "from Stu where eigenVal like :ttt";

            Query query = session.createQuery(hql);

            query.setParameter("ttt", tem3);

            list = query.list();

            tx.commit();

            //System.out.println("list: " + list.toString());

            if (list != null && list.size() > 0) {

                for (int i = 0; i < list.size(); i++) {


                    //解密Num数据
                    String n = numDecrypt.numDecrypt(list.get(i).getNum());

                    list.get(i).setNum(n);//修改数据


                    //解密字符
                    // System.out.println("解密之前的数据" + list.get(i).getName());
                    //System.out.println("解密之后的数据" + decryptAES.decrypt(list.get(i).getName()));

                    String tem4 = stringDecrypt.stringDecrypt(list.get(i).getEigenVal(),list.get(i).getName());


                    //System.out.println("解密后的数据 " + tem4);
                    //System.out.println("list: " + list.get(i));

                    //解密后放入session中

                    list.get(i).setName(tem4);//修改数据


                }
            }


            // System.out.println("list: " + list.toString());

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();

            e.printStackTrace();
        } finally {
            session.clear();
        }


        return list;
    }


    //读取数据库信息
    //
    public List<Stu> list1Stu() {


        List<Stu> list = new ArrayList<Stu>();

        List<Stu> newlist = new ArrayList<Stu>();

        Session session = HibernateUtil.getSession();

        Transaction tx = null;


        try {

                tx = session.beginTransaction();

                String hql = "from Stu ";

                Query query = session.createQuery(hql);

                list = query.list();


                 tx.commit();



        } catch (HibernateException e) {

            if (tx != null) tx.rollback();

            e.printStackTrace();

        } finally {
        }


        return list;
    }


}


