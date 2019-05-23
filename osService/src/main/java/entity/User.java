package entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    public User(){

    }

    public User(String realname, String username, String password, Boolean gender, String telephone, Date birthday, String qq) {
        this.realname = realname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.telephone = telephone;
        this.birthday = birthday;
        this.qq = qq;
    }

    public User(Integer id, String realname, String username, String password, Boolean gender, String telephone, Date birthday, String qq, Integer weight, Date update_time, String update_user, Boolean del) {
        this.id = id;
        this.realname = realname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.telephone = telephone;
        this.birthday = birthday;
        this.qq = qq;
        this.weight = weight;
        this.update_time = update_time;
        this.update_user = update_user;
        this.del = del;
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 手机号码
     */
    private String telephone;

    /**
     * 生日日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**
     * qq号
     */
    private String qq;

    /**
     * 钱
     */
    private Integer weight;

    /**
     * 
     */
    private Date update_time;

    /**
     * 
     */
    private String update_user;

    /**
     * 
     */
    private Boolean del;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 真实姓名
     * @return realname 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 真实姓名
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 登录用户名
     * @return username 登录用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登录用户名
     * @param username 登录用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 性别
     * @return gender 性别
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 性别
     * @param gender 性别
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 手机号码
     * @return telephone 手机号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 手机号码
     * @param telephone 手机号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 生日日期
     * @return birthday 生日日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日日期
     * @param birthday 生日日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * qq号
     * @return qq qq号
     */
    public String getQq() {
        return qq;
    }

    /**
     * qq号
     * @param qq qq号
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 权重
     * @return weight 权重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 权重
     * @param weight 权重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * 
     * @param update_time 
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * 
     * @return update_user 
     */
    public String getUpdate_user() {
        return update_user;
    }

    /**
     * 
     * @param update_user 
     */
    public void setUpdate_user(String update_user) {
        this.update_user = update_user == null ? null : update_user.trim();
    }

    /**
     * 
     * @return del 
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * 
     * @param del 
     */
    public void setDel(Boolean del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", qq='" + qq + '\'' +
                ", weight=" + weight +
                ", update_time=" + update_time +
                ", update_user='" + update_user + '\'' +
                ", del=" + del +
                '}';
    }
}