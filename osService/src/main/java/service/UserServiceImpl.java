package service;

import dao.UserMapper;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.EncryptUtil;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        List<User> list = userMapper.queryAll();
        if (null != list)
            list.remove(0);
        return list;
    }

    ;

    @Override
    public List<User> queryByName(User user) {
        if (null != user &&
                ((user.getUsername() != null && !user.getUsername().equals(""))
                        || (user.getRealname() != null && !user.getRealname().equals("")))) {
            List<User> userList = userMapper.queryByName(user);
            //foreach遍历时删除list的元素会发生ConcurrentModificationException
            Iterator<User> iterator = userList.iterator();
            while (iterator.hasNext()) {
                User itUser = iterator.next();
                if (itUser.getUsername().equals("admin"))
                    iterator.remove();
            }
            return userList;
        }
        return null;
    }

    ;

    @Override
    @Transactional
    public List<User> updateWeight(User user) {
        userMapper.updateWeight(user);
        return userMapper.queryAll();
    }

    ;

    @Override
    @Transactional
    public List<User> deleteUser(int id) {
        User user = new User();
        user.setId(id);
        userMapper.deleteUser(user);
        return userMapper.queryAll();
    }

    @Override
    public User loginAdmin(String username, String password) {
        if (!"admin".equals(username))
            return null;
        User user = new User();
        user.setUsername(username);
        try {
            password = EncryptUtil.encryptPassword(password);
        } catch (Exception e) {
            System.out.println("密码加密异常了");
        }
        user.setPassword(password);
        user = userMapper.getByUsernameAndPassword(user);
        return user;
    }

    @Override
    public User loginUser(String username, String password) {
        if ("admin".equals(username))
            return null;
        User user = new User();
        user.setUsername(username);
        try {
            password = EncryptUtil.encryptPassword(password);
        } catch (Exception e) {
            System.out.println("密码加密异常了");
        }
        user.setPassword(password);
        user = userMapper.getByUsernameAndPassword(user);
        return user;
    }

    @Override
    public boolean existUsername(String username) {
        if (null != username && !username.trim().equals("")) {
            User user = new User();
            user.setUsername(username);
            return null != userMapper.queryUserExist(user);
        }
        return false;
    }

    @Override
    public boolean existTelephone(String telephone) {
        if (null != telephone && !telephone.trim().equals("")) {
            User user = new User();
            user.setTelephone(telephone);
            return null != userMapper.queryUserExist(user);
        }
        return false;
    }

    @Override
    public boolean existQQ(String qq) {
        if (null != qq && !qq.trim().equals("")) {
            User user = new User();
            user.setQq(qq);
            return null != userMapper.queryUserExist(user);
        }
        return false;
    }

    @Override
    @Transactional
    public User registerUser(User user) {
        if (null != user) {
            try {
                user.setPassword(EncryptUtil.encryptPassword(user.getPassword()));
            } catch (Exception e) {
                System.out.println("密码加密异常了");
            }
            if (0 != userMapper.createSelectivity(user)) {
                user = userMapper.queryByUsername(user.getUsername());
                if (null != user)
                    return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        if (null != id) {
            return userMapper.getById(id);
        }
        return null;
    }

    @Override
    public Boolean judgePassword(Integer id, String userPassword, String password, String newPassword) {
        String oldPassword = "";
        if (null != userPassword && null != password) {
            try {
                oldPassword = EncryptUtil.encryptPassword(password);
            } catch (Exception e) {
                System.out.println("密码加密异常了");
            }
        } else
            return false;

        if (null != newPassword) {
            try {
                newPassword = EncryptUtil.encryptPassword(newPassword);
            } catch (Exception e) {
                System.out.println("密码加密异常了");
            }
        } else
            return false;

        User user = new User();
        if (oldPassword.equals(userPassword)) {
            user.setId(id);
            user.setPassword(newPassword);
            userMapper.setPassword(user);
            return true;
        }
        return false;
    }

    @Override
    public void addWeight(Integer id, String weight) {
        Integer i = 0;
        User user = new User();
        if (null != weight) {
            i = Integer.parseInt(weight);
            user.setId(id);
            user.setWeight(i);
            userMapper.addWeight(user);
        }
    }

}
