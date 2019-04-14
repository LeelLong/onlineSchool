package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;

@Controller
public class LoginAndRegistController {

    @Resource
    private UserService userService;

    @RequestMapping("users")
    public ModelAndView getUsers(){
        ModelAndView mav = new ModelAndView();

//        userService.

        return mav;
    }

}
