package service;

import entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     */
    public List<User> queryAll();

    /**
     * 根据名字模糊查询用户
     */
    public List<User> queryByName(User user);

    /**
     * 更新权重
     */
    public List<User> updateWeight(User user);

    /**
     * 根据ID删除用户
     */
    public List<User> deleteUser(int id);

    /**
     * 判断是否管理员登录
     */
    public User loginAdmin(String username, String password);

    /**
     * 判断是否用户登录
     */
    public User loginUser(String username, String password);

    /**
     * 根据用户名查询用户是否存在
     */
    public boolean existUsername(String username);

    /**
     * 根据电话查询用户是否存在
     */
    public boolean existTelephone(String telephone);

    /**
     * 根据qq查询用户是否存在
     */
    public boolean existQQ(String qq);

    /**
     * 注册用户,成功则返回该用户全部属性
     */
    public User registerUser(User user);

    /**
     * 根据id获得用户
     */
    public User getUserById(Integer id);

    public Boolean judgePassword(Integer id, String userPassword, String password, String newPassword);

    public void addWeight(Integer id, String weight);
}
