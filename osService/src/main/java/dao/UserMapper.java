package dao;

import entity.Price;
import entity.User;

import java.util.List;

public interface UserMapper{

    /**
     * 根据id获取
     **/
    public User getById(Integer id);

    /**
     * 根据username或realname查询
     */
    public List<User> queryByName(User user);

    /**
     * 更新user的权重
     */
    public void updateWeight(User user);

    /**
     * 删除user
     */
    public void deleteUser(User user);

    /**
     * 根据username 和 password获取
     */
    public User getByUsernameAndPassword(User user);

    /**
     *获取首页推荐5个讲师
     **/
    public List<User> queryTeacher();

    /**
     *获取总数量
     **/
    public Integer getTotalItemsCount(User queryUser);

    /**
     *分页获取
     **/
//    public List<User> queryPage(User queryEntity , TailPage<User> page);

    /**
     *创建新记录
     **/
    public int createSelectivity(User entity);

    /**
     *根据id更新
     **/
    public void update(User entity);

    /**
     *根据id选择性更新自动
     **/
    public void updateSelectivity(User entity);

    /**
     *物理删除
     **/
    public void delete(User entity);

    /**
     *逻辑删除
     **/
    public void deleteLogic(User entity);

    /**
     *查询全部
     **/
    public List<User> queryAll();

    /**
     *根据条件查询用户
     **/
    public Integer queryUserExist(User user);

    /**
     *根据用户名查询用户
     **/
    public User queryByUsername(String username);

    public void reduceWeight(Price price);

    public void setPassword(User user);

    public void addWeight(User user);
}
