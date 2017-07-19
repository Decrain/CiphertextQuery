package cn.edu.bistu.dao;

import cn.edu.bistu.entity.Stu;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Decrain on 2017/3/3.
 */
public interface StuDao {


    //添加数据
    public boolean addStu(Stu stu) throws UnsupportedEncodingException;


    //显示数据
    public List<Stu> listStu();


    //数值型查找
    public List<Stu> queryStuByNum(String num);


    //字符型查找
    public List<Stu> queryStuByString(String string);


}
