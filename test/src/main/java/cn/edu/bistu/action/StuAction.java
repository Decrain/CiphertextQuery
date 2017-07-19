package cn.edu.bistu.action;

import cn.edu.bistu.Decrypt.DecryptAES;
import cn.edu.bistu.Tools.levenshtein;
import cn.edu.bistu.dao.StuDaoImp;
import cn.edu.bistu.entity.Stu;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * Created by Decrain on 2017/3/3.
 */

public class StuAction extends SuperAction implements ModelDriven<Stu> {

    private static final long serialVersionUID = 1L;

    private Stu stu = new Stu();

    public String execute() throws Exception {
        return SUCCESS;
    }


    public Stu getModel() {
        return this.stu;
    }


    //添加
    public String add() throws Exception {
        StuDaoImp stuDaoImp = new StuDaoImp();
        if (stuDaoImp.addStu(stu)) {
            List<Stu> list = stuDaoImp.listStu();
            session.setAttribute("stuList", list);
            return "add_success";

        } else {
            return "add_error";
        }
    }

    //查找按照数值型数据
    public String queryByNum() {
        StuDaoImp stuDaoImp = new StuDaoImp();
        List<Stu> list = stuDaoImp.queryStuByNum(stu.getNum());
        DecryptAES decryptAES = new DecryptAES();

        //放进session中
        if (list != null && list.size() > 0) {

            session.setAttribute("StuList", list);


            //
          /*//解密数据，对于整型数据可以不解密显示

          if (list != null && list.size() > 0) {
              for (int i = 0; i < list.size(); i++) {
                  //解密
                  System.out.println("解密之前的数据" + list.get(i).getNum());
                  System.out.println("解密之前的数据" + decryptAES.decrypt(list.get(i).getNum()));
                  Long tem = Long.parseLong(decryptAES.decrypt(list.get(i).getNum()));
                  tem /= 10;  //处理数据
                  System.out.println(tem);
                  String n = String.valueOf(tem);
                  list.get(i).setNum(n);//修改数据

              }

          }*/
            //解密数据，对于整型数据可以不解密显示

          /*if (list != null && list.size() > 0) {
              for (int i = 0; i < list.size(); i++) {
                  //解密
                  //System.out.println("解密之前的数据" + list.get(i).getNum());
                  //System.out.println("解密之前的数据" + decryptAES.decrypt(list.get(i).getNum()));
                  Long temp0 = Long.parseLong(decryptAES.decrypt(list.get(i).getNum()));
                  temp0 /= 10;  //处理数据
                  System.out.println(temp0);
                  String n = String.valueOf(temp0);
                  list.get(i).setNum(n);//修改数据
                  System.out.println("按照学号查询的Name: "+ list.get(i).getName());
                  String temp1 = decryptAES.decrypt(list.get(i).getName());
                  int length00 = temp1.length();
                  temp1 = temp1.substring(0, length00 - 10);
                  list.get(i).setName(temp1);//修改数据

              }

          }*/
            return "queryNum_success";

        }
        return "queryNum_error";


    }

    //查找按照字符型数据
    public String queryByName() {
        StuDaoImp stuDaoImp = new StuDaoImp();
        List<Stu> list = stuDaoImp.queryStuByString(stu.getName());
        // System.out.println("输入的字符串："+stu.getName());


        //放进session中
        if (list != null && list.size() > 0) {





            if (list != null && list.size() > 0) {

                //二次精确查询
                for (int j = 0, len = list.size(); j < len; j++) {

                   // System.out.println("list数据" + list.get(j).getName() + " string0数据" + stu.getName());

                    if (!(list.get(j).getName().equals(stu.getName()))) {

                        list.remove(j);

                        --len;

                        j--;
                    }
                }

            }
            session.setAttribute("StuList", list);




            return "queryName_success";

        }
        return "queryName_error";


    }
    //查找按照字符型数据
    public String queryMohuName() {

        StuDaoImp stuDaoImp = new StuDaoImp();

        List<Stu> list = stuDaoImp.queryStuByString(stu.getName());

        levenshtein levenshtein = new levenshtein();
        // System.out.println("输入的字符串："+stu.getName());


        //放进session中
        if (list != null && list.size() > 0) {



            //模糊查询
            int len = list.size();

            double [] a = new double[len];

            int j = 0,k,i=0;



            if (list != null && list.size() > 0) {

               // session.setAttribute("StuList", list);

                for(i=0;i<len;i++){
                    a[i] = levenshtein.levenshtein(stu.getName(),list.get(i).getName());
                    //System.out.println("第" +i+"个"+"距离： " + a[i]);
                }

                //二次模糊查询

                for (j = 0,i=0,k = len; j < k; j++,i++) {
                    // System.out.println("list数据" + list.get(j).getName() + " string0数据" + stu.getName());
                    if (a[i]<0.5) {
                        list.remove(j);
                        --k;
                        j--;
                    }
                }

            }
            session.setAttribute("StuList", list);


          //  System.out.println("list: " + list.toString());



            return "queryMohu_success";

        }
        return "queryMohu_error";


    }
     public String retrieve(){
         /*System.out.println("首页retrieve");*/
         StuDaoImp stuDaoImp = new StuDaoImp();
         List<Stu> list = stuDaoImp.listStu();
         session.setAttribute("StuList", list);

         return "success";
     }
}


