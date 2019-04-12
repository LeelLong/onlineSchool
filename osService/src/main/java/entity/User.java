package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1177253723201979141L;

    public User(){};

    public User(String realname, String username, String password, boolean gender, String telephone, Date birthday, String sign, String qq, int weight) {
        this.realname = realname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.telephone = telephone;
        this.birthday = birthday;
        this.sign = sign;
        this.qq = qq;
        this.weight = weight;
    }

    /**
     *真实姓名
     **/
    private String realname;

    /**
     *用户名
     **/
    private String username;

    /**
     *密码
     **/
    private String password;

    /**
     *性别
     **/
    private boolean gender;

    /**
     *手机号码
     **/
    private String telephone;

    /**
     *生日
     **/
    private Date birthday;

    /**
     *签名
     **/
    private String sign;

    /**
     *qq号
     **/
    private String qq;

    /**
     *推荐权重
     **/
    private int weight;

    /**
     *删除标记
     **/
    private boolean del;

    public boolean getDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public String getRealname(){
        return realname;
    }
    public void setRealname(String realname){
        this.realname = realname;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public boolean getGender(){
        return gender;
    }
    public void setGender(boolean gender){
        this.gender = gender;
    }

    public String getTelephone(){
        return telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public String getSign(){
        return sign;
    }
    public void setSign(String sign){
        this.sign = sign;
    }

    public String getQq(){
        return qq;
    }
    public void setQq(String qq){
        this.qq = qq;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", sign='" + sign + '\'' +
                ", qq='" + qq + '\'' +
                ", weight=" + weight +
                '}';
    }
}

