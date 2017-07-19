package cn.edu.bistu.entity;
/**
 * Created by Decrain on 2017/3/2.
 */
public class Stu {

    private int id;
    private String name;
    private String num;
    private String eigenVal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public String getEigenVal() {
        return eigenVal;
    }

    public void setEigenVal(String eigenVal) {
        this.eigenVal = eigenVal;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ",num='"+num+'\''+
                ",eigenVal='"+eigenVal+'\''+
                '}';
    }

    public Stu(){

    }

    public  Stu(int id,String name ,String num,String eigenVal){
        this.name = name;
        this.num = num;
        this.eigenVal = eigenVal;
        this.id = id;
    }

}
