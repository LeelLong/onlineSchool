package controller;

import entity.Message;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.CookieStore;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Message login(@RequestParam String username, @RequestParam String password){
        Message message = new Message();
        User user = userService.loginAdmin(username,password);
        if(null != user){
            message.setMsg("");
        } else
            message.setMsg("用户名或密码错误");
        return message;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest httpServletRequest){
        return "forward:login.jsp";
    }

    @RequestMapping("loginSuccess")
    public String loginSuccess(){
        return "admin";
    }

}
