package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1177253723201979141L;
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
    private short gender;

    /**
     *头像
     **/
    private String header;

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
     *最后一次登录时间
     **/
    private Date loginTime;

    /**
     *最后一次登录IP
     **/
    private String ip;

    /**
     *所在省份
     **/
    private String province;

    /**
     *所在城市
     **/
    private String city;

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

    public short getGender(){
        return gender;
    }
    public void setGender(short gender){
        this.gender = gender;
    }

    public String getHeader(){
        return header;
    }
    public void setHeader(String header){
        this.header = header;
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

    public Date getLoginTime(){
        return loginTime;
    }
    public void setLoginTime(Date loginTime){
        this.loginTime = loginTime;
    }

    public String getIp(){
        return ip;
    }
    public void setIp(String ip){
        this.ip = ip;
    }

    public String getProvince(){
        return province;
    }
    public void setProvince(String province){
        this.province = province;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

}

