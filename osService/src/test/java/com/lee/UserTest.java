package com.lee;

import entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserServiceImpl;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserTest {

//    @Resource
//    private UserServiceImpl userService;
    private ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:config/spring.xml");
    private UserServiceImpl userService=(UserServiceImpl) ctx.getBean("userService");

    @Test
    public void getByUsername(){
        User admin = userService.getByUsername("ai");
        System.out.print(admin.toString());
    }

    @Test
    public void createSelectivity(){
        User admin = new User("lee","ai","123",true,
                "123456789",new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime(),
                "This My Life","123789456",5);
        userService.createSelectivity(admin);
    }
}
