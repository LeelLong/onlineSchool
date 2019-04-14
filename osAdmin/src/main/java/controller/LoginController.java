package controller;

import entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Message login(@RequestParam String username, @RequestParam String password){
        Message message = new Message();
        if(userService.login(username,password))
            message.setMsg("");
        else
            message.setMsg("用户名或密码错误");
        return message;
    }

    @RequestMapping("loginSuccess")
    public String login(){
        return "admin";
    }

}
