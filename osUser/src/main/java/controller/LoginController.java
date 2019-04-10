package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @RequestMapping("")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        //设置模型数据，用于传递到jsp
        mav.addObject("msg","");
        //设置视图名字，用于响应用户
        mav.setViewName("/WEB-INF/page/index.jsp");

        return mav;
    }

    @Resource(name = "loginService")
    private UserService userService;

    @RequestMapping("/test/login4.do")
    public String testLogin4(User user) {
        if (userService.login(user) == false) {
            return "loginError";
        }
        return "loginSuccess";

    }
