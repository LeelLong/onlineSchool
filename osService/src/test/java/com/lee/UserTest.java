package com.lee;

import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.UserServiceImpl;
import util.EncryptUtil;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class UserTest {

//    一般普通的Java类没有被spring代理，自然无法通过spring注入相关的对象
//    @Resource
//    private UserService userService;
    private ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:config/spring.xml");
    private UserServiceImpl userService=(UserServiceImpl) ctx.getBean("userService");

    @Test
    public void getByUsername(){
        User user = new User();
        user.setUsername("a");
        List<User> userList = userService.queryByName(user);
        for (User u:userList
                ) {
            System.out.println(u);
            System.out.println(u.getUsername());
            System.out.println(u.getId());
        }
    }

    @Test
    public void registerUser(){
        User admin = new User("lee","admin","123",true,
                "123456789",new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime(),
                "123789456");
        userService.registerUser(admin);
    }

    @Test
    public void queryAll(){
        List<User> userList = userService.queryAll();
        for (User u:userList
             ) {
            System.out.println(u);
            System.out.println(u.getUsername());
            System.out.println(u.getId());
            System.out.println(u.getWeight());
        }
    };

    @Test
    public void deleteUser(){
        userService.deleteUser(1);
    }

    @Test
    public void updateWeight(){
        User user = new User();
        user.setId(1);
        user.setWeight(5);
        List<User> userList = userService.updateWeight(user);
        for (User u:userList
                ) {
            System.out.println(u);
            System.out.println(u.getUsername());
            System.out.println(u.getWeight());
        }
    }

    @Test
    public void login(){
        userService.loginAdmin("admin","123");
    }

    @Test
    public void login2(){
        User user = userService.loginUser("wangyang","qwe123");
        System.out.println(user.getWeight());
    }

    @Test
    public void test(){
        Integer i = 1;
        String m = "";
        try {
            m = EncryptUtil.encryptAes(i.toString());
            System.out.println(m);
        }
        catch(Exception e){
            return;
        }
        try {
            m = EncryptUtil.decryptAes(m);
            System.out.println(m);
        }
        catch(Exception e){
            return;
        }
    }

}
