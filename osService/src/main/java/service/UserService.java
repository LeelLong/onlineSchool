package service;

import entity.User;

import java.util.List;

public interface UserService {

    public void createSelectivity(User user);

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
    public boolean login(String username,String password);
}
