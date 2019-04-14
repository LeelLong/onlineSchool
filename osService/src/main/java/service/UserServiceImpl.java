package service;

import dao.UserMapper;
import entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void createSelectivity(User user) {
        if(null != user)
            userMapper.createSelectivity(user);
    };

    @Override
    public List<User> queryAll(){
        List<User> list = userMapper.queryAll();
        list.remove(0);
        return list;
    };

    @Override
    public List<User> queryByName(User user){
        if (null != user &&
                ((null != user.getUsername() && !"".equals(user.getUsername().trim())) ||
                        null != user.getRealname() && !"".equals(user.getRealname().trim())))
            return userMapper.queryByName(user);
        return null;
    };

    @Override
    public List<User> updateWeight(User user){
        userMapper.updateWeight(user);
        return userMapper.queryAll();
    };

    @Override
    public List<User> deleteUser(int id){
        User user = new User();
        user.setId(id);
        userMapper.deleteUser(user);
        return userMapper.queryAll();
    }

    @Override
    public boolean login(String username,String password){
        if (!"admin".equals(username))
            return false;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = userMapper.getByUsernameAndPassword(user);
        return null != user;
    }
}
